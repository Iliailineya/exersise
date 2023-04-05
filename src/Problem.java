import java.util.*;

public class Problem {

    //  Задача на поиск простых чисел:
    //  Напишите программу, которая принимает на вход число N и выводит все простые числа от 1 до N.
    public static void one() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число:");

        try {
            int num = scanner.nextInt();
            try {
                System.out.println("\nПростые числа от 1 до " + num + ":\n" + Utility.measureStaticMethodExecutionTime("Solutions", "primeNumbers", num));
            } catch (Exception e) {
                System.out.println("Ошибка: Неверное имя метода");
            }
        } catch (
                InputMismatchException e) {
            System.out.println("Ошибка: вы ввели неверный формат числа");
        }
    }

    //    Задача:
    //    Дана строка S, состоящая из латинских букв в нижнем регистре.
    //    Написать программу, которая определяет, является ли эта строка палиндромом.
    //    Входные данные:
    //    Строка S, состоящая из не более чем 10000 латинских букв в нижнем регистре.
    //    Выходные данные:
    //    Вывести "YES", если строка является палиндромом, и "NO" в противном случае.

    public static void two() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите слово или предложение:");
        try {
            String str = scanner.nextLine();
            try {
                System.out.println(Utility.measureStaticMethodExecutionTime("Solutions", "findPalindrome", str.toLowerCase()));
            } catch (Exception e) {
                System.out.println("Ошибка: Неверное имя метода");
            }
        } catch (
                InputMismatchException e) {
            System.out.println("Ошибка: вы ввели неверный формат");
        }
    }

    //    Задача на работу с массивами:
    //    Напишите программу, которая принимает на вход массив целых чисел A и число K,
    //    и выводит K-ую порядковую статистику в массиве A (т.е. K-ое наименьшее число в массиве).
    public static void three() {
        int size = 20;
        int[] arrA = new int[size];
        Utility.fillArray(arrA);

        System.out.println(Arrays.toString(arrA));

        Random random = new Random();
        int K = random.nextInt(size + 1);
        System.out.println("K=" + K);
        System.out.println("K-oe порядковое в массиве A = " + Solutions.findKthStatistic(arrA, K));

    }
}
