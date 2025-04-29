package com.java.learning.dsa.array;

import java.util.Arrays;

/**
 * 238. Product of Array Except Self
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 */
public class ProductOfArrayExceptItself {
    public static void main(String[] args) {
        int[] input = {1,2,3,4};
        int[] productExceptSelf1 = productExceptSelf1(input);
        for (int e: productExceptSelf1) System.out.print(e + " ");
        System.out.println();

        System.out.println();
        int[] input2 = {-1,1,0,-3,3};
        int[] productExceptSelf2 = productExceptSelf2(input2);
        for (int e: productExceptSelf2) System.out.print(e + " ");
    }

    //Method 1
    public static int[] productExceptSelf1(int[] nums) {
        int zeroCount = 0, product = 1;
        for (int num : nums) {
            if (num == 0) zeroCount++;
            else product *= num;
        }
        if(zeroCount>1) {
            Arrays.fill(nums, 0);
        }
        else if(zeroCount == 1){
            for(int i = 0; i<nums.length; i++){
                if(nums[i]==0) nums[i] = product;
                else nums[i] = 0;
            }
        }
        else{
            for(int i = 0; i<nums.length; i++){
                nums[i] = product/nums[i];
            }
        }
        return nums;
    }

    //Method 2
    public static int[] productExceptSelf2(int[] nums) {
        int[] prefix = new int[nums.length], suffix = new int[nums.length];
        prefix[0] = 1;
        suffix[nums.length - 1] = 1;
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = prefix[i] * suffix[i];
        }
        return nums;
    }
}
