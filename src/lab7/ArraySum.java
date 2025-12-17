package lab7;

import java.util.concurrent.*;

public class ArraySum {
    static void main() throws ExecutionException, InterruptedException {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}; // 55
        ExecutorService executor = Executors.newFixedThreadPool(2);

        Future<Integer> f1 = executor.submit(() -> {
            int sum = 0;
            for (int i = 0; i < 5; i++) sum += arr[i];
            return sum;
        });

        Future<Integer> f2 = executor.submit(() -> {
            int sum = 0;
            for (int i = 5; i < 10; i++) sum += arr[i];
            return sum;
        });

        System.out.println("Итог: " + (f1.get() + f2.get()));
        executor.shutdown();
    }
}
