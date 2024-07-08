/**
 * @author: Rezvee Rahman
 * @date: 07/07/2024
 *
 * @description: This type of lock simply uses a boolean flag. We should
 * use this for applications with 2 Threads.
 * 
 * Issues: This algorithm can potentiall deadlock.
 */
package main.java.com.locks;

public final class LockOneClass implements Lock {

    private final boolean[] lockFlag = new boolean[2];
    
    /**
     * Constructor of creating a OneClassLock.
     * "There is no real constructor (default) so we just have an object"
     */
    public LockOneClass() {
        System.out.println("\033[38;5;2m" + "Constructed LockOne"
                + "\033[0;0;0m");
    }

    /* -------------------------------------------------------------------
     * -- Public Methods
     * ------------------------------------------------------------------- */

     /**
      * I would like to mention that `getId()` is deprecated and now we
      * have to use Strings `getName` and convert them to ints...
      */

    /**
     * To "acquire the lock", the thread sets its flag to true and sets
     * the complementary thread to false.
     * @param i
     */
    @Override
    public void lock(Thread t) {
        /* `i` is the current thread trying to execute */
        int i = Integer.parseInt(t.getName());
        int j = 1 - i; // complementary thread.
        System.out.println("\033[38;5;6m" + "Here: " + i + "\033[0;0;0m");

        lockFlag[i] = true;
        while (lockFlag[j]) { 
            System.out.println("\033[38;5;6m" + "Waiting for other to" +
                    " release lock: " + j + "\033[0;0;0m");
        }
    }

    /**
     * To "release the lock" the thread simply sets its flag to false.
     * @param i
     */
    @Override
    public void unlock(Thread t) {
        int i = Integer.parseInt(t.getName());

        lockFlag[i] = false;
    }
}
