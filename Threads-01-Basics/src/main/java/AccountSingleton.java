/**
 * @author: Rezvee Rahman
 * @date: 06/29/2024
 *
 * @description: Account Singleton implements AbstractAccount via
 * template pattern.
 */
package main.java;

import java.util.Random;

public class AccountSingleton extends AbstractAccount {

    private static AccountSingleton instance = null;

    private Random rngRandom;

    /* -------------------------------------------------------------------
     * -- Public Methods
     * ------------------------------------------------------------------- */

    /**
     * Initializes the singleton object. For thread safety the
     * synchronized keyword was added.
     */
    public static void initialize() throws Exception {
        if (instance != null) {
            throw new Exception("Account Singleton was already initialized");
        }
        instance = new AccountSingleton();
    }

    /**
     * Get's instance of the account singleton. This is not thread safe.
     * I'm pretty sure if we try to get an Instance without initializing
     * then we could cause an error. We should include initialize if the
     * instance does not exist.
     */
    public static AccountSingleton getInstance() throws Exception {
        if (instance == null) {
            initialize();
        }
        return instance;
    }

    /**
     * This method adds value to the account. Using a random generator,
     * we can add a range of value.
     */
    public void addValue(int range) throws Exception {
        instanceCheck();
        incrementAccountValue(rngRandom.nextInt(range));
    }

    /**
     * This method adds value to the account. Using a random generator,
     * we can add a range of value.
     */
    public void removeValue(int range) throws Exception {
        instanceCheck();
        decrementAccountValue(rngRandom.nextInt(range));
    }

    /* -------------------------------------------------------------------
     * -- Private Methods
     * ------------------------------------------------------------------- */

    /**
     * Initializing the AccountSingleton. Only one instance can exist
     * for a singleton.
     */
    private AccountSingleton() throws Exception {
        this.accountValue = 0;
        this.rngRandom = new Random();
    }

    /**
     * Checks if the singleton object exists otherwise throws an error.
     */
    private void instanceCheck() throws Exception {
        if (instance == null) {
            throw new Exception("There is no instance!");
        }
    }
}
