package com.asen.test;

import java.util.ArrayList;
import java.util.Scanner;

public class ExperienceGaining {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double neededExpericen = Double.parseDouble(scanner.nextLine());
        int battles = Integer.parseInt(scanner.nextLine());
        double expiGain = 0;
        for (int i = 1; i <= battles; i++) {
            Double currentBattle = Double.parseDouble(scanner.nextLine());
            expiGain += currentBattle;
            if (i % 3 == 0) {
                expiGain += 0.15 * currentBattle;
            }
            if (i % 5 == 0) {
                expiGain -= 0.1 * currentBattle;
            }
            if (expiGain >= neededExpericen) {
                System.out.printf("Player successfully collected his needed experience for %d battles.", i);
                break;

            }
        }
        if (expiGain < neededExpericen) {
            System.out.printf("Player was not able to collect the needed experience, %.2f more needed.", neededExpericen - expiGain
            );
        }
    }
}
