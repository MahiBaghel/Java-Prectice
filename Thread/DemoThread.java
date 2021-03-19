
public class DemoThread {
    public static void main(String[] args) {
        ThreadClassExample thread1 = new ThreadClassExample();
        RunnableClassExample run = new RunnableClassExample();
        Thread thread2 = new Thread(run);

        /* setting new name of method */
        thread1.setName("Thread One");
        /*
         * Thread priority default renge is 1-10 1 is max 10 is min
         */
        int maxPriority = Thread.MAX_PRIORITY;
        int minPriority = Thread.MIN_PRIORITY;
        int normPriority = Thread.NORM_PRIORITY;
        System.out.println("Thread min priority is : " + minPriority);
        System.out.println("Thread max priority is : " + maxPriority);
        System.out.println("Thread norm priority is : " + normPriority);
        thread1.setPriority(minPriority);
        /* thread2.setPriority(17);// IllegalArgumentException */
        thread1.start();
        thread2.setName("Thread Two");
        System.out.println(thread2.getPriority());// default Priority is 5
        thread2.start();
    }

}

class ThreadClassExample extends Thread {
    @Override
    public void run() {
        /* getting current thread name */
        System.out.println(
                Thread.currentThread().getName() + " This is exmple of creating thread by extending thread class");
    }

}

class RunnableClassExample implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()
                + " This is exmple of creating thread by implements Runnable interface");
    }
}