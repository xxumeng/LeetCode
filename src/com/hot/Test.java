package com.hot;

public class Test {
    public static void main(String[] args) {
        String str = "";
        StringBuffer sb = new StringBuffer();
        long start = 0L;
        long end = 0L;
        start = System.currentTimeMillis();
        for (int i = 0; i < 9999; i++) {
            str = str + "a";
        }
        end = System.currentTimeMillis();
        System.out.println("使用string的时间是:" + (end - start) + "毫秒!");

        start = System.currentTimeMillis();
        for (int i = 0; i < 9999; i++) {
            sb.append("a");
        }
        String res = sb.toString();
        end = System.currentTimeMillis();
        System.out.println("使用StringBuffer的时间是:" + (end - start) + "毫秒!");
    }
}
