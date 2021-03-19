package com.backtrack;

import java.util.ArrayList;
import java.util.List;

public class Decare {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> track = new ArrayList<>();
    public void decare(List<List<Integer>> all, int index){
        if (index==all.size()){
            res.add(new ArrayList<>(track));
            return;
        }
        List<Integer> list = all.get(index);
        for (int num:list) {
            track.add(num);
            decare(all,index+1);
            track.remove(track.size()-1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> all = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);

        list2.add(4);
        list2.add(5);
        list2.add(6);

        list3.add(7);
        list3.add(8);
        list3.add(9);

        all.add(list1);
        all.add(list2);
        all.add(list3);

        Decare test = new Decare();
        test.decare(all,0);

        for (int i = 0; i < test.res.size(); i++) {
            List<Integer> temp = test.res.get(i);
            for (int j = 0; j < temp.size(); j++) {
                System.out.print(temp.get(j)+",");
            }
            System.out.println();
        }
        System.out.println(test.res.size());
    }
}
