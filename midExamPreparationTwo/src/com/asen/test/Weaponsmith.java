package com.asen.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Weaponsmith {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> weapon = createArrayFromString(scanner);
        String command = scanner.nextLine();
        while (!command.equals("Done")) {
            String[] forged = command.split(" ");
            switch (forged[0]) {
                case "Move":
                    int partToSwap = Integer.parseInt(forged[2]);
                    if (forged[1].equals("Right")) {
                        if (partToSwap <= weapon.size() - 2 && partToSwap >= 0) {
                            Collections.swap(weapon, partToSwap, partToSwap + 1);
                        }
                    }
                    if (forged[1].equals("Left")) {
                        if (partToSwap > 0 && partToSwap < weapon.size()) {
                            Collections.swap(weapon, partToSwap, partToSwap - 1);
                        }
                    }
                    break;
                case "Check":
                    if (forged[1].equals("Odd")) {
                        for (int i = 0; i < weapon.size(); i++) {
                            if (i % 2 != 0) {
                                System.out.print(weapon.get(i) + " ");
                            }
                        }
                    } else if (forged[1].equals("Even")) {
                        for (int i = 0; i < weapon.size(); i++) {
                            if (i % 2 == 0) {
                                System.out.print(weapon.get(i) + " ");
                            }
                        }
                    }
                    break;
            }


            command = scanner.nextLine();
        }
        System.out.println();
        String forgedWeapon = String.join("",weapon);
        System.out.printf("You crafted %s!", forgedWeapon);


    }

    private static ArrayList<String> createArrayFromString(Scanner scanner) {
        String[] add = scanner.nextLine().split("\\|");
        return new ArrayList<>(Arrays.asList(add));
    }
}
