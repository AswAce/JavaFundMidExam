package com.asen.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ProblemTree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> journal = add(scanner);

        String command = scanner.nextLine();
        while (!command.equals("Craft!")) {
            String[] token = command.split(" - ");
            switch (token[0]) {
                case "Collect":
                    if (!journal.contains(token[1])) {
                        journal.add(token[1]);
                    }

                    break;


                case "Drop":
                    if (journal.contains(token[1])) {
                        journal.remove(token[1]);


                        break;
                    }
                    break;
                case "Combine Items":
                    ArrayList<String> weapons = new ArrayList<>(Arrays.asList(token[1].split(":")));
                    String oldWeapon = weapons.get(0);
                    String newWeapon = weapons.get(1);
                    if (journal.contains(oldWeapon)) {
                        journal.add(journal.indexOf(oldWeapon) + 1, newWeapon);
                        break;
                    }
                    break;
                case "Renew":
                    if (journal.contains(token[1])) {
                        journal.add(journal.remove(journal.indexOf(token[1])));
                        break;
                    }

                    break;
            }
            command = scanner.nextLine();
        }
        System.out.println(String.join(", ", journal));
    }

    private static ArrayList<String> add(Scanner scanner) {
        String[] add = scanner.nextLine().split(", ");
        return new ArrayList<>(Arrays.asList(add));
    }
}
