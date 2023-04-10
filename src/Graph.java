import java.util.*;

// Класс для хранения ребра Graph
class Edge {
    int src, dest;

    Edge(int src, int dest) {
        this.src = src;
        this.dest = dest;
    }
}

// Класс для представления graphического объекта
class Graph {
    // Список списков для представления списка смежности
    List<List<Integer>> adjList = new ArrayList<>();

    // Конструктор для построения Graphа
    public Graph(List<Edge> edges) {
        // найти вершину с максимальным номером
        int n = 0;
        for (Edge e : edges) {
            int max = Math.max(e.src, e.dest);
            if (max > n) {
                n = max;
            }
        }

        // выделяем память для списка смежности
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }

        // добавляем ребра в ориентированный graph
        for (Edge current : edges) {
            // выделяем новый узел в списке смежности от src до dest
            adjList.get(current.src).add(current.dest);

            // раскомментировать строку ниже для неориентированного Graph

            // выделяем новый узел в списке смежности от места назначения до источника
//            adjList.get(current.dest).add(current.src);
        }
    }

    // Функция для печати представления списка смежности Graph
    public static void printGraph(Graph graph) {
        for (int src = 0; src < graph.adjList.size(); src++) {
            // вывести текущую вершину и все соседние с ней вершины
            for (int dest : graph.adjList.get(src)) {
                System.out.print("(" + src + " ——> " + dest + ")\t");
            }
            System.out.println();
        }
    }

    public static Graph createRandomGraph(int vertex, int edge) {
        Random random = new Random();
        Set<Edge> edgesSet = new HashSet<>();
        while (edgesSet.size() < edge) {
            int src = random.nextInt(vertex);
            int dest = random.nextInt(vertex);
            if (src != dest) {
                Edge e = new Edge(src, dest);
                edgesSet.add(e);
            }
        }
        List<Edge> edges = new ArrayList<>(edgesSet);
        return new Graph(edges);
    }

}