/**
 * @author: Rezvee Rahman
 * @date: 07/07/2024
 * 
 * @description: This Lock interface for other locking algorithms. We 
 * will use this to create LockOneClass, LockTwoClass, and the Peterson Lock.
 */
package main.java.com.locks;


public interface Lock {

    /**
     * Defines the the structure for a thread to start locking
     * critical section of code.
     */
    public void lock(Thread i);

    /**
     * Defines the structure for when a thread exits critical section of
     * code.
     */
    public void unlock(Thread i);
}
