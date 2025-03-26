package com.java.learning.dsa.binarysearch;

/**
 * Given a sorted array arr[] and an integer x,
 * find the index (0-based) of the largest element in arr[] that is less than or equal to x.
 * This element is called the floor of x. If such an element does not exist, return -1.
 */
public class SortedArrayLowerBound {
    public static void main(String[] args) {
       int[] arr = {1, 2, 8, 10, 10, 12, 19};
        System.out.println(findFloor(arr, 5));
    }

    private static int findFloor(int[] arr, int x) {
        return floor(arr, 0, arr.length - 1, x, -1);
    }

    private static int floor(int[] arr,  int l, int h, int x, int ans){
        if (arr.length == 0) return ans;
        while(l<=h){
            int mid = ((h-l) / 2) + l;
            if(arr[mid]<=x){
                ans = mid;
                l = mid+1;
            }
            else h = mid-1;
        }
        return ans;
    }
}
