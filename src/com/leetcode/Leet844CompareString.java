package com.leetcode;

public class Leet844CompareString {
    public boolean backspaceCompare(String S, String T) {
        S = build(S);
        T= build(T);
        System.out.println(S);
        System.out.println(T);
        if (S.equals(T)){
            return true;
        }else {
            return false;
        }

    }
    public String build(String s){
        StringBuffer buildT = new StringBuffer();
        for (int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c!='#'){
                buildT.append(c);
            }else if(buildT.length()!=0){
                buildT.deleteCharAt(buildT.length()-1);

            }
        }
        return buildT.toString();
    }

    public static void main(String[] args) {
        String S = "ab#c", T = "ad#c";
        Leet844CompareString method = new Leet844CompareString();
        System.out.println(method.backspaceCompare(S,T));

    }
}
