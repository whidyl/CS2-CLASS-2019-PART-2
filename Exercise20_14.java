import java.lang.RuntimeException;

public class Exercise20_14 {
    
  public static void main(String[] args) {
    String[] expressions = {"2 3 + 7 *", "2 6 + 9 /","14 2 + 160 /","99 2 + 50 / 24 -", "100 4 / 3 * 20 +",
                            "14 3 * 19 + 12 / 3 + 7 *","23 7 + 10 * 14 + 19 - 22 * 16 /"};
    
    for (String e: expressions) {
      System.out.println("expression " + e + "evaluates to " + evaluateExpression(e));
    }
  }

  /** Evaluate an expression */
  public static int evaluateExpression(String expression) {
    // Create operandStack to store operands
    MyStack operandStack = new MyStack();
    
    // Extract operands and operators
    java.util.StringTokenizer tokens =
      new java.util.StringTokenizer(expression, " +-/*%", true);

    // Phase 1: Scan tokens
    while (tokens.hasMoreTokens()) {
      String token = tokens.nextToken().trim(); // Extract a token
      if (token.length() == 0) { // Blank space
        continue; // Back to the while loop to extract the next token
      }
      else if (token.charAt(0) == '+' || token.charAt(0) == '-' ||
        token.charAt(0) == '*' || token.charAt(0) == '/') {
        processAnOperator(token.charAt(0), operandStack);
      }
      else { // An operand scanned
        // Push an operand to the stack
        operandStack.push(new Integer(token));
      }
    }

    // Return the result
    return ((Integer)(operandStack.pop())).intValue();
  }

  /** Process one operator: Take an operator from operatorStack and
   *  apply it on the operands in the operandStack */
  public static void processAnOperator(char op, MyStack operandStack) {
      int op1;
      int op2;
      
      switch(op){
        case '+':
            op1 = (Integer) (operandStack.pop());
            op2 = (Integer) (operandStack.pop());
            operandStack.push(op2 + op1);
            break;
        case '-':
            op1 = (Integer) (operandStack.pop());
            op2 = (Integer) (operandStack.pop());
            operandStack.push(new Integer(op2 - op1));
            break; 
        case '*':
            op1 = (Integer) (operandStack.pop());
            op2 = (Integer) (operandStack.pop());
            operandStack.push(new Integer(op2 * op1));
            break;
        case '/':
            op1 = (Integer) (operandStack.pop());
            op2 = (Integer) (operandStack.pop());
            operandStack.push(new Integer(op2 / op1));
            break;
        default:
            throw (new RuntimeException("Unsupported arithmetic operation found."));
      }
          
  }
}
