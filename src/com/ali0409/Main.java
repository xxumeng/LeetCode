package com.ali0409;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[][] array = new int[10][3];
        Arrays.sort(array, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        TreeMap<Integer, Integer> sortedMap = new TreeMap<>();
        for (Map.Entry entry : sortedMap.entrySet()) {
            int k = (int) entry.getKey();
            int v = (int) entry.getValue();
        }

//        Scanner in = new Scanner(System.in);
//        int t = in.nextInt();
//        for (int i = 0; i < t; i++) {
//            int n = in.nextInt();
//            int[] L = new int[n];
//            int[] R = new int[n];
//            for (int j = 0; j < n; j++) {
//                L[i] = in.nextInt();
//                R[i] = in.nextInt();
//            }
//            //第i组测试用例，调用函数
//
//        }
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[][] q = new int[k][2];
        for (int i = 0; i < k; i++) {
            q[i][0] = in.nextInt();
            q[i][1] = in.nextInt();
        }




    }
//    @Override
//    public int compareTo(Object o) {
//        myClass m = (myClass) o;
//        if(this.price!= m.price){
//            return Double.compare(this.price,((myClass) o).price);
//        }else {
//            return -this.name.compareTo(m.name);
//        }
//    }

}
