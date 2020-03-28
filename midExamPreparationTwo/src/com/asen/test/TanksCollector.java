package com.asen.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TanksCollector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> tankFleet = add(scanner);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= n; i++) {
            String[] token = scanner.nextLine().split(", ");
            String command = token[0];
            switch (command) {
                case "Add":
                    String tankName = token[1];
                    if (tankFleet.contains(tankName)) {
                        System.out.println("Tank is already bought"
                        );
                    } else {
                        System.out.println("Tank successfully bought");
                        tankFleet.add(tankName);
                    }
                    break;

                case "Remove":
                    tankName = token[1];
                    if (tankFleet.contains(tankName)) {
                        System.out.println("Tank successfully sold");
                        tankFleet.remove(tankName);
                    } else {
                        System.out.println("Tank not found"
                        );
                    }
                    break;
                case "Remove At":
                    int indexToRemove = Integer.parseInt(token[1]);
                    if (indexToRemove < 0 || indexToRemove >= tankFleet.size()) {
                        System.out.println("Index out of range");
                    } else {
                        System.out.println("Tank successfully sold"
                        );
                        tankFleet.remove(indexToRemove);
                    }

                    break;
                case "Insert":
                    indexToRemove = Integer.parseInt(token[1]);
                    tankName = token[2];
                    if (indexToRemove < 0 || indexToRemove >= tankFleet.size()) {
                        System.out.println("Index out of range");
                    } else if (!tankFleet.contains(tankName)) {
                        tankFleet.add(indexToRemove, tankName);
                        System.out.println("Tank successfully bought");
                    } else {
                        System.out.println("Tank is already bought"
                        );
                    }

                    break;
            }

        }
        System.out.println(String.join(", ", tankFleet));

    }

    private static ArrayList<String> add(Scanner scanner) {
        String[] add = scanner.nextLine().split(", ");
        return new ArrayList<>(Arrays.asList(add));
    }
}
