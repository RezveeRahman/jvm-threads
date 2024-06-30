/**
 * @author: Rezvee Rahman
 * @date: 06/29/2024
 * 
 * @description: Abstract account implements account interface and
 * provides basic functionality for any class that is inheriting it.
 */
package main.java;

public abstract class AbstractAccount implements AccountInterface {

    protected int accountValue;

    /* -------------------------------------------------------------------
     * -- Public Methods
     * ------------------------------------------------------------------- */

    /**
     * Increments the account value by a specified ammount
     * @param value
     */
    @Override
    public void incrementAccountValue(int value) {
        System.out.println("Account value - " + accountValue);
        this.accountValue += value;
        callOut(value);
    }

    /**
     * Decrements the account by a specified ammount
     * @param value
     */
    @Override
    public void decrementAccountValue(int value) {
        System.out.println("Account value - " + accountValue);
        this.accountValue -= value;
        callOut((-1)*value);
    }

    /**
     * Simply prints out the value change & current account value.
     * If account is less than 0 then prints red text otherwise green.
     */
    @Override
    public void callOut(int value) {
        if (value < 0) {
            System.out.println("\033[38;5;204m" + "Account has lost "
                + " value by: " + value + "\033[0;0;0m");
        } else {
            System.out.println("\033[38;5;48m" + "Account has gained"
                + " value by: " + value + "\033[0;0;0m");
        }

        if (this.accountValue < 0) {
            System.out.println("\033[38;5;204m" + "new account value"
                    + " is: " + this.accountValue + "\033[0;0;0m");
        } else {
            System.out.println("\033[38;5;48m" + "new account value"
                    + " is: " + this.accountValue + "\033[0;0;0m");
        }
    }
}
