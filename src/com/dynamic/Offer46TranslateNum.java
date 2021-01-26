package com.dynamic;

public class Offer46TranslateNum {
    public int translateNum(int num) {
        //ab c 有两种可能：a bc,ab c。对于第一种有（a）种，第二种有（ab）种。
        int a=1, b=1;//前两个共有a种翻译方法，前一个共有b种
        while (num/10!=0){
            int cur = num%10;
            num = num/10;
            int pre= num%10;

            int tmp = pre*10+cur;
            int c = b; //记录
            if(tmp>=10 && tmp<=25) {
                b = a + b;
            }
            a = c;
            // System.out.print(a+" , ");
            // System.out.println(b);
        }
        return b;
    }
}
