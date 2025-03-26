package com.java.learning.dsa;

/**
 * Given an array of integers nums, find the next permutation of nums.
 * For example, for arr = [1,2,3], the following are all the permutations of arr:
 * [1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].
 */
class NextArrayPermutation {
    public static void nextPermutation(int[] nums) {
        int i = nums.length - 1;
        while(i>0){
            if(nums[i]>nums[i-1]){
                for(int j = nums.length - 1; j> i-1; j--){
                    if(nums[j]>nums[i-1]){
                        int tmp = nums[j];
                        nums[j] = nums[i-1];
                        nums[i-1] = tmp;
                        break;
                    }
                }
                int j = nums.length - 1;
                while (i<j){
                    int tmp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = tmp;
                    i++;
                    j--;
                }
                break;
            }
            i--;
        }
        if(i==0){
            int j = nums.length - 1;
            while(i<j){
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                i++;
                j--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2};
        nextPermutation(arr);
        for (int j : arr) {
            System.out.print(j + " ");
        }
    }
}