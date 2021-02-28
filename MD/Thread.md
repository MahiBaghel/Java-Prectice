# Thread

Java MultiThread is implemented over two modal

1. Green Thread modal
2. Native Os modal

#### Green Thread modal :

Thread completely managed by JVM, without taking underlying OS support(**SUN solaris**)

#### Native Os modal :

Thread completely managed by OS, with taking underlying OS support

### Ways to create thread

1.Extending Thread class
2.Implementing runnable interface

### Getting and setting name of the thread

### Thread priority

Default priority range is **1-10**
**1 is MIN** to verify this we have Thread.MIN_PRIORITY
**10 is MAX** to verify this we have Thread.MAX_PRIORITY
1.If we will set thread priority as more than 10 or less than 1 than it will throws illegal ArgumentException
2.Default priority for main thread is 5, but for all child threads priority will be inherited

### Method to prevent thread execution

1. yield() - To pass current executing thread to give chance waiting thread of same priority or max priority
2. join() - If thread wants to wait for some other thread to complete than we need join method
3. sleep()

### Synchronized

1. Synchronizer block used to solve data in-consistency problem
2. Synchronizer is only method label and block
3. If a class having two sync method and one normal method than accessing sync method is not possible even if different thread try to access diff method, but accessing normal method can at the same time.
4. if you make a static method is sync than this class is completely blocked to access, because this time thread need class level lock

### Inter Thread Communication

1. Two thread can comm with each other with following method,these all method present in object call
2. wait, notify and notifyAll method on any object thats why all method in object class
3. All these method method we can only call inside sync area(**IllegalMonitorStateException**)
4. Only in these three method thread releases the lock

#### wait()

1. Thread which is expecting updation is responsible to call wait method
2. after calling wait method thread entered into waiting state
3. Thread can only call wait method on object when it is owner of that object, if did than there will be and exception(**IllegalMonitorStateException**)

#### notify()

1. Thread who will responsible for updation value has to call notify method
2. after calling waiting thread will get that notification and continue its exe with those updated items

#### notifyAll()

1. used this to notify all thread which are in waiting thread, in notify method only one thread will got notification not all thread other will still be in waiting state

### Daemon Thread

Thread running in background called Daemon thread
**Example**
Garbage collector

### CyclicBarrier

CyclicBarrier is used to make threads wait for each other. It is used when different threads process a part of computation and when all threads have completed the execution, the result needs to be combined in the parent thread. In other words, a CyclicBarrier is used when multiple thread carry out different sub tasks and the output of these sub tasks need to be combined to form the final output. After completing its execution, threads call await() method and wait for other threads to reach the barrier. Once all the threads have reached, the barriers then give the way for threads to proceed.

CyclicBarriers are defined in java.util.concurrent package.

```Java
CyclicBarrier newBarrier = new CyclicBarrier(numberOfThreads);
```

The CyclicBarrier can also be initialized with some action that is performed once all the threads have reached the barrier. This action can combine/utilize the result of computation of individual thread waiting in the barrier.

```Java
CyclicBarrier newBarrier = new CyclicBarrier(numberOfThreads, action);
```

A CyclicBarrier can be used again and again once all the threads in a barriers is released.

#### getParties()

Returns the number of parties required to trip this barrier

#### reset()

Resets the barrier to its initial state

#### isBroken()

Queries if this barrier is in a broken state

#### getNumberWaiting()

Returns the number of parties currently waiting at the barrier.

#### await()

Waits until all parties have invoked await on this barrier

```java
public int await(long timeout, TimeUnit unit) throws InterruptedException,BrokenBarrierException,TimeoutException
```

### CountDownLatch

CountDownLatch is used to make sure that a task waits for other threads before it starts. To understand its application, let us consider a server where the main task can only start when all the required services have started.
When we create an object of CountDownLatch, we specify the number of threads it should wait for, all such thread are required to do count down by calling CountDownLatch.countDown() once they are completed or ready to the job. As soon as count reaches zero, the waiting task starts running.

### volatile variable

Using volatile is yet another way (like synchronized, atomic wrapper) of making class thread safe. Thread safe means that a method or class instance can be used by multiple threads at the same time without any problem.
**volatile vs synchronized:**
Before we move on let’s take a look at two important features of locks and synchronization.

Mutual Exclusion: It means that only one thread or process can execute a block of code (critical section) at a time.
Visibility: It means that changes made by one thread to shared data are visible to other threads.
Java’s synchronized keyword guarantees both mutual exclusion and visibility. If we make the blocks of threads that modifies the value of shared variable synchronized only one thread can enter the block and changes made by it will be reflected in the main memory. All other thread trying to enter the block at the same time will be blocked and put to sleep.

In some cases we may only desire the visibility and not atomicity. Use of synchronized in such situation is an overkill and may cause scalability problems. Here volatile comes to the rescue. Volatile variables have the visibility features of synchronized but not the atomicity features. The values of volatile variable will never be cached and all writes and reads will be done to and from the main memory. However, use of volatile is limited to very restricted set of cases as most of the times atomicity is desired. For example a simple increment statement such as x = x + 1; or x++ seems to be a single operation but is s really a compound read-modify-write sequence of operations that must execute atomically.

### Race Condition

A race condition occurs when two or more threads can access shared data and they try to change it at the same time. Because the thread scheduling algorithm can swap between threads at any time, you don't know the order in which the threads will attempt to access the shared data. Therefore, the result of the change in data is dependent on the thread scheduling algorithm, i.e. both threads are "racing" to access/change the data.

In order to prevent race conditions from occurring, you would typically put a lock around the shared data to ensure only one thread can access the data at a time. This would mean something like this:

### FutureTask

**_What happens when an Exception occurs in a thread?_**
This is one of the good tricky Java question I have seen in interviews. In simple words, If not caught thread will die, if an uncaught exception handler is registered then it will get a call back. Thread.UncaughtExceptionHandler is an interface, defined as nested interface for handlers invoked when a Thread abruptly terminates due to an uncaught exception. When a thread is about to terminate due to an uncaught exception the Java Virtual Machine will query the thread for its UncaughtExceptionHandler using Thread.getUncaughtExceptionHandler() and will invoke the handler's uncaughtException() method, passing the thread and the exception as arguments.
