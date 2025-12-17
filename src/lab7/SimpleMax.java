package lab7;

import java.util.concurrent.*;

public class SimpleMax {
    static void main() throws ExecutionException, InterruptedException {
        int[][] matrix = {{1, 50, 3}, {9, 2, 100}}; // 100
        ExecutorService executor = Executors.newFixedThreadPool(2);

        Future<Integer> f1 = executor.submit(() -> {
            int max = 0;
            for (int x : matrix[0]) if (x > max) max = x;
            return max;
        });

        Future<Integer> f2 = executor.submit(() -> {
            int max = 0;
            for (int x : matrix[1]) if (x > max) max = x;
            return max;
        });

        System.out.println("Максимум: " + Math.max(f1.get(), f2.get()));
        executor.shutdown();
    }
}
