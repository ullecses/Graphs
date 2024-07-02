import java.util.*;

public class MaxFlow {
    static int[][] capacity;
    static int[][] flow;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        capacity = new int[n][n];
        flow = new int[n][n];
        visited = new boolean[n];

        for (int i = 0; i < m; i++)  {
            int u = sc.nextInt() - 1;
            int v = sc.nextInt() - 1;
            int w = sc.nextInt();
            capacity[u][v] += w;
        }

        int maxFlow = 0;
        while (true) {
            int newFlow = findPath(0, n - 1, Integer.MAX_VALUE);
            if (newFlow == 0) break;
            maxFlow += newFlow;
            Arrays.fill(visited, false);
        }

        System.out.println(maxFlow);
    }

    static int findPath(int u, int t, int minFlow) {
        if (u == t) return minFlow;
        visited[u] = true;
        for (int v = 0; v < visited.length; v++) {
            if (!visited[v] && capacity[u][v] - flow[u][v] > 0) {
                int newFlow = findPath(v, t, Math.min(minFlow, capacity[u][v] - flow[u][v]));
                if (newFlow > 0) {
                    flow[u][v] += newFlow;
                    flow[v][u] -= newFlow;
                    return newFlow;
                }
            }
        }
        return 0;
    }
}