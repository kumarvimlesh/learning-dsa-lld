package com.java.learning.dsa.sorting;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {3, 7, 8, 7, 3, 1, 9, 54, 2, 7, 9, 17, 11, 8};
        int[] sorted = mergeSort(arr);
        for (int j : sorted) {
            System.out.print(j + " ");
        }
    }

    private static int[] mergeSort(int[] arr) {
        return divide(arr);
    }

    private static int[] divide(int[] arr) {
        if (arr.length == 1) return arr;
        int[] a = new int[arr.length/2];
        int[] b = new int[arr.length - a.length];
        System.arraycopy(arr, 0, a, 0, a.length);
        System.arraycopy(arr, a.length, b, 0, b.length);
        return merge(divide(a), divide(b));
    }

    private static int[] merge(int[] a, int[] b){
        int[] sorted = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;
        while (k < sorted.length && i<a.length && j<b.length){
            if (a[i]<=b[j]){
                sorted[k] = a[i++];
            }
            else sorted[k] = b[j++];
            k++;
        }
        while (i<a.length){
            sorted[k++] = a[i++];
        }

        while (j<b.length){
            sorted[k++] = b[j++];
        }
        return sorted;
    }
}
