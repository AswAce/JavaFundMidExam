package com.asen.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class ArcheryTournament {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> archery = addToArchary(scanner);
        int point = 0;
        String command = scanner.nextLine();
        while (!command.equals("Game over")) {
            String[] shooting = command.split("@");
            String result = shooting[0];

            switch (result) {
                case "Shoot Left":
                    int startIndex = Integer.parseInt(shooting[1]);
                    int length = Integer.parseInt(shooting[2]);
                    if (startIndex >= archery.size() || startIndex < 0) {
                        break;
                    }
                    int targetToShoot = startIndex - length;
                    if (startIndex - length >= 0 && startIndex - length < archery.size()) {
                        int newResult = (Integer.parseInt(archery.get(targetToShoot))) - 5;
                        archery.set(targetToShoot, String.valueOf(newResult));
                        point += 5;
                    } else {
                        while (targetToShoot < 0) {
                            targetToShoot += archery.size();
                        }
                        int newResult = (Integer.parseInt(archery.get(targetToShoot))) - 5;
                        archery.set(targetToShoot, String.valueOf(newResult));
                        point += 5;
                    }
                    if (Integer.parseInt(archery.get(targetToShoot)) < 5) {
                        point += Integer.parseInt(archery.get(targetToShoot));
                        archery.set(targetToShoot, "0");
                    }
                    break;

                case "Shoot Right":
                    startIndex = Integer.parseInt(shooting[1]);
                    length = Integer.parseInt(shooting[2]);
                    if (startIndex >= archery.size() || startIndex < 0) {
                        break;
                    }
                    targetToShoot = startIndex + length;
                    if (targetToShoot <= archery.size() - 1) {
                        int newResult = (Integer.parseInt(archery.get(targetToShoot))) - 5;
                        archery.set(targetToShoot, String.valueOf(newResult));
                        point += 5;
                    } else {

                        while (startIndex + length > archery.size() - 1) {
                            startIndex -= archery.size();
                            targetToShoot = startIndex + length;

                        }
                        int newResult = (Integer.parseInt(archery.get(targetToShoot))) - 5;
                        archery.set(targetToShoot, String.valueOf(newResult));
                        point += 5;
                    }
                    if (Integer.parseInt(archery.get(targetToShoot)) < 5) {
                        point += Integer.parseInt(archery.get(targetToShoot));
                        archery.set(targetToShoot, "0");
                    }

                    break;
                case "Reverse":
                    Collections.reverse(archery);
                    break;
            }


            command = scanner.nextLine();
        }
        points(archery, point);

    }

    private static void points(ArrayList<String> archery, int point) {

        System.out.println(String.join(" - ", archery));
        System.out.printf("Iskren finished the archery tournament with %d points!", point);
    }

//    private static void shootLeft(int startIndex, int length, ArrayList<String> archery) {
//        int targetToShoot = startIndex - length;
//        if (startIndex - length >= 0 && startIndex - length < archery.size()) {
//            targetPoints(archery, targetToShoot);
//        }
//        while (targetToShoot > archery.size()) {
//            targetToShoot = targetToShoot - archery.size();
//        }
//        targetToShoot = archery.size() + targetToShoot;
//        targetPoints(archery, targetToShoot);
//    }


    private static ArrayList<String> addToArchary(Scanner scanner) {
        return new ArrayList<>(Arrays.asList(scanner.nextLine().split("\\|")));
    }
}
