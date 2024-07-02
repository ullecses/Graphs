import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class CanonicalViewMatrix {
    public static void main(String[] args) throws FileNotFoundException {
        try {
            File file = new File("input.txt");
            PrintWriter out = new PrintWriter("output.txt");
            Scanner scanner = new Scanner(file);
            int n = scanner.nextInt();
            int[] arr = new int[n];
            int current;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (scanner.nextInt() == 1) arr[j] = i + 1;
                }
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
