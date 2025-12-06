package tugofcards;

import java.util.Scanner;

public class GameDriver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.println("Hello, " + name + "!");
        System.out.println("Welcome to the TugOfCards Game!");
        System.out.println("--------------------------------");

        //Builder pattern
        TugOfCards game = new TugOfCardsBuilder()
                .setStrategy(new StandardMatchupStrategy())
                .build();

        //Observer pattern
        game.addObserver(message -> System.out.println(message));

        //Game loop
        while (!game.isGameOver()) {
            System.out.println(game.toString());
            
            System.out.println("Press enter to draw a card!");
            scanner.nextLine();

            game.playTurn();
        }

        scanner.close();
    }
}