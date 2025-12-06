package tugofcards;

import tugofcards.cards.CardFactory;

import java.util.Scanner;

public class GameDriver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.println("Hello, " + name + "!");
        System.out.println("Welcome to the TugOfCards Game!");

        //add print to ask user what strategy they want to use

        CardFactory cardFactory = new CardFactory();
        MatchupStrategy strategy = new StandardMatchupStrategy();

        TugOfCards game = new TugOfCards(cardFactory, strategy);

        while (!game.isGameOver()) {
            game.toString();
            System.out.println("Press enter to draw a card!");
            scanner.nextLine();

            game.playTurn();
        }

        scanner.close();
    }
}



