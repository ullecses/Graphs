import java.io.*;
import java.util.*;
public class Dijkstra {
    public static void main(String[] args) throws IOException {
        FastReader reader = new FastReader();
        BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));

        int n = reader.nextInt();
        int m = reader.nextInt();

        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            long u = reader.nextInt();
            long v = reader.nextInt();
            long w = reader.nextInt();
            graph.get((int) u).add(new Edge((int) v, w));
            graph.get((int) v).add(new Edge((int) u, w));
        }

        long shortestPath = dijkstra(graph, n);

        writer.write(Long.toString(shortestPath));

        writer.flush();
        writer.close();
    }

    private static long dijkstra(List<List<Edge>> graph, int n) {
        long[] dist = new long[n + 1];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[1] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(1, 0));

        while (!pq.isEmpty()) {
            Edge curr = pq.poll();
            int u = curr.v;
            long w = curr.w;

            if (w > dist[u]) {
                continue;
            }

            for (Edge neighbor : graph.get(u)) {
                int v = neighbor.v;
                long weight = neighbor.w;

                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.offer(new Edge(v, dist[v]));
                }
            }
        }

        return dist[n];
    }

    static class Edge implements Comparable<Edge> {
        int v;
        long w;

        Edge(int v, long w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Edge other) {
            return Long.compare(this.w, other.w);
        }
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
}

