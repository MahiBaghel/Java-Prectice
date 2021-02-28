package Thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class DemoCyclicBarrier {
    public static void main(String[] args) {
        CyclicBarrier cb = new CyclicBarrier(4);
        MyCyclicBarrier myCyclicBarrier1 = new MyCyclicBarrier(cb, "Thread1");
        MyCyclicBarrier myCyclicBarrier2 = new MyCyclicBarrier(cb, "Thread2");
        MyCyclicBarrier myCyclicBarrier3 = new MyCyclicBarrier(cb, "Thread3");
        MyCyclicBarrier myCyclicBarrier4 = new MyCyclicBarrier(cb, "Thread4");
        MyCyclicBarrierWithLimit myCyclicBarrier5 = new MyCyclicBarrierWithLimit(cb, "Thread5");
        MyCyclicBarrierWithLimit myCyclicBarrier6 = new MyCyclicBarrierWithLimit(cb, "Thread6");
        MyCyclicBarrierWithLimit myCyclicBarrier7 = new MyCyclicBarrierWithLimit(cb, "Thread7");
        MyCyclicBarrierWithLimit myCyclicBarrier8 = new MyCyclicBarrierWithLimit(cb, "Thread8");
        myCyclicBarrier1.start();
        myCyclicBarrier2.start();
        myCyclicBarrier3.start();
        myCyclicBarrier4.start();
        myCyclicBarrier5.start();
        myCyclicBarrier6.start();
        myCyclicBarrier7.start();
        myCyclicBarrier8.start();

        if (cb.getNumberWaiting() == 0) {
            System.out.println("Main job done");
        }
    }

}

class MyCyclicBarrier extends Thread {

    private CyclicBarrier cb;

    public MyCyclicBarrier(CyclicBarrier cb, String name) {
        super(name);
        this.cb = cb;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + "Started");
            Thread.sleep(10000);
            cb.await();
            System.out.println(Thread.currentThread().getName() + "Ended");
        } catch (IllegalMonitorStateException | InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }

    }

}

class MyCyclicBarrierWithLimit extends Thread {

    private CyclicBarrier cb;

    public MyCyclicBarrierWithLimit(CyclicBarrier cb, String name) {
        super(name);
        this.cb = cb;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + "Started");
            cb.await(1000, TimeUnit.SECONDS);
            System.out.println(Thread.currentThread().getName() + "Ended");
        } catch (IllegalMonitorStateException | InterruptedException | BrokenBarrierException | TimeoutException e) {
            e.printStackTrace();
        }

    }

}
