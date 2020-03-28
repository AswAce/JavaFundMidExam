package com.asen.test;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class HelloFrance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> items = itemsAdd(scanner);
        ArrayList<String> itemsToSell = new ArrayList<>();
        double sumStartingPrice = 0.0;

        double budget = Double.parseDouble(scanner.nextLine());
        for (int i = 0; i < items.size(); i++) {
            String[] itemPrice = items.get(i).split("->");
            switch (itemPrice[0]) {
                case "Clothes":
                    if (Double.parseDouble(itemPrice[1]) <= 50.00 && Double.parseDouble(itemPrice[1]) <= budget) {
                        budget -= Double.parseDouble(itemPrice[1]);
                        itemsToSell.add(String.valueOf(1.4 * Double.parseDouble(itemPrice[1])));
                        sumStartingPrice += Double.parseDouble(itemPrice[1]);
                    }
                    break;
                case "Shoes":
                    if (Double.parseDouble(itemPrice[1]) <= 35.00 && Double.parseDouble(itemPrice[1]) <= budget) {
                        budget -= Double.parseDouble(itemPrice[1]);
                        itemsToSell.add(String.valueOf(1.4 * Double.parseDouble(itemPrice[1])));
                        sumStartingPrice += Double.parseDouble(itemPrice[1]);
                    }
                    break;
                case "Accessories":
                    if (Double.parseDouble(itemPrice[1]) <= 20.50 && Double.parseDouble(itemPrice[1]) <= budget) {
                        budget -= Double.parseDouble(itemPrice[1]);
                        itemsToSell.add(String.valueOf(1.4 * Double.parseDouble(itemPrice[1])));
                        sumStartingPrice += Double.parseDouble(itemPrice[1]);
                    }
                    break;
            }
        }
        double itemsToSellProfit = 0;
        for (String e : itemsToSell
        ) {
            double priceDouble = Double.parseDouble(e);
            itemsToSellProfit += priceDouble;
            System.out.print(String.format("%.2f ", priceDouble));

        }
        System.out.println();
        if (itemsToSellProfit + budget >= 150) {
            System.out.println(String.format("Profit: %.2f", itemsToSellProfit - sumStartingPrice));
            System.out.println("Hello, France!");
        } else {
            System.out.println(String.format("Profit: %.2f", itemsToSellProfit - sumStartingPrice));
            System.out.println("Time to go."
            );
        }

    }

    private static ArrayList<String> itemsAdd(Scanner scanner) {
        String[] items = scanner.nextLine().split("\\|");
        return new ArrayList<>(Arrays.asList(items));

    }
}
