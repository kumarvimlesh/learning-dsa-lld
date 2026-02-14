package com.java.learning.dsa.sorting;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 8, 23, 2, 56, 4, 9, 21, 8, 7};
        quickSort(arr);
        Arrays.stream(arr).forEach(num -> System.out.print(num + " "));
    }

    private static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int l, int h){
        if(l>=h) return;
        int pivotIndex = partitionAndGetIndex(arr, l, h, (l+h)/2);
        quickSort(arr, l, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, h);
    }

    private static int partitionAndGetIndex(int[] arr, int l, int h, int pi) {
        swap(arr, h, pi);
        return partitionAndGetIndex(arr, l, h);
    }


    private static int partitionAndGetIndex(int[] arr, int l, int h) {
        int pivot = arr[h];
        int i = l, j = h - 1;
        while (i<=j){
            while (i <= j && arr[i]<=pivot)
                i++;
            while (i<=j && arr[j]>pivot)
                j--;
            if(i<j)
                swap(arr, i, j);
        }
        swap(arr, h, i);
        return i;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
