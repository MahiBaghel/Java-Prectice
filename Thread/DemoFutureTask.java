import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class DemoFutureTask {

    public static void main(String[] args) throws InterruptedException {
        MyTask task1 = new MyTask();
        MyTask task2 = new MyTask();
        MyTask task3 = new MyTask();
        ExecutorService ecutorService = Executors.newFixedThreadPool(3);
        List<Future<Boolean>> myTasks = new ArrayList<>();
        Future<Boolean> fut1 = ecutorService.submit(task1);
        myTasks.add(fut1);
        Future<Boolean> fut2 = ecutorService.submit(task2);
        myTasks.add(fut2);
        Future<Boolean> fut3 = ecutorService.submit(task3);
        myTasks.add(fut3);
        ecutorService.shutdown();
        Boolean completed = ecutorService.awaitTermination(4, TimeUnit.SECONDS);
        if (completed) {
            System.out.println("All Task done");
        } else {
            System.out.println("Time Out");
        }
    }

}

class MyTask implements Callable<Boolean> {

    @Override
    public Boolean call() throws Exception {
        Thread.sleep(1000);
        System.err.println(Thread.currentThread().getName());
        return true;
    }

}