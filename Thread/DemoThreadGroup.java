
public class DemoThreadGroup {
    public static void main(String[] args) {
        // out put main becoz group name is mainGroup and group is postFix
        System.out.println(Thread.currentThread().getThreadGroup().getName());

        // out put system becoz every thead group is child of system thread group
        // system group containes sevral system lavel threads like
        // finilizer
        // refrenceHndler
        // signleDispatcher
        // attechlistner
        System.out.println(Thread.currentThread().getThreadGroup().getParent().getName());

        // created under main thread
        ThreadGroup parentGroup = new ThreadGroup("parentGroup");
        System.out.println(parentGroup.getParent().getName());// main

        // created under main parentGroup
        ThreadGroup childThreadGroup = new ThreadGroup(parentGroup, "childThreadGroup");
        System.out.println(childThreadGroup.getParent().getName());// parentGroup

        // methods of groups
        parentGroup.setMaxPriority(2);// default 10
        parentGroup.list();// info of thread group
        System.out.println(parentGroup.activeCount());// num of active thread in group
        System.out.println(parentGroup.activeGroupCount());// num of active threadGroup in group
        parentGroup.setDaemon(true);
        System.out.println(parentGroup.isDaemon());
        System.out.println(parentGroup.isDestroyed());
        parentGroup.interrupt();
        parentGroup.destroy();

        // Problem of setting MaxPriority
        ThreadGroup tg = new ThreadGroup("tg");// default MaxPriority 10
        Thread t1 = new Thread(tg, "t1");// default MaxPriority 5
        Thread t2 = new Thread(tg, "t2");// default MaxPriority 5
        tg.setMaxPriority(3);// this will only effect for newly added thread
        Thread t3 = new Thread(tg, "t3"); // default MaxPriority will become 3
        System.out.println("t1.getPriority() : " + t1.getPriority());// 5
        System.out.println("t2.getPriority() : " + t2.getPriority());// 5
        System.out.println("t3.getPriority() : " + t3.getPriority());// 3

        // how to dispaly all thread in any group;
        Thread[] threadAry = new Thread[10];
        tg.enumerate(threadAry);

    }
}
