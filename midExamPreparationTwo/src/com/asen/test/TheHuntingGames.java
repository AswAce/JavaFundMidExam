package com.asen.test;

        import java.util.Scanner;

public class TheHuntingGames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int days = Integer.parseInt(scanner.nextLine());
        int playerCount = Integer.parseInt(scanner.nextLine());
        double groupEnergy = Double.parseDouble(scanner.nextLine());
        double waterPerPerson = Double.parseDouble(scanner.nextLine());
        double foodPerPerson = Double.parseDouble(scanner.nextLine());
        double groupWater = (double) days * (double) playerCount * waterPerPerson;
        double groupFood = (double)days * (double)playerCount * foodPerPerson;
        Double[] energyLostPerDay = new Double[days];
        for (int i = 1; i <= days; i++) {
            energyLostPerDay[i - 1] = Double.parseDouble(scanner.nextLine());
        }
        for (int i = 1; i <= days; i++) {
            groupEnergy -= energyLostPerDay[i - 1];
            if (i % 2 == 0) {
                groupWater *= 0.7;
                groupEnergy *= 1.05;
            }
            if (i % 3 == 0) {
                groupFood -=groupFood/ playerCount;
                groupEnergy *= 1.1;
            }
            if (groupEnergy <= 0) {
                System.out.printf("You will run out of energy. " +
                        "You will be left with %.2f food and %.2f water.", groupFood, groupWater);
                return;
            }
        }
        if (groupEnergy>0){ System.out.printf("You are ready for the quest. You will be left with - %.2f energy!", groupEnergy
        );}

    }
}
