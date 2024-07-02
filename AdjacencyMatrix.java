import java.io.*;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class AdjacencyMatrix {
    public static void main(String[] args) throws FileNotFoundException {
        FastReader in = new FastReader();
        PrintWriter out = new PrintWriter("output.txt");
        int n = in.nextInt();
        int m = in.nextInt();
        int [][] matrix = new int[n][n];
        int u, v;
        for (int i = 0; i < m; i++) {
            u = in.nextInt();
            v = in.nextInt();
            matrix[u - 1][v - 1] = 1;
            matrix[v - 1][u - 1] = 1;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            //System.out.println("\n");
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