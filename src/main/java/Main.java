import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IllegalArgumentException {
        while (true) {
            String input = new Scanner(System.in).nextLine();
            String conclusion = calc(input);
            System.out.println(conclusion);
        }
    }

    public static String calc(String input) throws IllegalArgumentException {
        int result;
        String regex = "(10|[1-9])\\s[+*/\\-]\\s(10|[1-9])";
        if (!input.matches(regex)) {
            throw new IllegalArgumentException("Формат математической операции не удовлетворяет заданию - " +
                    "два операнда (от 1 до 10) и один оператор (+, -, /, *)");
        }
        String[] args = input.split(" ");
        int arg1 = Integer.parseInt(args[0]);
        int arg2 = Integer.parseInt(args[2]);
        String operator = args[1];
        switch (operator) {
            case "+":
                result = (arg1 + arg2);
                break;
            case "-":
                result = (arg1 - arg2);
                break;
            case "*":
                result = (arg1 * arg2);
                break;
            case "/":
                result = (arg1 / arg2);
                break;
            default:
                throw new IllegalArgumentException("Несуществующий оператор");
        }
        return String.valueOf(result);
    }

}
