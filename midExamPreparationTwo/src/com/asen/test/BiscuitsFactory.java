package com.asen.test;

import java.util.Scanner;

public class BiscuitsFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int biscuitsPerDay = Integer.parseInt(scanner.nextLine());
        int workers = Integer.parseInt(scanner.nextLine());
        int biscuitsCompeter = Integer.parseInt(scanner.nextLine());
        double ourProduction = 0;
        for (int i = 1; i <= 30; i++) {
            ourProduction += biscuitsPerDay * workers;
            if (i % 3 == 0) {
                ourProduction -= Math.round(0.25 * biscuitsPerDay * workers);
            }
        }
        System.out.println(("You have produced " + (int) ourProduction + " biscuits for the past month."));
        if (ourProduction > biscuitsCompeter) {
            System.out.printf("You produce %.2f percent more biscuits.", (ourProduction - biscuitsCompeter) / biscuitsCompeter * 100);
        } else {
            System.out.printf("You produce %.2f percent less biscuits.", (biscuitsCompeter - ourProduction) / biscuitsCompeter * 100);
            //колко процента повече е направил другия от нас
        }
    }
}
