package com.java.learning.dsa.sorting;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {3, 7, 8, 7, 3, 1, 9, 54, 2, 7, 9, 17, 11, 8};
        mergeSort(arr);
        for (int j : arr) {
            System.out.print(j + " ");
        }
    }

    private static void mergeSort(int[] arr) {
        divide(arr, 0, arr.length-1);
    }

    private static void divide(int[] arr, int l, int h) {
        if (l==h) return;
        int mid = (l + h)/2;
        divide(arr, l, mid);
        divide(arr, mid + 1, h);
        merge(arr, l, mid ,  h);
    }

    private static void merge(int[] arr, int l, int m, int h) {
        int[] tmp = new int[h-l+1];
        int k = 0, i = l, j = m + 1;
        while (k<=h && i<=m && j<=h){
            if (arr[i]<=arr[j]){
                tmp[k++] = arr[i++];
            }
            else {
                tmp[k++] = arr[j++];
            }
        }
        while (i<=m){
            tmp[k++] = arr[i++];
        }
        while (j<=h){
            tmp[k++] = arr[j++];
        }
        System.arraycopy(tmp, 0, arr, l, tmp.length);
    }
}
