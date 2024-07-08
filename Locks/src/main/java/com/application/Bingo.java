/**
 * Bingo is simply a application where two threads try to reach bingo.
 */

package main.java.com.application;

import main.java.com.locks.LockOneClass;

public class Bingo extends Thread {
    private static LockOneClass lock    = new LockOneClass();
    private static Bingo[] bingos       = new Bingo[2];

    /**
     * Creates a Bingo Object
     */
    private Bingo(String threadId) throws Exception {
        Integer.parseInt(threadId);
        this.setName(threadId);
    }

    /* -------------------------------------------------------------------
     * -- Public Methods
     * ------------------------------------------------------------------- */

    /**
     * Initializes the bingo objects so the game can start.
     */
    public static void initialize() throws Exception {
        bingos[0] = new Bingo("0");
        bingos[1] = new Bingo("1");
    }

    public static void execute() throws Exception {
        bingos[0].start();
        bingos[1].start();

        bingos[0].join();
        bingos[1].join();
    }

    /**
     * Prints out that one of the thread called bingo.
     */
    public void callBingo() {
        System.out.println(this.getName() + " - has called bingo!");
    }

    @Override
    public void run() {
        lock.lock(this);
        callBingo();
        lock.unlock(this);
    }
}
