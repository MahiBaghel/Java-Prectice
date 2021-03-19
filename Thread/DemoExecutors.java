import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.ReentrantLock;

public class DemoExecutors {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // To create a pool of thread to reuse the thread for multipal oprations
        ExecutorService service = Executors.newFixedThreadPool(2);
        Printer[] PrinterJobs = { new Printer("Book"), new Printer("PDF"), new Printer("Photos"),
                new Printer("Documtnts") };
        for (Printer p : PrinterJobs) {
            service.submit(p);
        }

        NewPrinter[] NewPrinterJobs = { new NewPrinter("Book"), new NewPrinter("PDF"), new NewPrinter("Photos"),
                new NewPrinter("Documtnts") };
        for (NewPrinter p : NewPrinterJobs) {
            Future<String> f = service.submit(p);
            System.out.println(f.get());
        }

    }

}

// Runnable interfce is used to create thread without asking and return value
// also for handle exception not posible to throw out side of thread
class Printer implements Runnable {
    ReentrantLock lock = new ReentrantLock();
    private String Name;

    public Printer(String name) {
        Name = name;
    }

    @Override
    public void run() {
        lock.lock();
        try {
            Thread.sleep(1000);
            print();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.unlock();
    }

    public void print() {
        System.out.println("Printing for " + Name + " " + Thread.currentThread().getName());
    }

}

// Callable interfce is used to create thread with asking and return value
// also for handle exception posible to throw out side of thread
// Callable need Future to return data future
class NewPrinter implements Callable<String> {
    ReentrantLock lock = new ReentrantLock();
    private String Name;

    public NewPrinter(String name) {
        Name = name;
    }

    @Override
    public String call() throws Exception {
        lock.lock();
        try {
            Thread.sleep(1000);
            print();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.unlock();
        return Name;
    }

    public void print() {
        System.out.println("Printing for " + Name + " " + Thread.currentThread().getName());
    }

}