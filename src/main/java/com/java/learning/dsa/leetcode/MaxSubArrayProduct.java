package com.java.learning.dsa.leetcode;

/**
 *
 152. Maximum Product Subarray

 Given an integer array nums, find a subarray that has the largest product, and return the product.
 */
public class MaxSubArrayProduct {
    public static void main(String[] args) {
//        int[] arr = {-5,0,2};
//        int[] arr = {-2,0,-1};
//        int[] arr = {2, 3, -2, 4};
        int[] arr = {2,-5,-2,-4,3};

        int maxProdSubArray = maxProdSubArray(arr);
        System.out.println(maxProdSubArray);
    }

    private static int maxProdSubArray(int[] arr) {
        if (arr.length == 1) return arr[0];
        int prod = 1, zeroCount = 0, negCount = 0;
        for (int j : arr) {
            prod *= j;
            if (j == 0) zeroCount++;
            if (j < 0) negCount++;
        }

        if(zeroCount == 0 && negCount % 2 == 0) return prod;

        int ans = Integer.MIN_VALUE, prevZeroInd = -1;
        for(int i = 0; i< arr.length; i++){
            if(arr[i]==0){
                ans = Math.max(ans, subSetMax(prevZeroInd, i, arr));
                prevZeroInd = i;
            }
        }
        ans = Math.max(ans, subSetMax(prevZeroInd, arr.length-1, arr));
        return ans<0 && zeroCount>0? 0 : ans;
    }

    private static int subSetMax(int prevZeroInd, int i, int[] arr) {
        if (prevZeroInd==-1) prevZeroInd++;
        int pref = 1, suf = 1, max = Integer.MIN_VALUE;
        for (int j = prevZeroInd; j<=i ; j++) {
            if (arr[j] == 0) continue;
            pref *= arr[j];
            max = Math.max(max, pref);
        }
        for (int j = i; j>prevZeroInd ; j--) {
            if (arr[j] == 0) continue;
            suf *= arr[j];
            max = Math.max(max, suf);
        }
        return max;
    }
}
