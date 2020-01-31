package com.company;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Задача 1 - кролики. Введите количество месяцев и коэффициент размножения");
        int month = sc.nextInt();
        int coefficient = sc.nextInt();
        System.out.println("Всего: "+ rabbits(month, coefficient) + " кроликов");

        System.out.println("Задача 2 - кролики. Введите количество месяцев, коэффициент размножения и время жизни кроликов");
        int month2 = sc.nextInt();
        int coefficient2 = sc.nextInt();
        int old = sc.nextInt();
        System.out.println("Всего: "+ rabbits2(month2, coefficient2, old) + " кроликов");

        System.out.println("Задача 3 - массивы.");
        int [] array1 = {1, 2, 2, 4, 8, 10};
        int [] array2 = {2, 3, 5, 6};
        System.out.println("Полученный массив:" + Arrays.toString(mergeArrays(array1, array2)));

    }
    static long rabbits (int month, int coefficient){
        long child = 0;
        long adult = 1;
        long newChild, newAdult;
        for (int i = 0; i < month - 2; i++) {
            newChild = adult*coefficient;
            newAdult = child+adult;
            child = newChild;
            adult = newAdult;
        }
        return child+adult;
    }

    static long rabbits2 (int month, int coefficient, int old){
        long [][] allRabbit = new long[month][old];
        allRabbit[0][0] = 1;
        for (int i = 1; i < month; i++) {
            for (int j = 1; j < old ; j++) {
                allRabbit[i][0] += allRabbit[i-1][j]*coefficient;
                allRabbit[i][j] = allRabbit[i-1][j - 1];
            }
        }
       /* for (int i = 0; i < month; i++) {
            for (int j = 0; j < old; j++) {
                System.out.print(allRabbit[i][j] + " ");
            }
            System.out.println();
        }*/
        long sumRabbits = 0;
        for (int i = 0; i < old; i++) {
            sumRabbits += allRabbit[month-1][i];
        }
        return sumRabbits;
    }


    static int[] mergeArrays(int[] a1, int[] a2) {
        int[] a3 = new int [a1.length+a2.length];
        int counterA1 = 0;
        int counterA2 = 0;
        for (int i = 0; i < a3.length ; i++) {
            if (counterA1 < a1.length && counterA2 < a2.length) {
                if (a1[counterA1] < a2[counterA2]) {
                    a3[i] = a1[counterA1];
                    counterA1++;
                } else {
                    a3[i] = a2[counterA2];
                    counterA2++;
                }
            }
            else {
                if (a1.length < counterA1) {
                    a3[i] = a2[counterA2];
                    counterA2++;
                }
                else {
                    a3[i] = a1[counterA1];
                    counterA1++;
                }
            }
        }
        return a3;
    }
}