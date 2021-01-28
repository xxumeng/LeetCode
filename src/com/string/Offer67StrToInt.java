package com.string;

public class Offer67StrToInt {
    public int strToInt(String str) {
        int p=0,l = str.length();
        if (l==0) return 0;

        //记录符号
        int sign=1;

        //注意去除空格之后的长度，边界
        while(p<l && str.charAt(p)==' ') p++;
        if(p<l && str.charAt(p)=='-') sign=-1;
        if(p<l && (str.charAt(p)=='-' || str.charAt(p)=='+')) p++;

        int res=0;
        //最大值除以10
        int bndry = Integer.MAX_VALUE/10;
        while (p<l && str.charAt(p)>='0' && str.charAt(p)<='9'){
            //res>bndry 那么*10一定是越界
            //res=bndry *10+小于等于7不越界，否则要么越界，要么等于最大最小值
            if (res>bndry || (res==bndry && str.charAt(p) >'7') ) return sign==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
            res = res*10 + (str.charAt(p) -'0');
            p++;
        }
        return res*sign;
    }

    public static void main(String[] args) {
        Offer67StrToInt solve = new Offer67StrToInt();
        System.out.println(solve.strToInt("words and 987"));
    }
}
