package com.interview;

import java.util.Scanner;

public class Ali0310 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int row = in.nextInt();
        int col = in.nextInt();
        int steps = in.nextInt();
        char[][] array = new char[row][col];
        for (int i = 0; i < row; i++) {
            String temp = in.next();
            for (int j = 0; j < col; j++) {
                array[i][j] = temp.charAt(j);
            }
        }
        String[] directions = new String[steps];
        for (int i = 0; i < steps; i++) {
            directions[i] = in.next();
        }
        System.out.println(directions.toString());
    }
}
