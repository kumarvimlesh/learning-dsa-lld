package com.java.learning.dsa;


class SearchInRotatedSortedArray {

    /**
     * There is an integer array nums sorted in ascending order (with distinct values).
     *
     * Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
     *
     * Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
     * @param args
     */

    public static void main(String[] args) {
        int[] arr = new int[]{6,8,9,23,4,5};
        System.out.print(search(arr, 9));
    }

    public static int getPivotIndex(int[] nums, int l, int h){
        int mid = l + (h-l)/2;
        if(l==h) return l;
        if(h<l) return -1;
        if(mid<h && nums[mid]>nums[mid+1]){
            return mid;
        }
        else if(mid>l && nums[mid]<nums[mid-1]){
            return mid - 1;
        }
        else if(nums[mid]>nums[l]){
            return getPivotIndex(nums, mid+1, h);
        }
        else{
            return getPivotIndex(nums, l, mid-1);
        }
    }

    public static int binarySearch(int[] nums, int l, int h, int target){
        if(l<0 || h <0) return -1;
        while(l<=h){
            int mid = l + (h-l)/2;
            if(nums[mid]==target) return mid;
            else if(nums[mid]<target)
                l = mid + 1;
            else
                h = mid - 1;
        }
        return -1;
    }

    public static int search(int[] nums, int target) {
        int l = 0, h = nums.length - 1;
        int p = getPivotIndex(nums, l, h);
        return Math.max(binarySearch(nums, 0, p, target), binarySearch(nums, p+1, h, target));
    }
}