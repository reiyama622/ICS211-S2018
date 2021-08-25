/**
 * 
 */

package edu.ics211.h06;

import java.util.Stack;

/**
 * calculates postFix equations.
 * 
 * @author Rei Yamamoto helped by Branden Ogata
 *
 */
public class PostFixCalculator {
  private static PostFixCalculator instance;


  /**
   * returns the singleton.
   * 
   * @return instance the singleton
   */
  public static PostFixCalculator getInstance() {
    if (instance == null) {
      instance = new PostFixCalculator();
    }
    return instance;
  }


  /**
   * Calculates the answer to the postfix expression and return the result as a Number. 
   * Modified code from ICS 211 textbook page 163-164.
   * 
   * @param expression a String the postfix expression.
   * @return the result of the postfix expression as a Number.
   * @throws InvalidExpressionException if the expression isn't valid postfix.
   */
  public static Number calculate(String expression) throws InvalidExpressionException {
    Stack<Number> stack = new Stack<>();
    String[] items = expression.split(" ");
    for (int i = 0; i < items.length; i++) {
      String x = items[i];
      try {
        int inte = Integer.parseInt(x);
        stack.push(inte);
      } catch (NumberFormatException notInt) {
        try {
          double dub = Double.parseDouble(items[i]);
          stack.push(dub);
        } catch (NumberFormatException notDouble) {
          Number sec = stack.pop();
          Number first = stack.pop();
          if (sec instanceof Integer && first instanceof Integer) {
            if (x.equals("+")) {
              stack.push(first.intValue() + sec.intValue());
            } else if (x.equals("-")) {
              stack.push(first.intValue() - sec.intValue());
            } else if (x.equals("/")) {
              stack.push(first.intValue() / sec.intValue());
            } else if (x.equals("*")) {
              stack.push(first.intValue() * sec.intValue());
            }
          } else {
            if (x.equals("+")) {
              stack.push(first.doubleValue() + sec.doubleValue());
            } else if (x.equals("-")) {
              stack.push(first.doubleValue() - sec.doubleValue());
            } else if (x.equals("/")) {
              stack.push(first.doubleValue() / sec.doubleValue());
            } else if (x.equals("*")) {
              stack.push(first.doubleValue() * sec.doubleValue());
            }
          }
        }
      }
    }
    Number a = stack.pop();
    return a;
  }
}