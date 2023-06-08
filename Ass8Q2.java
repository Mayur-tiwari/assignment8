import java.util.Scanner;
import java.util.Stack;

public class Ass8Q2 {
    public static boolean checkValidString(String str) {
        Stack<Integer> leftParenthesisStack = new Stack<>();
        Stack<Integer> asteriskStack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (c == '(') {
                leftParenthesisStack.push(i);
            } else if (c == '*') {
                asteriskStack.push(i);
            } else {
                if (!leftParenthesisStack.isEmpty()) {
                    leftParenthesisStack.pop();
                } else if (!asteriskStack.isEmpty()) {
                    asteriskStack.pop();
                } else {
                    return false;
                }
            }
        }

        while (!leftParenthesisStack.isEmpty() && !asteriskStack.isEmpty()) {
            if (leftParenthesisStack.pop() > asteriskStack.pop()) {
                return false;
            }
        }

        return leftParenthesisStack.isEmpty();
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.next();

        boolean isValid = checkValidString(str);

        System.out.println(isValid);
    }
}
