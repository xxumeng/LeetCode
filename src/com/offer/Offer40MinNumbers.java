package com.offer;

import java.util.Arrays;

public class Offer40MinNumbers {
    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        return Arrays.copyOfRange(arr, 0, k);
    }
}
