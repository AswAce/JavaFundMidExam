package com.asen.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SchoolLibrary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> library = getArray(scanner);
        String command = scanner.nextLine();
        while (!command.equals("Done")) {
            String[] booksToAdd = command.split(" \\| ");
            switch (booksToAdd[0]) {
                case "Add Book":
                    if (!library.contains(booksToAdd[1])) {
                        library.add(0, booksToAdd[1]);
                    }
                    break;
                case "Take Book":
                    if (library.contains(booksToAdd[1])) {
                        library.remove(booksToAdd[1]);
                    }
                    break;
                case "Swap Books":
                    if (library.contains(booksToAdd[1]) && library.contains(booksToAdd[2])) {
                        int indexOne = library.indexOf(booksToAdd[1]);
                        int indexTwo = library.indexOf(booksToAdd[2]);
                        library.set(indexOne, booksToAdd[2]);
                        library.set(indexTwo, booksToAdd[1]);
                    }
                    break;
                case "Insert Book":
//                    if (!library.contains(booksToAdd[1])) {
                        library.add(booksToAdd[1]);
//                    }
                    break;
                case "Check Book":
                    if (Integer.parseInt(booksToAdd[1]) >= 0 && Integer.parseInt(booksToAdd[1]) < library.size()) {
                        System.out.println(library.get(Integer.parseInt(booksToAdd[1])));
                    }
                    break;
            }
            command = scanner.nextLine();

        }
        System.out.println(String.join(", ", library));
    }

    private static ArrayList<String> getArray(Scanner scanner) {
        String[] books = scanner.nextLine().split("&");
        return new ArrayList<>(Arrays.asList(books));
    }
}
