import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        //Пользователь вводит число. Если произошла ошибка ввода, выведите пользователю сообщение о том, что ввод некорректный
        Scanner scanner = new Scanner(System.in);
        try {
            int input = scanner.nextInt();
            System.out.println(input);

        } catch (Exception exception) {
            throw new RuntimeException("Error ");
        }

    }
}