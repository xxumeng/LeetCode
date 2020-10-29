package com.offer;

import java.util.Stack;
/*
* 思路1：使用两个栈 Stack
* 思路2：使用链表栈，每个节点存储当前值和最小值
* */
class ListNode30{
    public int val,min;
    public ListNode30 next;
    public ListNode30(int val, int min, ListNode30 next){
        this.val = val;
        this.min = min;
        this.next = next;
    }
}
class MinStack2{
    ListNode30 head;
    public void push(int x){
        if (empty()){
            head = new ListNode30(x, x, null);
        }else {
            head = new ListNode30(x,Math.min(x,head.min),head);
        }
    }
    public void pop(){
        if(empty()){
            throw new IllegalStateException("栈为空");
        }else {
            head = head.next;
        }
    }
    public int top(){
        if(empty()){
            throw new IllegalStateException("栈为空");
        }
        return head.val;
    }
    public int min(){
        if(empty()){
            throw new IllegalStateException("栈为空");
        }
        return head.min;
    }
    public boolean empty(){
        return head==null;
    }
}
class MinStack{
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public MinStack(){

    }
    public void push(int x){
        stack.push(x);
        stack.add(x);
        if (minStack.empty() || x <= minStack.peek()) minStack.push(x);

    }
    public void pop(){
        Integer e = stack.pop();
        System.out.println("pop"+e);
        System.out.println("min_pop"+minStack.peek());
        if(e.equals(minStack.peek()) ) {minStack.pop();}

    }
    public int top(){
        return stack.peek();
    }
    public int min(){
        return minStack.peek();
    }
}
public class Offer30MinStack {
    public static void main(String[] args) {
        //Your MinStack object will be instantiated and called as such:
        MinStack2 obj = new MinStack2();
        obj.push(512);
        obj.push(-1024);
        obj.push(-1024);
        obj.push(512);
        obj.pop();
        obj.pop();
        obj.pop();
        System.out.println(obj.top());
        System.out.println(obj.min());
        Integer e1 = -1024;
        Integer e2 = -1024;
        System.out.println(e1<=e2);
    }
}
