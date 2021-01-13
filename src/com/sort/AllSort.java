package com.sort;

import java.util.*;

public class AllSort {
//    选择排序,时间复杂度n²。每轮选择未排序最小值（最小，第二小，第三小...）
    public int[] selectSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            //每轮选择未排序的最小值
            int minIndex = i;
            for (int j=i; j < arr.length; j++){
                if (arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            //交换
            int tmp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = tmp;
        }
        System.out.println("选择排序："+Arrays.toString(arr));
        return arr;
    }
//    插入排序（已排序，未排序，从未排序取出与已排序从后往前比较找到合适位置）
    public int[] insertSort(int[] arr){
        //0~i-1 是排序数组
        for(int i=1; i<arr.length; i++){
            //pre初始化为已排序数组的最后一位
            int pre=i-1;
            int cur = arr[i];
            //如果当前值小于已排序的pre位置，那么pre--，直到找到当前值的位置；同时pre以后的位置向后移
            while(pre>=0 && arr[pre]>cur){
                arr[pre+1] = arr[pre];
                pre--;
            }
            //pre+1是当前值的最终位置
            arr[pre+1] = cur;
        }
        System.out.println("插入排序："+Arrays.toString(arr));
        return arr;

    }
//    希尔排序，时间复杂度
    public int[] shellSort(int[] arr){
        if (arr==null) return new int[0];
        //动态间隙，每次减少一半
        for (int gap = arr.length/2; gap>0; gap=gap/2){
            for(int i=gap; i<arr.length; i++){
                int j=i;
                while(j-gap>=0 && arr[j]<arr[j-gap]){
                    int tmp= arr[j];
                    arr[i] = arr[j-gap];
                    arr[j-gap] = tmp;
                }
            }
        }
        System.out.println("希尔排序(缩小增量排序)："+Arrays.toString(arr));
        return arr;
    }
//    归并排序
    public void merge(int[] arr, int l, int m, int r){
        int[] res = new int[r-l+1];
        int lStart = l;
        int rStart=m+1;
        int i=0;
        while(lStart<=m && rStart<=r){
            if(arr[lStart]<=arr[rStart]) {
                res[i] = arr[lStart];
                lStart++;
            }else{
                res[i] = arr[rStart];
                rStart++;
            }
            i++;
        }
        while(lStart<=m){
            res[i] =arr[lStart];
            lStart++;
            i++;
        }
        while(rStart<=r){
            res[i] =arr[rStart];
            rStart++;
            i++;
        }
        for (int j=0; j<i; j++){
            arr[l+j] = res[j];
        }
    }
    public void mergeSort(int[] arr, int l, int r){
        if(l==r) return;
        int mid = (r-l)/2 +l;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid+1, r);
        merge(arr, l, mid, r);
    }
//    快速排序,指定一个值，使小于它的都放在左边，大于他的都放在右边
    public int partion(int[] arr, int l, int r){
        int p = l;
        int pivot = arr[l];
        while(l<r){
            //从右往左找比pivot小的
            while(l<r && arr[r] >= pivot) r--;
            //重点：必须使l指针能过越过当前值
            while(l<r && arr[l] <= pivot) l++;
            if(l<r) swap(arr, l, r);
        }
        swap(arr, p, l);
        return l;
    }
    public void swap(int[] arr, int l, int r){
        int tmp = arr[l];
        arr[l] = arr[r];
        arr[r] = tmp;

    }
    public void quickSort(int[] arr, int l, int r){
        int partIndex = partion(arr, l, r);
//        System.out.println(partIndex);
//        System.out.println(Arrays.toString(arr));

        if (partIndex-1 > l) quickSort(arr, l, partIndex-1);
        if (partIndex+1 < r) quickSort(arr, partIndex+1, r);

    }
//    堆排序
    //向下调整
    public void sift(int[] arr, int low, int high){
        //low指的堆顶
        //high指的最后一个节点

        //指针i指向父亲层，j指向孩子层
        int i = low;
        int j = 2*i+1;

        //堆顶
        int tmp = arr[low];
        //当j>high时，i一定是最后一层了。循环内容（比较tmp和孩子节点的大小，当tmp>两个孩子节点就终止，）
        while(j<=high){
            //如果右孩子(保证有右孩子)大于左孩子，将j指向右孩子，保证下次向下调整右子树。
            if(j+1<=high && arr[j+1] > arr[j]) j = j+1;
            //当孩子值有大于tmp，孩子上移
            if(arr[j]>tmp) {
                arr[i] = arr[j];
                i = j;
                j = 2*i+1;
            }else {
                //当tmp找到了合适位置
                //arr[i] = tmp;
                break;
            }
        }
        arr[i] = tmp;
    }
    public void heapSort(int[] arr){
        //1. 构造堆
        //1.1 找到最后一个非叶子节点，循环
        int high = arr.length - 1;
        for(int i=(high-1)/2; i>=0; i--){
            //由于向上之后要调整好几层，所以不能使用j。最后一个节点的作用是判断是否越界，因此这里传入high
            sift(arr, i, high);
        }
        System.out.println("堆构造完成："+ Arrays.toString(arr));
        //2. 堆排序
        // 堆顶i， 尾部j
        for (int j=high; j>=0; j--){
            int tmp = arr[0];
            arr[0] = arr[j];
            arr[j] = tmp;
            sift(arr, 0, j-1);
        }
        System.out.println("堆排序完成："+ Arrays.toString(arr));

    }
