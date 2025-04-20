package com.java.learning.dsa.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given two sorted arrays nums1 and nums2, return an array that contains the union of these two arrays.
 * The elements in the union must be in ascending order.
 * The union of two arrays is an array where all values are distinct and are present in either the first array,
 * the second array, or both.
 */
public class UnionOfTwoSortedArray {
    public static void main(String[] args) {
//        int[] nums1 = {1, 2, 3, 4, 5}, nums2 = {1, 2, 7};
        int[] nums1 = {3, 4, 6, 7, 9, 9}, nums2 = {1, 5, 7, 8, 8};
        int[] sol = unionArray(nums1, nums2);
        Arrays.stream(sol).forEach(el -> System.out.print(el+ " "));
    }
    public static int[] unionArray(int[] nums1, int[] nums2) {
        List<Integer> ans = new ArrayList<>();
        int l = 0, h = 0;
        while(l< nums1.length && h < nums2.length){
            if(nums1[l]==nums2[h]){
                if(ans.isEmpty()){
                    ans.add(nums1[l]);
                }
                else{
                    if(ans.get(ans.size()-1)!=nums1[l]){
                        ans.add(nums1[l]);
                    }
                }
                l++;
                h++;
            }
            else if(nums1[l]<nums2[h]){
                if(ans.isEmpty()){
                    ans.add(nums1[l]);
                }
                else{
                    if(ans.get(ans.size()-1)!=nums1[l]){
                        ans.add(nums1[l]);
                    }
                }
                l++;
            }
            else{
                if(ans.isEmpty()){
                    ans.add(nums2[h]);
                }
                else{
                    if(ans.get(ans.size()-1)!=nums2[h]){
                        ans.add(nums2[h]);
                    }
                }
                h++;
            }
        }

        while(l< nums1.length){
            if(ans.isEmpty()){
                ans.add(nums1[l]);
            }
            else{
                if(ans.get(ans.size()-1)!=nums1[l]){
                    ans.add(nums1[l]);
                }
            }
            l++;
        }

        while(h< nums2.length){
            if(ans.isEmpty()){
                ans.add(nums2[h]);
            }
            else{
                if(ans.get(ans.size()-1)!=nums2[h]){
                    ans.add(nums2[h]);
                }
            }
            h++;
        }
        int[] arr = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            arr[i] = ans.get(i);
        }
        return arr;
    }
}
