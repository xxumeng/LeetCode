package com.dynamic;

public class Zijie {
    int[] selectors = new int[]{1,9};
    int count = 0;
    public int dp(int n, int now){
        if(now==0) return 0;
        int res=0;
        for(int s : selectors){
            res = (dp(n,now-1) + s)%10;
            System.out.print(now);
            System.out.print(':');
            System.out.println(res);
            if (n==now && res==0) count++;
            return res;
        }
        return res;
    }

    public static void main(String[] args) {
        Zijie solve = new Zijie();
        solve.dp(2, 2);
        System.out.println(solve.count);

    }
}
