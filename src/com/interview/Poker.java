package com.interview;

import java.util.Scanner;
/*
https://blog.csdn.net/qq_41999455/article/details/105040128
* 有一叠扑克牌，每张牌介于1和10之间

有四种出牌方法：

单出一张
出两张相同的牌(对子)
出五张顺子(如12345)
出三连对子(如112233)
给10个数，表示1-10每种牌有几张，问最少要多少次能出完？
*
* */
public class Poker {
    //第k个位置
    public int dfs(int[] cards, int k){
        if (k>=cards.length) return 0;
        if (cards[k]==0) return dfs(cards,k+1);

        int res = Integer.MAX_VALUE;
        //优先出连对
        if (k+2<cards.length && cards[k]>=2 && cards[k+1]>=2 && cards[k+2]>=2){
            //出值
            for (int i = k; i <= k+2; i++) {
                cards[i] -= 2;
            }
            res = Math.min(res, dfs(cards, k)+1);
            //还原
            for (int i = k; i <= k+2; i++) {
                cards[i] += 2;
            }
        }

        //出顺子
        if (k+4<cards.length && cards[k]>=1 && cards[k+1]>=1 && cards[k+2]>=1 && cards[k+3]>=1 && cards[k+4]>=1){
            //出值
            for (int i = k; i <= k+4; i++) {
                cards[i] -= 1;
            }
            res = Math.min(res, dfs(cards, k)+1);
            //还原
            for (int i = k; i <= k+4; i++) {
                cards[i] += 1;
            }
        }
        //出对子
        if (cards[k]>=2){
            //出值
            cards[k] -= 2;
            res = Math.min(res, dfs(cards, k)+1);
            //还原
            cards[k] += 2;
        }
        //出单个
        if (cards[k]>=1){
            //出值
            cards[k] -= 1;
            res = Math.min(res, dfs(cards, k)+1);
            //还原
            cards[k] += 1;
        }
//        System.out.println(res);
        return res;
    }

    public static void main(String[] args) {
        int[] cards = new int[10];
        int card_nums = 0;
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            for (int i = 0; i < 10; i++) {
                int temp = in.nextInt();
                if (temp<0 || temp>4){
                    System.out.println(0);
                    continue;
                }
                cards[i] = temp;
                card_nums += temp;
            }
            if (card_nums==0){
                System.out.println(0);
                continue;
            }
            if (card_nums==1){
                System.out.println(1);
                continue;
            }
            Poker t = new Poker();
            int res = t.dfs(cards,0);
            System.out.println(res);
        }

    }
}
