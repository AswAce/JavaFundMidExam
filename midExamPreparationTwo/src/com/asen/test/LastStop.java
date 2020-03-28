package com.asen.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class LastStop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int daysVacation = Integer.parseInt(scanner.nextLine());
        int budgetFoGroup = Integer.parseInt(scanner.nextLine());
        int countPeople = Integer.parseInt(scanner.nextLine());
        double pricePerKilometer = Double.parseDouble(scanner.nextLine());
        int foodExpensesPerPerson = Integer.parseInt(scanner.nextLine());
        double hotelRoomPricePerPerson = Integer.parseInt(scanner.nextLine());
        double expences = 0;
        ArrayList<Integer> distancePerDays = new ArrayList<>();
        for (int i = 1; i <= daysVacation; i++) {
            int disdistancePerDay = Integer.parseInt(scanner.nextLine());
            distancePerDays.add(disdistancePerDay);
        }
        if (countPeople > 10) {
            hotelRoomPricePerPerson = hotelRoomPricePerPerson * 0.75;
        }
        expences = hotelRoomPricePerPerson * countPeople * daysVacation + (countPeople * foodExpensesPerPerson * daysVacation);
        for (int i = 1; i <= daysVacation; i++) {
            expences += (pricePerKilometer * distancePerDays.get(i - 1));
            if (i % 3 == 0 || i % 5 == 0) {
                expences += 0.4 * expences;
            }
            if (i % 7 == 0) {
                expences -= expences / countPeople;
            }

            if (expences > budgetFoGroup) {
                System.out.printf("Not enough money to continue the trip. You need %.2f$ more.", expences - budgetFoGroup);
            return;
            }

        }
        if (expences <= budgetFoGroup) {
            System.out.printf("You have reached the destination. You have %.2f$ budget left.", budgetFoGroup - expences);
        }

    }
}
