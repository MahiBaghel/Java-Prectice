package Thread;

public class DemoInhThreadLocal {
    public static void main(String[] args) {
        Parent p = new Parent();
        p.run();
    }

}

class Parent implements Runnable {
    static InheritableThreadLocal<String> ihLocal = new InheritableThreadLocal<>();

    @Override
    public void run() {
        ihLocal.set("Mahi");
        System.out.println("Parent setted value as : " + ihLocal.get());
        Child child = new Child();
        child.run();

    }

}

class Child extends Thread {
    @Override
    public void run() {
        System.out.println("Child has parent value : " + Parent.ihLocal.get());
    }
}