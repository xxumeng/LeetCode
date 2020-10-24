package com.hot;

import java.util.Collection;
import java.util.Collections;

public class Hot12IntegerToRoman {
    /*
    * 思路1：从右到左或者从左到右移位，分别对个十百千位处理转化
    * 思路2：贪心法，建立两个数组，int和roman，两两对应，num不断减去数组中最大数
    * 思路3：个十百千位建立完整的数字到roman的映射表
    * */
    public String intToRoman(int num) {
        String res = "";
        int tempNum = num;
        int countNum = 0;
        while(tempNum!=0){
            tempNum = tempNum/10;
            countNum++;
        }

        for (int i = 0; i < countNum; i++) {
            int temp = num % 10;
            num = num / 10;
            if(i==3){
                res = String.join("", Collections.nCopies(temp, "M"))+ res;
                break;
            }
            if (temp<4){
                if (i==0) res = String.join("", Collections.nCopies(temp, "I"))+ res;
                else if(i==1) res = String.join("", Collections.nCopies(temp, "X"))+ res;
                else if(i==2) res = String.join("", Collections.nCopies(temp, "C"))+ res;


            }else if (temp==4){
                if (i==0) res = "IV" + res ;
                else if(i==1) res = "XL" + res;
                else if(i==2) res = "CD" + res;
            }else if(temp<9){
                if (i==0) res = "V" +String.join("", Collections.nCopies(temp % 5, "I"))+ res;
                else if(i==1) res = "L" + String.join("", Collections.nCopies(temp % 5, "X"))+ res;
                else if(i==2) res = "D" + String.join("", Collections.nCopies(temp % 5, "C"))+ res;
            }else {
                if (i==0)  res = "IX" + res ;
                else if(i==1) res = "XC" + res;
                else if(i==2) res = "CM" + res;
            }
        }
        return res;
    }
    public String intToRoman_method2(int num) {
        StringBuffer res = new StringBuffer();
        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] romans = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        for (int i=0; i<values.length && num>0;i++){
            while(num>=values[i]){
                num -= values[i];
                res.append(romans[i]);
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        int num = 1994;
        Hot12IntegerToRoman method = new Hot12IntegerToRoman();
        System.out.println(method.intToRoman(num));
        System.out.println(method.intToRoman_method2(num));
    }
}
