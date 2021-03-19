package com.interview;

public class Fibo {
    public int fibo(int n){
        if (n<=0) return -1;
        if (n==1 || n==2) return 1;
        int f1 = 1, f2 = 1;
        int f = 0;
        for(int i=3; i<=n;i++){
            f = f1 + f2;
            f1 = f2;
            f2 = f;
        }
        return f;
    }


    public static void main(String[] args) {
        Fibo solve = new Fibo();
        System.out.println(solve.fibo(5));
    }
}
