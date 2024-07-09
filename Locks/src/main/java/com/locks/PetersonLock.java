/**
 * @author: Rezvee Rahman
 * @date: 07/08/2024
 * 
 * @description: The peterson lock is basically combining  the OneClass
 * & TwoClass locks together. The algorithm should be Starvation-free,
 * deadlock-free, and satisfies mutual exclusion. The algorithm works
 * with 2 threads only.
 */
package main.java.com.locks;

public class PetersonLock implements Lock {
    private final boolean[] flags = new boolean[2];
    private int victim;

    /* -------------------------------------------------------------------
     * -- Public Methods
     * ------------------------------------------------------------------- */

    /**
     * The peterson lock will have a flag and victim variable
     */
    @Override
    public void lock(Thread t) {
        int i = Integer.parseInt(t.getName());
        int j = 1 - i; // get the complementary thread

        victim = i;
        System.out.println("\033[38;5;102m" + i + " - is victim"
                + "\033[0;0;0m");
        flags[i] = true;
        System.out.println("\033[38;5;107m" + i + " - flag is true"
                + "\033[0;0;0m");

        while (flags[i] && victim == i) {
            System.out.println("\033[38;5;98m" + i + " - is waiting "
                    + "\033[0;0;0m");
        }
    }

    /**
     * The Peterson algorithm algorithm is the same as the LockOne algorithm. 
     */
    @Override
    public void unlock(Thread t) {
        int i = Integer.parseInt(t.getName());

        flags[i] = false;
        victim = -1;
        System.out.println("\033[38;5;127m" + i + " - unlocked"
                + "\033[0;0;0m");
    }
}
