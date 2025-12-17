package lab7;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class SimpleMax {
    static void main() throws ExecutionException, InterruptedException {
        int[][] matrix = {
                {1, 50, 3},
                {9, 2, 100},
                {500, 20, 1},
                {5, 5, 5}
        };

        int threadCount = Math.min(matrix.length, Runtime.getRuntime().availableProcessors());
        ExecutorService executor = Executors.newFixedThreadPool(threadCount);

        List<Future<Integer>> futures = new ArrayList<>();

        for (int[] row : matrix) {
            Future<Integer> f = executor.submit(() -> {
                int maxInRow = Integer.MIN_VALUE;
                for (int x : row) {
                    if (x > maxInRow) maxInRow = x;
                }
                return maxInRow;
            });
            futures.add(f);
        }

        int globalMax = Integer.MIN_VALUE;
        for (Future<Integer> f : futures) {
            int rowMax = f.get();
            if (rowMax > globalMax) {
                globalMax = rowMax;
            }
        }

        System.out.println("Максимум: " + globalMax);
        executor.shutdown();
    }
}
