
public class DemoThreadMethod {
    public static void main(String[] args) throws InterruptedException {
        MyThreadWithYield mThread = new MyThreadWithYield();
        mThread.start();
        MyThreadWith1Join joinThread1 = new MyThreadWith1Join();
        joinThread1.start();
        // joinThread1.join();/// main thread has to wait to complete joinThread1 thread
        joinThread1.join(300);/// main thread has to wait to complete joinThread1 thread
        for (int i = 0; i < 10; i++) {
            System.out.println("Inside main number : " + i);
        }

    }

}

class MyThreadWithYield extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Inside MyThreadWithYield number : " + i);
            Thread.yield();
        }
    }
}

class MyThreadWith1Join extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Inside MyThreadWith1Join number : " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class MyThreadWith2Join extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Inside MyThreadWith2Join number : " + i);
        }
    }
}