//    计数排序
    public void countSort(int[] arr, int maxCount){
        int[] counts = new int[maxCount+1];
        for (int val: arr) counts[val] += 1;

        int loc = 0;
        for (int i = 1; i < counts.length; i++) {
            while (counts[i]!=0) {
                arr[loc] = i;
                loc++;
                counts[i]--;
            }
        }
        System.out.println("计数排序："+ Arrays.toString(arr));
    }
//    桶排序
    public void bucket_sort(int[] arr, int n, int maxCount){
        //初始化桶
        List<LinkedList<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            buckets.add(new LinkedList<Integer>());
        }
        //放入桶中
        for (int val: arr) {
            int i = Math.min(val/n, n-1);
//            System.out.print("val:"+val+" 放入第"+ i + "个桶。当前桶内的值"+buckets.get(i));

            //放入桶中时排序[0 2 4] 3
            ListIterator<Integer> iter = buckets.get(i).listIterator();
            boolean flag = false;
            while(iter.hasNext()){
                if(val <= iter.next()){
                    iter.previous(); // 把迭代器的位置偏移回上一个位置
                    iter.add(val);// 把数据插入到迭代器的当前位置
                    flag = true;
                    break;
                }
            }
            if (!flag) buckets.get(i).add(val);
//            System.out.println("。插入后桶内的值"+buckets.get(i));
        }
        int loc = 0;
        for (List<Integer> bucket:buckets) {
            for (int val: bucket) {
                arr[loc] = val;
                loc++;
            }
        }
        System.out.println("桶排序："+ Arrays.toString(arr));
    }
    public void raddixSort(int[] arr){
        int maxValue = Integer.MIN_VALUE;
        for (int val : arr){
            if(val>maxValue) maxValue = val;
        }
        int t=0;
        while(Math.pow(10, t) <= maxValue){
            //初始化桶
            List<LinkedList<Integer>> buckets = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                buckets.add(new LinkedList<Integer>());
            }
            for (int val: arr) {
                // 987 t=1取8，987/10 % 10, t=2取9,987/100 %10
                int i = val / (int)Math.pow(10, t) % 10;
                buckets.get(i).add(val);
            }
            int loc = 0;
            for (List<Integer> bucket:buckets) {
                for (int val: bucket) {
                    arr[loc] = val;
                    loc++;
                }
            }
            t++;
        }
        System.out.println("基数排序："+ Arrays.toString(arr));

    }
    public static void main(String[] args) {
        AllSort solve = new AllSort();
        int[] arr = {1,9,2,3,5,8,4,10,6,7};
        solve.selectSort(arr);
        arr = new int[]{1, 9, 2, 3, 5, 8, 4, 10, 6, 7};
        solve.insertSort(arr);
        arr = new int[]{1, 9, 2, 3, 5, 8, 4, 10, 6, 7};
        solve.shellSort(arr);
        arr = new int[]{1, 9, 2, 3, 5, 8, 4, 10, 6, 7};
        solve.mergeSort(arr,0,arr.length-1);
        System.out.println("归并排序："+Arrays.toString(arr));
        arr = new int[]{1, 9, 2, 3, 5, 8, 4, 10, 6, 7};
        solve.quickSort(arr,0,arr.length-1);
        System.out.println("快速排序："+Arrays.toString(arr));
        arr = new int[]{1, 9, 2, 3, 5, 8, 4, 10, 6, 7};
        solve.heapSort(arr);
        arr = new int[]{1, 9, 2, 3, 5, 8, 4, 10, 6, 7};
        solve.countSort(arr, 10);
        arr = new int[]{1, 9, 2, 3, 5, 8, 4, 10, 6, 7};
        solve.bucket_sort(arr, 4, 10);
        arr = new int[]{1, 9, 2, 3, 5, 8, 4, 10, 6, 7};
        solve.raddixSort(arr);
    }
}
