package com.asen.test;

import java.util.ArrayList;
import java.util.Scanner;

public class ProblemTwo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int studentCount = Integer.parseInt(scanner.nextLine());
        int lecturesCount = Integer.parseInt(scanner.nextLine());
        int bonus = Integer.parseInt(scanner.nextLine());
        ArrayList<Integer> studentsAtendence = new ArrayList<>();
        int bestStudentAtendence = 0;

        /// Prisystwiq na studenti
        for (int i = 1; i <= studentCount; i++) {
            studentsAtendence.add(Integer.parseInt(scanner.nextLine()));
        }
        for (int i = 0; i < studentsAtendence.size(); i++) {
            if (bestStudentAtendence < studentsAtendence.get(i)) {
                bestStudentAtendence = studentsAtendence.get(i);
            }
        }
        double att = (double) bestStudentAtendence / lecturesCount;
        long maxBonus = Math.round(att * (5 + bonus));
//        {total bonus} = {student attendances} / {course lectures} * (5 + {additional bonus})
        System.out.printf("Max Bonus: %d.", maxBonus);
        System.out.println();
        System.out.printf("The student has attended %d lectures.", bestStudentAtendence);

    }
}
