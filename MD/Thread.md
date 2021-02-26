# Thread

### Ways to create thread

1.Extending Thread class
2.Implimenting runnable interfce

### Getting and setting name of the thread

### Thread priority

Default priority range is **1-10**
**1 is MIN** to verify this we have Thread.MIN_PRIORITY
**10 is MAX** to verify this we have Thread.MAX_PRIORITY
1.If we will set thread priority as more than 10 or less than 1 than it will throws illigaleArgumentException
2.Default priority for main thread is 5, but for all child threads priority will be inherited

### Method to prevent thread excution

1. yield() - To pass current executing thread to give chance waiting thread of same priority or max priority
2. join() - If thread wants to wait for some other thread to complete than we need join method
3. sleep()

### Synchronized

1. Synchronizer block used to solve data in-consistency problem
2. Synchronizer is only method label and block
3. If a class having two sync method and one normal method than accessing sync method is not possible even if diffrent thread try to access diff method, but accessing normal method can at the same time.
4. if you make a static method is sync than this class is complety blocked to access, becoz this time thread need class lavel lock

### Inter Thread Communication

### DeadLock

### Deamon Thread
