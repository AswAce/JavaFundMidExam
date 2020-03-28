package com.asen.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SeizetheFire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> fires = addFIre(scanner);
        int water = Integer.parseInt(scanner.nextLine());
        ArrayList<String> newCells = new ArrayList<>();
        for (int i = 0; i < fires.size(); i++) {
            String[] singleFire = fires.get(i).split("\\s+= ");
            String fireType = singleFire[0];
            int fireLevel = Integer.parseInt(singleFire[1]);
            switch (fireType) {
                case "High":
                    if (fireLevel <= 125 && fireLevel >= 81 && water >= fireLevel) {
                        newCells.add(singleFire[1]);
                        water -= fireLevel + 0.25 * fireLevel;
//                       effort+=0.25*fireLevel;
                    }

                    break;
                case "Medium":
                    if (fireLevel >= 51 && fireLevel < 81 && water >= fireLevel) {
                        newCells.add(singleFire[1]);
                        water -= fireLevel + 0.25 * fireLevel;
//                           effort += 0.25 * fireLevel;

                    }
                    break;
                case "Low":
                    if (fireLevel >= 1 && fireLevel < 51 && water >= fireLevel) {
                        newCells.add(singleFire[1]);
                        water -= fireLevel + 0.25 * fireLevel;
//                           effort += 0.25 * fireLevel;

                    }
                    break;
            }

        }
        double effort = 0;
        int sum = 0;
        System.out.println("Cells:");
        for (String e : newCells
        ) {
            effort += 0.25 * Integer.parseInt(e);
            sum += Integer.parseInt(e);
            System.out.println("- " + e);
        }
        System.out.println(String.format("Effort: %.2f", effort));
        System.out.println(String.format("Total Fire: %d", sum
        ));
    }

    private static ArrayList<String> addFIre(Scanner scanner) {
        String[] add = scanner.nextLine().split("#");
        return new ArrayList<>(Arrays.asList(add));
    }
}
