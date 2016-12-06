import java.util.Stack;
import java.util.Scanner;
/**
 * PostFix.java - Contains methods to accept and evaluate post-fix expressions.
 * 
 * @author Justin Watts (Referenced from Textbook)
 * @version 3/2/2015
 */
public class PostFix
{
    private final static char ADD = '+';
    private final static char SUBTRACT = '-';
    private final static char MULTIPLY = '*';
    private final static char DIVIDE = '/';
    private Stack<Integer> stack;
    
    /**
     * Sets up evalutator by creating a new stack.
     */
    public PostFix()
    {
        stack = new Stack<Integer>();
    }
    
    /**
     * Evaluates the specified post-fix expression. If an operand is
     * encountered, it is pushed onto the stack. If an operator is
     * encountered, two operands are popped, the operation is
     * evaluated, and the result ispushed onto the stack.
     * @param expr string representation of the post-fix expression
     * @return value of the given expression
     */
    public int evaluate(String expr)
    {
        int op1, op2, result = 0;
        String token;
        Scanner parser = new Scanner(expr);
        while (parser.hasNext())
        {
            token = parser.next();
            if (isOperator(token))
            {
                op2 = (stack.pop()).intValue();
                op1 = (stack.pop()).intValue();
                result = evaluateSingleOperator(token.charAt(0), op1, op2);
                stack.push(new Integer(result));
            }
            else
                stack.push(new Integer(Integer.parseInt(token)));
        }
        return result;
    }
    
    /**
     * Determines if the specified token is an operator.
     * @param token the token to be evaluated
     * @return true if token is operator
     */
    private boolean isOperator(String token)
    {
        return (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/"));
    }
    
    /**
     * Performs integer evaluation on a single expression consisting of
     * the specified operator and operands.
     * @param operation operation to be performed
     * @param op1 the first operand
     * @param op2 the second operand
     * @return value of the expression
     */
    private int evaluateSingleOperator(char operation, int op1, int op2)
    {
        int result = 0;
        switch (operation)
        {
            case ADD:
                result = op1 + op2;
                break;
            case SUBTRACT:
                result = op1 - op2;
                break;
            case MULTIPLY:
                result = op1 * op2;
                break;
            case DIVIDE:
                result = op1 / op2;
        }
        return result;
    }
}