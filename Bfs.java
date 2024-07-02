import java.io.*;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Bfs {
    static int [][] matrix;
    static boolean[] visited;
    static int n;
    static int[] res;
    static int k = 0, u;

    public static void main(String[] args) throws FileNotFoundException {
        FastReader in = new FastReader();
        PrintWriter out = new PrintWriter("output.txt");
        n = in.nextInt();
        res = new int[n];
        visited = new boolean[n];
        matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = in.nextInt();
            }
        }
        bfs(0);
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                bfs(i);
            }
        }
        for (int i = 0; i < n; i++) {
            out.print(res[i] + " ");
        }
        out.flush();
        out.close();
    }
    public static void bfs(int vertex) {
        Queue<Integer> queue = new LinkedList<>();
        k++;
        res[vertex] = k;
        visited[vertex] = true;
        queue.offer(vertex);
        while (!queue.isEmpty()) {
            u = queue.poll();
            for (int v = 0; v < n; v++) {
                if (matrix[u][v] == 1 && !visited[v]) {
                    visited[v] = true;
                    k++;
                    res[v] = k;
                    queue.offer(v);
                }
            }
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

        String nextLine() {
            String str = "";
            try {
                if (st.hasMoreTokens()) {
                    str = st.nextToken("\n");
                } else {
                    str = br.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
