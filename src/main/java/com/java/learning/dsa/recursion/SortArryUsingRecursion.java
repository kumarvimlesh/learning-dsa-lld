package com.java.learning.dsa.recursion;

public class SortArryUsingRecursion {
    public static void main(String[] args) {
//        int[] arr = new int[]{3,7,7,9,2,5,0,5};
//        int[] arr = new int[]{1};
//        int[] arr = new int[]{1,4,5,7,8,9};
        int[] arr = new int[]{9,6,5,3,2,1,0,0,0};
        sortArr(arr, arr.length);
        for(int a: arr){
            System.out.print(a + " ");
        }
    }

    private static void sortArr(int[] arr, int n) {
        if(n<=1) return;
        int last = arr[n-1];
        sortArr(arr, n-1);
        insertLast(arr, last, n-1);
    }

    private static void insertLast(int[] arr, int last, int n) {
        if(n==0 || last>=arr[n-1]){
            arr[n] = last;
            return;
        }
        int tmp = arr[n-1];
        insertLast(arr, last, n-1);
        arr[n] = tmp;
    }
}
