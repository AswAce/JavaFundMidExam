package com.asen.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class TheFinalQuest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> words = addWords(scanner);
        String command = scanner.nextLine();
        while (!command.equals("Stop")) {
            String[] token = command.split("\\s+");
            String first = token[0];
            switch (first) {
                case "Delete":
                    int index = Integer.parseInt(token[1]) + 1;
                    if (index >= 0 && index <= words.size() - 1) {
                        words.remove(index);

                    }
                    break;
                case "Swap":
                    String wordOne = token[1];
                    String wordTwo = token[2];
                    if (words.contains(wordOne) && words.contains(wordTwo)) {
                        Collections.swap(words, words.indexOf(wordOne), words.indexOf(wordTwo));
                    }

                    break;
                case "Put":
                    wordOne = token[1];
                    index = Integer.parseInt(token[2]) - 1;
                    if (index >= 0 && index <= words.size()) {
                        words.add(index, wordOne);
                    }
                    break;
                case "Sort":
                    words.sort(Collections.reverseOrder());

                    break;
                case "Replace":
                    wordOne = token[1];
                    wordTwo = token[2];
                    if (words.contains(wordTwo)) {
                        words.set(words.indexOf(wordTwo), wordOne);
                    }
                    break;
            }
            command = scanner.nextLine();
        }
        System.out.println(String.join(" ", words));
    }

    private static ArrayList<String> addWords(Scanner scanner) {
        String[] add = scanner.nextLine().split("\\s+");
        return new ArrayList<>(Arrays.asList(add));

    }
}
