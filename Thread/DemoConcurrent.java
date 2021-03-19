import java.util.concurrent.locks.ReentrantLock;

//why we requried Concurrent
// becoz synchronise block is only allowed in method or block across method we can't use this
//
//From java.lang.Concurrent and java.lang.Concurrent.lock
// Lock interface (lock(), tryLock(), tryLock(Time,Unit), unlock())
// ReentrantLock class
public class DemoConcurrent {
    public static void main(String[] args) {
        ReentrantLock re1 = new ReentrantLock(true);
        re1.lock();// jVM store hold count=1
        re1.lock();// jVM store hold count=2
        re1.lock();// jVM store hold count=3
        System.out.println(re1.getHoldCount());
        re1.unlock();

        // ReentrantLock re2 = new ReentrantLock(true);//longest wating thread get lock
        // first,default is false

        // method of ReentrantLock
        System.out.println(re1.getHoldCount());// num of holds in this lock by current thread
        System.out.println(re1.isHeldByCurrentThread());// held by current thread
        System.out.println(re1.getQueueLength());// num of thread wating for the lock
        System.out.println(re1.hasQueuedThreads());// true if any Thread is waiting for lock
        System.out.println(re1.isLocked()); // if locked is made
        System.out.println(re1.isFair()); // if fair marked true

    }

}
