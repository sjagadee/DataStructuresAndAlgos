package miscellaneous;

import java.util.Stack;

/**
 * Created by srinivas on 2/27/17.
 *
 * this is to check if the brackets are valid or not
 */
public class BracketsChecker {

    private static String[] bracketsCheck(String[] values) {
        String[] res = new String[values.length];
        Stack<Character> stack = new Stack<>();
        boolean isCorrect = true;
        for (int j = 0; j < values.length; j++) {
            for (int i = 0; i < values[j].length(); i++) {
                String str = values[j];
                if (str.charAt(i) == '{' || str.charAt(i) == '[' || str.charAt(i) == '(') {
                    stack.push(str.charAt(i));
                } else if (str.charAt(i) == '}' && stack.peek() == '{') {
                    stack.pop();
                } else if (str.charAt(i) == ']' && stack.peek() == '[') {
                    stack.pop();
                } else if (str.charAt(i) == ')' && stack.peek() == '(') {
                    stack.pop();
                } else {
                    isCorrect = false;
                }

            }
            if(isCorrect) {
                res[j] = "YES";
            } else {
                res[j] = "NO";
            }

        }
        return res;
    }

    public static void main(String[] args) {
        String[] input = {"[{(){}}{()(){}[]}]", "{{{}{}{[]({}}[()()]}}"};
        String[] res = bracketsCheck(input);
        for(String r: res) {
            System.out.println(r);
        }
    }

}
