/**
 * @author: Rezvee Rahman
 * @date: 07/08/2024
 *
 * @description: This example takes a look at the Locking LockTwo
 * algorithm. This algorithm requires 2 threads. Which ever thread comes
 * first will execute first. Unfortunately if the other thread doesn't
 * ever reach the lock, the thread will not be able to perform the
 * operation. This algorithm shouldn't be used in real world applicaiton
 * and is used for demonstraiton purposes.
 */
package main.java.com.locks;

public class LockTwoClass implements Lock {

    private int victim;

    /* -------------------------------------------------------------------
     * -- Public Methods
     * ------------------------------------------------------------------- */

    /**
     * The `lock` method here will yield for a thread that is waiting.
     */
    @Override
    public void lock(Thread i) {
        int id = Integer.parseInt(i.getName());
        System.out.println("\033[38;5;48m" + id + " - is now victim"
                + "\033[0;0;0m");
        victim = id;

        while (victim == id) {
            System.out.println("\033[38;5;59m" + id + " - is waiting"
                    + "\033[0;0;0m");
        }
    }

    /**
     * You can try to to set victim to -1 to let the other thread pass.
     * This works only for 2 threads because any more will result in
     * race conditions.
     */
    @Override
    public void unlock(Thread i) {
        System.out.println("\033[38;5;4m" + i.getName()
                + " - releasing." + "\033[0;0;0m");
        victim = -1;
    }
}
