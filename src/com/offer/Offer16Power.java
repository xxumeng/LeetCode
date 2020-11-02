package com.offer;

public class Offer16Power {
    public double pow(double x, int n){
        if (n==1) return x;
        double res = 1;
        int odd = n%2;
        if(odd==1) res *= x;
        n = n/2;
        double temp = pow(x, n);
        return res*temp*temp;
    }
    public double myPow(double x, int n) {
        if (n==1) return 1;
        return pow(x,n);
    }

}
