package com.java.learning.leetcode;


public class TripletSubsequence {
    /**
     * Given an integer array nums, return true if there exists a triple of indices (i, j, k)
     * such that i < j < k and nums[i] < nums[j] < nums[k]. If no such indices exists, return false.
     * @param args
     */
    public static void main(String[] args) {
        //int[] arr = new int[]{2, 5, 8, 4, 21, 43, 2, 4};
        int[] arr = new int[]{3, 1, 0, 2};
        System.out.println(ifTripletMethod1(arr));
        System.out.println(ifTripletMethod2(arr));
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static boolean ifTripletMethod2(int[] arr) {
        if (arr == null || arr.length < 3) {
            return false;
        }

        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for (int a : arr) {
            if (a <= first) {
                first = a;
            } else if (a <= second) {
                second = a;
            } else {
                return true;
            }
        }
        return false;
    }

    private static boolean ifTripletMethod1(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int cnt = 0;
            for (int l = 0; l < i; l++) {
                if (arr[l]<arr[i]) {
                    cnt++;
                    break;
                }
            }
            for (int h = i+1; h < arr.length; h++) {
                if (arr[h]>arr[i]) {
                    cnt++;
                    break;
                }
            }
            if(cnt>=2){
                return true;
            }
        }
        return false;
    }
}
