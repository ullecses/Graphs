import java.io.*;
import java.util.StringTokenizer;

public class Dfs {
    static int [][] matrix;
    static boolean[] visited;
    static int n;
    static int[] res;
    static int k = 0;
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
        dfs(0);
        for (int i = 0; i < n; i++) {
            if (res[i] == 0) dfs(i);
            out.print(res[i] + " ");
        }
        out.flush();
        out.close();
    }
    public static void dfs(int vertex) {
        visited[vertex] = true;
        k++;
        res[vertex] = k;
        for (int i = 0; i < n; i++) {
            if (matrix[vertex][i] == 1 && !visited[i]) {
                dfs(i);
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