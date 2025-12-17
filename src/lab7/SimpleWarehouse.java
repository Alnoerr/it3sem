package lab7;

import java.util.concurrent.Semaphore;

public class SimpleWarehouse {
    static int currentWeight = 0;
    static Semaphore sem = new Semaphore(1);

    static void main() {
        Runnable loader = () -> {
            try {
                while (true) {
                    sem.acquire();

                    if (currentWeight + 50 > 150) {
                        System.out.println("Лимит");
                        currentWeight = 0;
                    }

                    currentWeight += 50;
                    System.out.println(Thread.currentThread().getName() + " положил груз. Вес: " + currentWeight);

                    sem.release();
                    Thread.sleep(500);
                }
            } catch (InterruptedException _) {}
        };

        new Thread(loader, "Грузчик 1").start();
        new Thread(loader, "Грузчик 2").start();
        new Thread(loader, "Грузчик 3").start();
    }
}
