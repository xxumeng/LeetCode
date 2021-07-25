package com.meituan;

import com.ali0409.Main02;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public int maxScore(int n, int m, int[] scoresM, int[] scoresT){
        int max = Integer.MIN_VALUE;
        int hasMin = 1, hasMax = 0;
        for (int i = 0; i < n; i++) {
            hasMin = Math.min(hasMin,scoresM[i]);
            hasMax = Math.max(hasMax,scoresM[i]);
        }
        for (int i = 0; i < m; i++) {
            hasMin = Math.min(hasMin,scoresT[i]);
            hasMax = Math.max(hasMax,scoresT[i]);
        }
        for (int d = hasMin; d <= hasMax; d++) {
            int s1 = 0, s2 = 0;
            for (int i = 0; i < n; i++) {
                if (scoresM[i]<=d) s1++;
                else s1+=2;
            }
            for (int i = 0; i < m; i++) {
                if (scoresT[i]<=d) s2++;
                else s2+=2;
            }
            max = Math.max(max, s2-s1);
        }
        return max;
    }
    public static void main(String[] args) {
        Main s = new Main();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] scoresM = new int[n];
        int[] scoresT = new int[m];

        for (int i = 0; i < n; i++) {
            scoresM[i] = in.nextInt();
        }
        for (int i = 0; i < m; i++) {
            scoresT[i] = in.nextInt();
        }
        System.out.println(s.maxScore(n,m,scoresM,scoresT));
    }
}
