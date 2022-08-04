package coloryr.tntlimit.task;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Tasks {
    private static Queue<Runnable> tasks = new ConcurrentLinkedQueue<>();
    private static Thread[] threads;
    private static final int count = 2;
    private static boolean isRun;

    public static void start() {
        threads = new Thread[count];
        isRun = true;
        for (int a = 0; a < count; a++) {
            Thread thread = new Thread(Tasks::run);
            thread.start();
            threads[a] = thread;
        }
    }

    public static void addTask(Runnable runnable) {
        if (isRun)
            tasks.add(runnable);
    }

    public static void stop() {
        isRun = false;
    }

    private static void run() {
        while (isRun) {
            try {
                Thread.sleep(10);
                Runnable runnable = tasks.poll();
                if (runnable != null)
                    runnable.run();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
