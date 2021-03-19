public class DemoSynchronization {
    public static void main(String[] args) {
        Display d = new Display();
        MyThread threadList[] = { new MyThread("Mahi1", d), new MyThread("Mahi2", d), new MyThread("Mahi3", d),
                new MyThread("Mahi4", d), new MyThread("Mahi5", d), new MyThread("Mahi6", d) };
        for (MyThread thread : threadList) {
            thread.start();
        }
    }
}

class MyThread extends Thread {
    private String name;
    private Display d;

    public MyThread(String name, Display d) {
        this.name = name;
        this.d = d;
    }

    public void run() {
        d.wish(name);
    }
}

class Display {

    // if we removed synchronized all thred can access on same time
    public synchronized void wish(String Name) {
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("Good Morning : " + Name);
                Thread.sleep(1000);
            }
        } catch (Exception e) {
        }
    }
}