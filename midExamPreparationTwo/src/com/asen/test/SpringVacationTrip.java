package com.asen.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class SpringVacationTrip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> paintings = addArray(scanner);
        String command = scanner.nextLine();
        while (!command.equals("END")) {
            String[] paintingInput = command.split(" ", 3);
            switch (paintingInput[0]) {
                case "Change":
                    if (paintings.contains(paintingInput[1])) {
                        paintings.set(paintings.indexOf(paintingInput[1]), paintingInput[2]);
                    }

                    break;
                case "Hide":
                    if (paintings.contains(paintingInput[1])) {
                        paintings.remove(paintingInput[1]);

                    }
                    break;
                case "Switch":
                    if (paintings.contains(paintingInput[1]) && paintings.contains(paintingInput[2])) {
                        int indexOne = paintings.indexOf(paintingInput[1]);
                        int indexTwo = paintings.indexOf(paintingInput[2]);
                        paintings.set(indexOne, paintingInput[2]);
                        paintings.set(indexTwo, paintingInput[1]);
                    }
//
                    break;
                case "Insert":
                    if (Integer.parseInt(paintingInput[1]) + 1 < paintings.size() && Integer.parseInt(paintingInput[1]) + 1 >= 0)
                        paintings.add(Integer.parseInt(paintingInput[1])+1, paintingInput[2]);

                    break;

                case "Reverse":
                    Collections.reverse(paintings);
                    break;
            }


            command = scanner.nextLine();

        }
        System.out.println(String.join(" ", paintings));
    }

    private static ArrayList<String> addArray(Scanner scanner) {
        String[] asw = scanner.nextLine().split(" ");
        ArrayList<String> output = new ArrayList<>(Arrays.asList(asw));
        return output;
    }
}
