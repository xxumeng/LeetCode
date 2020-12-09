package com.offer;

public class Offer33Postorder {
    public boolean rec(int i, int j, int[] order){
        if (i>=j) return true;
        int root = order[j];
        int m=i;
        for(;m<=j;m++){
            if (order[m]>root) break;
        }
        for(int k=m+1;k<j;k++){
            if (order[k]<root) return false;
        }
        return rec(i,m-1, order) && rec(m,j, order);

    }
    public boolean verifyPostorder(int[] postorder) {
        return rec(0,postorder.length-1,postorder);
    }
}
