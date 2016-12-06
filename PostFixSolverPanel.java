import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.IOException;
/**
 * PostFixSolverPanel.java - Creates layout for graphical user interface for Post-Fix Expression solver
 * and handles event listeners for the program.
 * 
 * @author Justin Watts
 * @version 3/2/2015
 */
public class PostFixSolverPanel extends JPanel
{
    private JButton clear, solve;
    private JPanel buttonPanel, postFixPanel, resultPanel;
    private JLabel inputLabel, outputLabel, resultLabel;
    private JTextField postFix;

    /**
     * Constructor: Sets up the Post-Fix Solver GUI
     */
    public PostFixSolverPanel()
    {
        setLayout(new BorderLayout());
        
        clear = new JButton("Clear");
        solve = new JButton("Solve");
        ClearButtonListener clearListener = new ClearButtonListener();
        SolveButtonListener solveListener = new SolveButtonListener();
        clear.addActionListener(clearListener);
        solve.addActionListener(solveListener);
        
        inputLabel = new JLabel ("Post-Fix Expression");
        outputLabel = new JLabel ("Result");
        resultLabel = new JLabel ("");
        inputLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        outputLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        resultLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        postFix = new JTextField(15);
        postFix.addKeyListener(new TempListener());
        
        buttonPanel = new JPanel();
        buttonPanel.setPreferredSize(new Dimension(200, 50));
        buttonPanel.add(clear);
        buttonPanel.add(solve);
        
        postFixPanel = new JPanel();
        postFixPanel.setLayout(new BoxLayout(postFixPanel, BoxLayout.Y_AXIS));
        postFixPanel.add(inputLabel);
        postFixPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        postFixPanel.add(postFix);
        
        resultPanel = new JPanel();
        resultPanel.setLayout(new BoxLayout(resultPanel, BoxLayout.Y_AXIS));
        resultPanel.setPreferredSize(new Dimension(200, 50));
        resultPanel.add(outputLabel);
        resultPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        resultPanel.add(resultLabel);
        
        setPreferredSize(new Dimension(240, 160));
        add(postFixPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(resultPanel, BorderLayout.SOUTH);
    }
    
    /**
     * Represents a listener for the postFix JTextField
     */
    private class TempListener implements KeyListener
    {
        /**
         * Empty definition for unused event
         */
        public void keyPressed(KeyEvent event)
        {}
        /**
         * Empty definition for unused event
         */
        public void keyReleased(KeyEvent event)
        {}
        /**
         * Clears the output field of the Post-Fix Solver upon receiving input
         * @param event event which occurs when a character is typed
         */
        public void keyTyped(KeyEvent event)
        {
            resultLabel.setText("");
        }
    }
    
    /**
     * Represents a listener for the clear button
     */
    private class ClearButtonListener implements ActionListener
    {
        /**
         * Clears the input and output fields of the Post-Fix Solver
         * @param event event which occurs when "Clear" button is pressed
         */
        public void actionPerformed(ActionEvent event)
        {
            postFix.setText("");
            resultLabel.setText("");
        }
    }
    
    /**
     * Represents a listener for the solve button
     */
    private class SolveButtonListener implements ActionListener
    {
        /**
         * Solves the input Post-Fix Expression
         * @param event event which occurs when "Solve" button is pressed
         */
        public void actionPerformed(ActionEvent event)
        {
            PostFix solver = new PostFix();
            int result = 0;
            
            String text = postFix.getText();
            try
            {
                result = solver.evaluate(text);
                resultLabel.setText(Integer.toString(result));
            }
            catch (Exception e)
            {
                resultLabel.setText("Error: Invalid Expression");
            }
        }
    }
}