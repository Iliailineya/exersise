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
        int K = random.nextInt(1, size + 1);
        System.out.println("K=" + K);
        System.out.println("K-oe порядковое в массиве A = " + Solutions.findKthStatistic(arrA, K));

    }

    //        Задача на работу с графами:
//        Напишите программу, которая принимает на вход граф в виде списка смежности и выводит все
//        мосты в графе (т.е. ребра, удаление которых делает граф несвязным).
    public static void four() {
        // Создаем случайный граф с 5 вершинами и 6 ребрами
//        Graph graph = Graph.createRandomGraph(5, 6);
        // вывести представление списка смежности Graph
//        Graph.printGraph(graph);
        List<Edge> edges = Arrays.asList(new Edge(0, 1), new Edge(1, 2),
                new Edge(2, 0), new Edge(2, 1), new Edge(3, 2),
                new Edge(4, 5), new Edge(5, 4));
        Graph graph = new Graph(edges, true);
        Graph.printGraph(graph);
        System.out.println();
        Solutions.BridgeFinder bridgeFinder = new Solutions.BridgeFinder();
        List<Edge> bridges = bridgeFinder.findBridges(graph);
        System.out.println(bridges);

    }


}
