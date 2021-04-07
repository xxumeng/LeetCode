package com.offer;

import java.util.PriorityQueue;
import java.util.Queue;

/*找到中位数*/
public class Offer41MedianFinder {
    Queue<Integer> A;
    Queue<Integer> B;

    /** initialize your data structure here. */
    public Offer41MedianFinder() {
        A = new PriorityQueue<>();
        B = new PriorityQueue<>((x,y)->(y-x));
    }

    public void addNum(int num) {
        if (A.size()==B.size()){
            B.add(num);
            A.add(B.poll());
        }else {
            A.add(num);
            B.add(A.poll());
        }
    }

    public double findMedian() {
        return A.size()==B.size()?(A.peek()+B.peek())/2:A.peek();
    }
}
