package com.asen.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;


public class WizardPoker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> magicDeck = addArray(scanner);
        ArrayList<String> deckToPlay = new ArrayList<>();
        String command = scanner.nextLine();
        while (!command.equals("Ready")) {
            String[] cards = command.split(" ");
            switch (cards[0]) {
                case "Add":

                    if (!magicDeck.contains(cards[1])) {
                        System.out.println("Card not found."
                        );
                    } else {
                        deckToPlay.add(cards[1]);
                    }
                    break;
                case "Insert":

                    if (!magicDeck.contains(cards[1]) || Integer.parseInt(cards[2]) < 0 || Integer.parseInt(cards[2]) > deckToPlay.size()) {
                        System.out.println("Error!");
                    } else {
                        deckToPlay.add(Integer.parseInt(cards[2]), cards[1]);
                    }
                    break;
                               case "Remove":
                    if (!deckToPlay.contains(cards[1])) {
                        System.out.println("Card not found."
                        );
                    } else {
                        deckToPlay.remove(cards[1]);
                    }
                    break;
                case "Swap":
                    Collections.swap(deckToPlay, deckToPlay.indexOf(cards[1]), deckToPlay.indexOf(cards[2]));
                    break;
                case "Shuffle":
                    if (cards[1].equals("deck")){
                  Collections.reverse(deckToPlay);}
                    break;
                    //НЕ работи..

            }
            command = scanner.nextLine();

        }
        System.out.println(String.join(" ", deckToPlay));
    }

    private static ArrayList<String> addArray(Scanner scanner) {
        String[] add = scanner.nextLine().split(":");
        return new ArrayList<>(Arrays.asList(add));
    }

}
