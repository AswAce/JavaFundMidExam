package com.asen.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ProblemOne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> rooms = add(scanner);
        int health = 100;
        int bitcoins = 0;
        int roomCount = 0;
        {
            for (int i = 0; i < rooms.size(); i++) {
                String[] token = rooms.get(i).split(" ");


                switch (token[0]) {
                    case "potion":
                        int prevHealth = health;
                        health += Integer.parseInt(token[1]);
                        if (health > 100) {
                            health = 100;
                            System.out.printf("You healed for %s hp.", health - prevHealth);
                            System.out.println();
                        } else {
                            System.out.printf("You healed for %s hp.", token[1]);
                            System.out.println();
                        }
                        System.out.printf("Current health: %s hp.",health);
                        System.out.println();
                        roomCount += 1;
                        break;
                    case "chest":
                        System.out.printf("You found %s bitcoins.", token[1]
                        );
                        System.out.println();
                        bitcoins += Integer.parseInt(token[1]);
                        roomCount += 1;
                        break;

                    default:
                        String monster = token[0];
                        int dmg = Integer.parseInt(token[1]);
                        health -= dmg;
                        if (health > 0) {
                            System.out.printf("You slayed %s.", monster);
                            System.out.println();

                        } else {
                            System.out.printf("You died! Killed by %s.", token[0]);
                            System.out.println();
                            roomCount+=1;
                            System.out.println("Best room: " + roomCount
                            );
                       return;
                        }
                        roomCount += 1;
                        break;


                }
            }

        }
        if (health > 0) {
            System.out.println("You've made it!");
            System.out.println(" Bitcoins: "+bitcoins);
            System.out.println("Health: "+health);



        }


    }

    private static ArrayList<String> add(Scanner scanner) {
        ArrayList<String> output = new ArrayList<>();
        String[] input = scanner.nextLine().split("\\|");
        for (String e : input
        ) {
            output.add(e);

        }
        return output;
    }
}
