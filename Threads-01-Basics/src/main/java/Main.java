/**
 * @author: Rezvee Rahman
 * @date: 06/29/2024
 * 
 * @description: Doing very basic thread implementation and
 * understanding jvm threads.
 */

package main.java;

import java.util.Random;

public class Main {

    private static final Random RANDOM  = new Random();
    private static final int    RANGE   = 5;
    private static final int    SLEEP   = 3;

    private static AccountSingleton reference;

    public static void main(String[] args) {
        try {
            System.out.println("Starting Account Value program");
            reference = AccountSingleton.getInstance();
            executeProgram();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void executeProgram() {

        Thread t1 = new Thread(
            () -> {
                int i = 0;
                try {
                    while (i < 10) {
                        Long sleepTime = RANDOM.nextLong(SLEEP * 1000);
                        reference.addValue(RANGE);
                        System.out.println("Sleeping for: " + sleepTime);
                        Thread.sleep(sleepTime);
                        i++;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
        });

        Thread t2 = new Thread(
            () -> {
                int i = 0;
                try {
                    while(i < 10) {
                        Long sleepTime = RANDOM.nextLong(SLEEP * 1000);
                        reference.removeValue(RANGE);
                        System.out.println("Sleeping for: " + sleepTime);
                        Thread.sleep(sleepTime);
                        i++;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        );

        try {
            t1.start();
            t2.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}