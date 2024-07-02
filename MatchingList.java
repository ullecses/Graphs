import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class MatchingList {
    public static void main(String[] args) throws FileNotFoundException {
        try {
            File file = new File("input.txt");
            PrintWriter out = new PrintWriter("output.txt");
            Scanner scanner = new Scanner(file);
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            List<Integer>[] array = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                array[i] = new ArrayList<>();
                // Добавление элементов в динамический массив
            }
            int u, v;
            for (int i = 0; i < m; i++) {
                u = scanner.nextInt();
                v = scanner.nextInt();
                array[u - 1].add(v);
                array[v - 1].add(u);
            }
            for (int i = 0; i < n; i++) {
                out.print(array[i].size() + " ");
                for (int element : array[i]) {
                    out.print(element + " ");
                }
                out.println();
            }
            out.flush();
            out.close();
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
