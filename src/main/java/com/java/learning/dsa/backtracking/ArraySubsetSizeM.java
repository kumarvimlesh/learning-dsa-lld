package com.java.learning.dsa.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Print all sub set of size m of array
 */
public class ArraySubsetSizeM {
    public static void main(String[] args) {
        int[] arr = {3, 6, 7, 5, 13, 5, 7, 3, 32};
        int m = 4;
        List<List<Integer>> subsets = new ArrayList<>();
        subsetSizeM(arr, m, 0, new ArrayList<>(), subsets);
        subsets.forEach(subset -> {
            System.out.println();
            subset.forEach(e -> System.out.print(e + " "));
        });
    }

    private static void subsetSizeM(int[] arr, int m, int ind, List<Integer> currentSubSet, List<List<Integer>> answer) {
        if (currentSubSet.size() == m){
            answer.add(new ArrayList<>(currentSubSet));
            return;
        }
        for (int i = ind; i < arr.length - (m - currentSubSet.size()); i++) {
            currentSubSet.add(arr[i]);
            subsetSizeM(arr, m, i+1, currentSubSet, answer);
            currentSubSet.remove(currentSubSet.size() - 1);
        }
    }
}
