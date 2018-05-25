
import java.util.Stack;

/**
 * Created by Евгений on 11.05.2018.
 */

public class Homework03 {
    public static void main(String[] args) {
        task_3_1();
        //task_3_2();
    }


    private static void task_3_1() {

        String input = "sss/a//.///ab/.././//bc/./cd/../da//..//.//";
        char[] chars = input.toCharArray();

        Stack<Character> stack = new Stack<>();
        stack.push('/');

        int startChar = 0;

        while (chars[startChar] != '/') {
            startChar++;
        }

        for (int i = startChar; i < chars.length; i++) {

            if (stack.peek() == '/' && chars[i] == '/') {
                continue;
            }

            if (stack.peek() == '/' && chars[i] == '.' && chars[i + 1] == '/') {
                i++;
                continue;
            }

            if (stack.peek() == '/' && chars[i] == '.' && chars[i + 1] == '.' && chars[i + 2] == '/') {
                stack.pop();
                i += 2;
                while (stack.peek() != '/') {
                    stack.pop();
                }
                continue;
            }

            stack.push(chars[i]);
        }

        if (stack.peek() == '/') {
            stack.pop();
        }

        stack.forEach(System.out::print);
    }

    //=================================

    private static void task_3_2() {

        String input = "([])[({(())})]";

        Stack<Character> stack = new Stack<>();

        switch (input.charAt(0)) {
            case ')':
            case ']':
            case '}':
                System.out.println("input isn,t correct");
                return;
        }

        switch (input.charAt(input.length() - 1)) {
            case '(':
            case '[':
            case '{':
                System.out.println("input isn,t correct");
                return;
        }

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(' || input.charAt(i) == '[' || input.charAt(i) == '{') {
                stack.push(input.charAt(i));

            } else if (input.charAt(i) == ')' && stack.peek() == '(') {
                stack.pop();

            } else if (input.charAt(i) == ']' && stack.peek() == '[') {
                stack.pop();

            } else if (input.charAt(i) == '}' && stack.peek() == '{') {
                stack.pop();

            } else {
                System.out.println("input isn,t correct");
                return;
            }
        }
        System.out.println("input is correct");
    }

}
