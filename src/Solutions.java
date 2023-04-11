import java.util.*;

@SuppressWarnings("unused")
public class Solutions {

    /*
     * Метод возвращает список всех простых чисел от 2 до num в виде списка
     *
     * @param num - верхняя граница диапазона чисел, в котором ищем простые числа
     * @return список всех простых чисел от 2 до num
     */
    public static List<Integer> primeNumbers(Integer num) {
        List<Integer> primeNum = new ArrayList<>(); // создаем список для хранения простых чисел
        boolean[] isPrime = new boolean[num + 1]; // создаем массив флагов для отметки чисел, которые не являются простыми
        Arrays.fill(isPrime, true); // заполняем массив флагов значением true

        // Поиск простых чисел от 2 до num
        for (int i = 2; i * i <= num; i++) { // проходим по числам от 2 до sqrt(num)
            if (isPrime[i]) { // если i является простым числом
                for (int j = i * i; j <= num; j += i) { // проходим по кратным числам и отмечаем их как непростые
                    isPrime[j] = false;
                }
            }
        }

        // Добавление простых чисел в список
        for (int i = 2; i <= num; i++) { // проходим по числам от 2 до num
            if (isPrime[i]) { // если i является простым числом
                primeNum.add(i); // добавляем его в список простых чисел
            }
        }

        return primeNum; // возвращаем список простых чисел
    }


    /*
     * Метод, который проверяет, является ли строка палиндромом. Если строка равна null, метод возвращает "NO".
     * @param str - строка, которую нужно проверить на палиндром
     * @return "YES", если строка является палиндромом, и "NO", если нет.
     */
    public static String findPalindrome(String str) {
        //Проверяем, является ли строка null.
        if (str == null) {
            return "NO";
        }
        //Создаем StringBuilder reversedStr для хранения обратной копии исходной строки.
        StringBuilder reversedStr = new StringBuilder();

        //Проходимся по исходной строке str в обратном порядке и добавляем каждый символ в reversedStr.
        for (int i = str.length() - 1; i >= 0; i--) {
            reversedStr.append(str.charAt(i));
        }
        return reversedStr.toString().equals(str) ? "YES" : "NO";
    }

    public static int findKthStatistic(int[] arr, int k) {
        Arrays.sort(arr); // сортировка массива по возрастанию
        System.out.println(Arrays.toString(arr));
        return arr[k - 1]; // возвращаем K-ый элемент массива (индексация массивов начинается с 0)
    }

    public static class BridgeFinder {
        private int time;

        public List<Edge> findBridges(Graph graph) {
            List<Edge> bridges = new ArrayList<>();
            int n = graph.getNumVertices();
            boolean[] visited = new boolean[n];
            int[] disc = new int[n];
            int[] low = new int[n];
            int[] parent = new int[n];

            // Инициализируем массивы
            Arrays.fill(visited, false);
            Arrays.fill(parent, -1);

            // Запускаем поиск мостов из каждой непосещенной вершины
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    dfs(i, visited, disc, low, parent, bridges, graph);
                }
            }

            return bridges;
        }

        private void dfs(int u, boolean[] visited, int[] disc, int[] low, int[] parent, List<Edge> bridges, Graph graph) {
            visited[u] = true;
            disc[u] = low[u] = ++time;

            for (int v : graph.getAdjacentVertices(u)) {
                if (!visited[v]) {
                    parent[v] = u;
                    dfs(v, visited, disc, low, parent, bridges, graph);

                    // Проверяем, является ли ребро (u, v) мостом
                    low[u] = Math.min(low[u], low[v]);
                    if (low[v] > disc[u]) {
                        bridges.add(new Edge(u, v));
                    }
                } else if (v != parent[u]) {
                    low[u] = Math.min(low[u], disc[v]);
                }
            }
        }
    }
}
