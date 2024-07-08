/**
 * @author: Rezvee Rahman
 * @date: 07/07/2024
 * 
 * @description: Main entrypoint of the program.
 */

import main.java.com.application.Bingo;

public class Main {

    public static void main(String[] args) {
        try {
            Bingo.initialize();
            Bingo.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}