package Thread;

public class DemoThreadLocal {
    public static void main(String[] args) {
        /* without init value */
        ThreadLocal<String> tLocal = new ThreadLocal<>();

        /*
         * with inin value ThreadLocal<String> tLocal = new ThreadLocal<>() { public
         * String initialValue() { return "mahi"; } };
         */

        System.out.println(tLocal.get());// null
        tLocal.set("Mahi");
        System.out.println(tLocal.get());// mahi
        tLocal.remove();
        System.out.println(tLocal.get());// null becoz init value called

        /* Example */
        Customer cus1 = new Customer("Mahi");
        Customer cus2 = new Customer("Piyush");
        Customer cus3 = new Customer("Nuzhat");
        Customer cus4 = new Customer("Megha");
        cus1.start();
        cus2.start();
        cus3.start();
        cus4.start();

    }

}

class Customer extends Thread {
    static Integer id = 0;
    private static ThreadLocal<Integer> tLocal = new ThreadLocal<>() {
        public Integer initialValue() {
            return ++id;
        }
    };

    public Customer(String Name) {
        super(Name);
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Id with " + tLocal.get());
    }

}