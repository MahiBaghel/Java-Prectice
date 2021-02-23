# Thread local

1. Can we used define local varibale for a thread
2. We can access thread local varibale in thread anywhere
3. Intorduced in Java 1.2 version and updated in 1.5 version
4. Threadlocal can be assosiated with thread scope

# Methods

    ## Object get()
    Return the value of thread local vriable for currect thread

    ## Object initValue()
    Return init vlalue of thread local vriable for currect thread default value is null to customise init value we have to override this method

    ## void set(Object newValue)
    To set a new value

    ## void remove()
    To remove the value of thread local

# InheritableThreadLocal

    used when you want to share data form parent to child thread
