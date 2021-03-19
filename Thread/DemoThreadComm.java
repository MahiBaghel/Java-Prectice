
public class DemoThreadComm {
    public static void main(String[] args) throws InterruptedException {
        DemoCommThread b = new DemoCommThread();
        b.start();
        // b.join(); not recommend
        // Thread.sleep(100);
        synchronized (b) {
            b.wait(1000);
            System.out.println(b.total);
        }
    }
}

class DemoCommThread extends Thread {

    int total = 0;

    @Override
    public void run() {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                try {
                    total = total + i;
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.notify();
        }
    }
}
