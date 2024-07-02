import java.io.*;
import java.util.Scanner;

public class CanonicalView {
    public static void main(String[] args) throws FileNotFoundException {
        try {
            File file = new File("input.txt");
            PrintWriter out = new PrintWriter("output.txt");
            Scanner scanner = new Scanner(file);
            int n = scanner.nextInt();
            int[] arr = new int[n];

            for (int i = 0; i < n - 1; i++) {
                int u = scanner.nextInt();
                int v = scanner.nextInt();
                arr[v - 1] = u;
            }

            for (int i = 0; i < n; i++) {
                out.print(arr[i] + " ");
            }
            out.flush();
            out.close();
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
