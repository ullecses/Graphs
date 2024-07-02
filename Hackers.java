import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.List;

public class Hackers {
    public static List<Integer>[] graph, inverseGraph;
    public static int components = 0, n, minWeight, vertexNumber;
    public static boolean[] visited;
    public static int[] component, terminals;
    public static ArrayList<StronglyConnectedComponent> comp = new ArrayList<>();
    public static ArrayList<Integer> forRemove = new ArrayList<>(), ordered = new ArrayList<>();

    public static void main(String[] args) throws FileNotFoundException {
        FastReader in = new FastReader();
        PrintWriter out = new PrintWriter("output.txt");
        n = in.nextInt();
        visited = new boolean[n];
        terminals = new int[n];
        component = new int[n];
        graph = new ArrayList[n];
        inverseGraph = new ArrayList[n];
        int u, v;
        for (int i = 0; i < n; i++) {
            terminals[i] = in.nextInt();
            graph[i] = new ArrayList<>();
            inverseGraph[i] = new ArrayList<>();
        }
        while (true) {
            u = in.nextInt();
            v = in.nextInt();

            if (u == 0 && v == 0) {
                break;
            } else {
                graph[u - 1].add(v - 1);
                inverseGraph[v - 1].add(u - 1);
            }
        }
        out.print(func());
        out.flush();
        out.close();
    }
    public static void dfs(int vertex) {
        visited[vertex] = true;
        for (int i = 0; i < graph[vertex].size(); i++) {
            int nextVertex = graph[vertex].get(i);
            if (!visited[nextVertex]) {
                dfs(nextVertex);
            }
        }
        ordered.add(vertex);
    }
    public static void dfs2(int vertex) {
        visited[vertex] = true;
        component[vertex] = components;
        for (int i = 0; i < inverseGraph[vertex].size(); i++) {
            int nextVertex = inverseGraph[vertex].get(i);
            if (!visited[nextVertex]) {
                if (minWeight > terminals[nextVertex]) {
                    minWeight = terminals[nextVertex];
                    vertexNumber = nextVertex + 1;
                }
                dfs2(nextVertex);
            }
        }
        ordered.add(vertex);
    }

    public static void directionOfConnections() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                if (component[graph[i].get(j)] != component[i]) {
                    forRemove.add(component[graph[i].get(j)]);
                }
            }
        }
    }
    public static String func() {
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i);
            }
        }
        for (int i = 0; i < n; i++) {
            visited[i] = false;
        }
        for (int i = n - 1; i >= 0; i--) {
            minWeight = Integer.MAX_VALUE;
            vertexNumber = -1;
            if (!visited[ordered.get(i)]) {
                minWeight = terminals[ordered.get(i)];
                vertexNumber = ordered.get(i) + 1;
                dfs2(ordered.get(i));
                comp.add(new StronglyConnectedComponent(components, minWeight, vertexNumber));
                components++;
            }
        }
        directionOfConnections();
        int counter = 0;
        StringBuilder str = new StringBuilder();
        for (StronglyConnectedComponent obj : comp) {
            boolean isFound = false;
            for (int number : forRemove) {
                if (number == obj.componentNumber) {
                    isFound = true;
                    break; // Если число найдено, прерываем цикл
                }
            }
            if (!isFound) {
                str.append(obj.getMainVertex() + " ");
                counter++;
            }
        }
        String s = counter + "\n" + str;
        return s;
    }
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() throws FileNotFoundException {
            br = new BufferedReader(new FileReader("input.txt"));
        }
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
    public static class StronglyConnectedComponent {
        private int weight;
        private int componentNumber;
        private int mainVertex;

        public StronglyConnectedComponent(int componentNumber, int weight, int mainVertex) {
            this.weight = weight;
            this.componentNumber = componentNumber;
            this.mainVertex = mainVertex;
        }
        public int getMainVertex() {
            return mainVertex;
        }
    }
}