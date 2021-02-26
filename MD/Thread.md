# Thread

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

Two thread can comm with each other with following method,these all method present in object call
**why** : because thread can call wait, notify and notifyAll method on any object thats why all method in object call

#### wait()

1. Thread which is expecting updation is responsible to call wait method
2. after calling wait method thread entered into waiting state

#### notify();

1. Thread who will responsible for updation value has to call notify method
2. after calling waiting thread will get that notification and continue its exe with those updated items

#### notifyAll()

2.

### DeadLock

### Daemon Thread
