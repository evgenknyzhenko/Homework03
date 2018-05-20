import java.nio.charset.Charset;
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

        StringBuilder input = new StringBuilder("//a/..////b/./c//.//");

        int i;

        while ((i = input.indexOf("/./")) != -1) {
            input.delete(i, i + 2);
        }

        while ((i = input.indexOf("/../")) != -1) {
            input.delete(i - 2, i + 3);
        }

        while ((i = input.indexOf("//")) != -1) {
            input.delete(i, i + 1);
        }

        while (input.charAt(input.length() - 1) == '/') {
            input.delete(input.length() - 1, input.length());
        }

        System.out.println(input);
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
