import javax.swing.JFrame;
/**
 * PostFixSolver.java - Instantiates graphical user interface for Post-Fix Expression solver.
 * 
 * @author Justin Watts 
 * @version 3/2/2015
 */
public class PostFixSolver
{
    /**
     * Creates and displays the main program frame.
     */
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Post-Fix Expression Solver");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.getContentPane().add(new PostFixSolverPanel());
        
        frame.pack();
        frame.setVisible(true);
    }
}