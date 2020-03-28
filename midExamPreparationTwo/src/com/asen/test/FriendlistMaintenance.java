package com.asen.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class FriendlistMaintenance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> friends = add(scanner);
        String command = scanner.nextLine();
        while (!command.equals("Report")) {
            String[] token = command.split("\\s+");
            switch (token[0]) {
                case "Blacklist":
                    String name=token[1];
                    if (friends.contains(name)) {
                        friends.set(friends.indexOf(name), "Blacklisted");
                        System.out.println(name + " was blacklisted.");


                    } else {
                        System.out.println(name + " was not found.");
                    }
                    break;
                case "Error":
                    int index=Integer.parseInt(token[1]);
                    if (index<0||index>friends.size()){
                        break;
                    }
                    if (!friends.get(index).equals("Blacklisted") &&
                            !friends.get(index).equals("Lost")) {
                        System.out.println(friends.get(index) + " was lost due to an error.");
                        friends.set(index, "Lost");
                    }
                    break;

                case "Change":
                     index=Integer.parseInt(token[1]);
                    if (index>=0&&index<=friends.size()-1) {
                        System.out.println(friends.get(index)+" changed his username to "+token[2]+". " );
                        friends.set(index, token[2]);
                    }
                    break;

            }
            command = scanner.nextLine();
        }

        int countBlackList = Collections.frequency(friends, "Blacklisted");
        int countLost = Collections.frequency(friends, "Lost");
        System.out.println("Blacklisted names: " + countBlackList + " ");
        System.out.println("Lost names: " + countLost + " ");
        System.out.println(String.join(" ", friends));
    }

    private static ArrayList<String> add(Scanner scanner) {
        String[] add = scanner.nextLine().split(", ");
        return new ArrayList<>(Arrays.asList(add));
    }
}
