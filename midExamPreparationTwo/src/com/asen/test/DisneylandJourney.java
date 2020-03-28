package com.asen.test;

import java.util.Scanner;

public class DisneylandJourney {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int journeyCost = Integer.parseInt(scanner.nextLine());
        int months = Integer.parseInt(scanner.nextLine());
        double collectedMoney = 0.0;
        for (int i = 1; i <= months; i++) {
            if (i % 4 == 0 && months >= 4) {
                collectedMoney += 0.25 * collectedMoney;
            }

            if (i % 2 != 0 && months > 1) {
                collectedMoney -= 0.16 * collectedMoney;
            }
            collectedMoney += 0.25 * journeyCost;
        }
        if (collectedMoney >= journeyCost) {
            System.out.printf("Bravo! You can go to Disneyland and you will have %.2flv. for souvenirs.", (collectedMoney - journeyCost));
        } else {
            System.out.printf("Sorry. You need %.2flv. more.", (journeyCost - collectedMoney)
            );
        }
    }
}
