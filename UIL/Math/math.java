/*
 * You have recently been hired by a new start-up company, Calc. They intend to
 * make a program that solves
 * mathematical expressions. Because you are their only programmer it is your
 * job to write said program. The
 * expressions will only contain the following mathematical operators +,-,*, and
 * / which represent add, subtract,
 * multiply, and divide respectively. Take in mind that the expressions may
 * contain multiple parenthesis. Follow the
 * standard order of operations to solve each expression.
 * Input
 * An integer N will denominate the number of test cases. The following N line
 * will contain an
 * expression. The expression will only contain integers and the operators
 * specified in the
 * description. Negatives will be denoted as -#.
 * Output
 * You are to output the result of each expression on its own separate line. The
 * answer will be
 * rounded to the hundreds place.
 * Example Input File
 * 3
 * 2+2
 * 2*(2+2)
 * 1/2
 * Example Output to Screen
 * 4.00
 * 8.00
 * 0.50
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.Stack;

public class math {
  public static void main(String[] args) throws FileNotFoundException {
    String inputFile = "C:\\Users\\rtkel\\Documents\\School\\UIL\\Math\\math.dat";

    Scanner scanner = new Scanner(new File(inputFile));
    int N = scanner.nextInt(); // Number of test cases
    scanner.nextLine(); // Consume the newline character

    DecimalFormat df = new DecimalFormat("0.00");

    for (int i = 0; i < N; i++) {
      String expression = scanner.nextLine();
      double result = evaluateExpression(expression);
      System.out.println(df.format(result));
    }

    scanner.close();
  }

  private static double evaluateExpression(String expression) {
    Stack<Double> values = new Stack<>();
    Stack<Character> ops = new Stack<>();
    char[] tokens = expression.toCharArray();

    for (int i = 0; i < tokens.length; i++) {
      if (tokens[i] >= '0' && tokens[i] <= '9' || (tokens[i] == '-' && (i == 0 || tokens[i - 1] == '('
          || tokens[i - 1] == '+' || tokens[i - 1] == '-' || tokens[i - 1] == '*' || tokens[i - 1] == '/'))) {
        int start = i;
        if (tokens[i] == '-') {
          i++;
        }
        while (i < tokens.length && (tokens[i] >= '0' && tokens[i] <= '9' || tokens[i] == '.')) {
          i++;
        }
        values.push(Double.parseDouble(expression.substring(start, i)));
        i--;
      } else if (tokens[i] == '(') {
        ops.push(tokens[i]);
      } else if (tokens[i] == ')') {
        while (ops.peek() != '(') {
          values.push(applyOp(ops.pop(), values.pop(), values.pop()));
        }
        ops.pop();
      } else if (tokens[i] == '+' || tokens[i] == '-' || tokens[i] == '*' || tokens[i] == '/') {
        while (!ops.isEmpty() && hasPrecedence(tokens[i], ops.peek())) {
          values.push(applyOp(ops.pop(), values.pop(), values.pop()));
        }
        ops.push(tokens[i]);
      }
    }

    while (!ops.isEmpty()) {
      values.push(applyOp(ops.pop(), values.pop(), values.pop()));
    }

    return values.pop();
  }

  private static boolean hasPrecedence(char op1, char op2) {
    if (op2 == '(' || op2 == ')') {
      return false;
    }
    if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')) {
      return false;
    }
    return true;
  }

  private static double applyOp(char op, double b, double a) {
    switch (op) {
      case '+':
        return a + b;
      case '-':
        return a - b;
      case '*':
        return a * b;
      case '/':
        return a / b;
    }
    return 0;
  }
}