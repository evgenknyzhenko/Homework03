/**
 * Created by Евгений on 11.05.2018.
 */
public class Homework03 {
    public static void main(String[] args) {
        //task_3_1();
        task_3_2();
    }

    private static void task_3_1() {

        String input = "([])[({(())})]";

        for (int i = 0; i < input.length(); i++) {
            input = input.replace("()", "");
            input = input.replace("{}", "");
            input = input.replace("[]", "");
        }

        if (input.length() == 0) {
            System.out.println("Input is correct");
        } else {
            System.out.println("input isn,t correct");
        }
    }

    //=================================

    private static void task_3_2() {

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
}
