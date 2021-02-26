# Thread local

1. Can we used define local variable for a thread
2. We can access thread local variable in thread anywhere
3. Introduced in Java 1.2 version and updated in 1.5 version
4. Threadlocal can be associated with thread scope

# Methods

    ## Object get()
    Return the value of thread local variable for current thread

    ## Object initValue()
    Return init value of thread local variable for current thread default value is null to customize init value we have to override this method

    ## void set(Object newValue)
    To set a new value

    ## void remove()
    To remove the value of thread local

# InheritableThreadLocal

    used when you want to share data form parent to child thread
