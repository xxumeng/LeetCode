package com.offer;

import java.util.Stack;

public class Offer31StackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
//        栈，用于模拟入站过程
        Stack<Integer> stack = new Stack<>();
        int i=0;
        for (int p: pushed) {
//            假如不等于出栈元素，入栈
            if (p!=popped[i]){
                stack.add(p);
            }else{
//              等于出栈元素时，判断栈中下一个元素是否等于下一个出栈元素
                i ++;
                while(!stack.isEmpty() && stack.peek() == popped[i]){
                    i++;
                    stack.pop();
                }
            }
        }
//        最后都能顺利出栈，返回true，否则返回false
        return stack.isEmpty();
    }
}
