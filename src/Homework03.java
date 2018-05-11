/**
 * Created by Евгений on 11.05.2018.
 */
public class Homework03 {
    public static void main(String[] args) {
        task_3_1();
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
}
