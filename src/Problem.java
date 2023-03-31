import java.util.*;

public class Problem {

    //Задача на поиск простых чисел:
    // Напишите программу, которая принимает на вход число N и выводит все простые числа от 1 до N.
    public static void one() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число:");
        try {
            int num = scanner.nextInt();

            System.out.println("\nПростые числа от 1 до " + num + ":\n" + Solutions.primeNumbers(num));
        } catch (
                InputMismatchException e) {
            System.out.println("Ошибка: вы ввели неверный формат числа");
        }
    }
}
