/**
 * @author: Rezvee Rahman
 * @date: 06/29/2024
 * 
 * @description: AccountInterface is a class that contains the skeleton
 * code for building an implemented account class.
 */
package main.java;

public interface AccountInterface {

    /**
     * Increments the account value by a specified ammount.
     * @param value
     */
    void incrementAccountValue(int value);

    /**
     * Decrements the account value by a specified ammount.
     * @param value
     */
    void decrementAccountValue(int value);

    /**
     * Prints account value.
     */
    void callOut(int value);


}
