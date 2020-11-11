package com.offer;

public class Offer17PrintNumber {

//    public int[] printNumbers(int n) {
//        if (n==0) return null;
//        int max = (int) Math.pow(10,n) - 1;
//        int[] all = new int[max];
//        for (int i=1;i<=max;i++){
//            all[i-1] = i;
//        }
//        return all;
//    }
//    StringBuilder res;
//    char[] num;
//    int n;
//    public void dfs(int x){
//        for(int i=0;i<=9;i++){
//            if (x==n) return;
//            num[x] = (char) (i + 48);
//            res.append(String.valueOf(num));
//            res.append(",");
//            dfs(x+1);
//        }
//    }
//
//    public String printNumbers2(int n) {
//        this.n = n;
//        num = new char[n];
//        if (n==0) return null;
//        res = new StringBuilder();
//        dfs(0);
//        return res.toString();
//    }
//

    int[] res;
    int nine = 0, count = 0, start, n;
    char[] num, loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    public int[] printNumbers(int n) {
        this.n = n;
        res = new int[(int)Math.pow(10, n) - 1];
        num = new char[n];
        start = n - 1;
        dfs(0);
        for (int r:res
             ) {
            System.out.println(r);
        }
        return res;
    }
    void dfs(int x) {
        if(x == n) {
            String s = String.valueOf(num).substring(start);
            if(!s.equals("0")) res[count++] = Integer.parseInt(s);
            if(n - start == nine) start--;
            return;
        }
        for(char i : loop) {
            if(i == '9') nine++;
            num[x] = i;
            dfs(x + 1);
        }
        nine--;
    }

    public static void main(String[] args) {
        Offer17PrintNumber solve = new Offer17PrintNumber();
        System.out.println(solve.printNumbers(3));
    }
}
