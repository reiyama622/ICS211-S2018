/**
 * 
 */
package edu.ics211.h06;

/** Outputs the answer to the postFix equation.
 * @author Rei Yamamoto
 *
 */
public class UserInputTest {

  /** Outputs the answer to a postFix equation from the user.
   * TextIO from ics111 testbook
   * @param args not used
   * @throws InvalidExpressionException throws exception id the input is invalid.
   */
  public static void main(String[] args) throws InvalidExpressionException {
    // TODO Auto-generated method stub
    System.out.println("Write your expression");
    String in = TextIO.getln();
    System.out.println(PostFixCalculator.calculate(in));
}
}