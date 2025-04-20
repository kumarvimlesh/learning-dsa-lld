package com.java.learning.dsa.binarysearch;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Given a sorted array arr[] and an integer x,
 * find the index (0-based) of the largest element in arr[] that is less than or equal to x.
 * This element is called the floor of x. If such an element does not exist, return -1.
 */
public class SortedArrayLowerBound {
    public static void main(String[] args) {
       int[] arr = {-2,0,2,-2,1,-1};
        System.out.println(findFloor(arr, 5));

        List<List<Integer>> ans = nser(arr);
        ans.forEach(System.out::println);
    }

    private static List<List<Integer>> nser(int[] nums) {
        Set<Set<Integer>> sol = new HashSet<>();
        for(int i = 0; i<nums.length; i++){
            for(int j = i+1; j<nums.length; j++){
                for(int k = j+1; k<nums.length; k++){
                    if(i!=j && i!=k && j!=k && nums[i]+nums[j]+nums[k]==0){
                        Set<Integer> set = new HashSet<>();
                        set.add(nums[i]);
                        set.add(nums[j]);
                        set.add(nums[k]);
                        sol.add(set);
                    }
                }
            }
        }
        return sol.stream().map(s -> (List<Integer>) new ArrayList<>(s)).collect(Collectors.toList());
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
