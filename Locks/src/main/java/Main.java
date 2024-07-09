/**
 * @author: Rezvee Rahman
 * @date: 07/07/2024
 *
 * @description: Main entrypoint of the program.
 */

import main.java.com.application.Bingo;
import main.java.com.application.BingoThree;
import main.java.com.application.BingoTwo;

public class Main {

    public static void main(String[] args) {
        try {
            Bingo.initialize();
            Bingo.execute();
            System.out.println("\nStarting next Bingo.");
            Thread.sleep(2_000);
            BingoTwo.initialize();
            BingoTwo.execute();
            System.out.println("\nStarting final Bingo.");
            Thread.sleep(2_000);
            BingoThree.initialize();
            BingoThree.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}