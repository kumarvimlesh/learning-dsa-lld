package com.java.learning.test;


public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        System.out.println(test.kthLargestNumber(new String[]{"2","21","12","1"}, 3));
    }


    public String kthLargestNumber(String[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k - 1);
    }

    public String quickSelect(String[] nums, int l, int r, int k){
        int pivotIndex = pivotIndex(nums, l, r, k);
        if(pivotIndex == k) return nums[pivotIndex];
        else if(pivotIndex<k){
            return quickSelect(nums, pivotIndex + 1, r, k);
        }
        else{
            return quickSelect(nums, l, pivotIndex - 1, k);
        }
    }

    public int pivotIndex(String[] nums, int l, int r, int k){
        String pivot = nums[l];
        int i = l+1, j = r;
        while(i<=j){
            while(compareStrings(nums[i], pivot)<=0 && i<r){
                i++;
            }
            while(compareStrings(nums[j], pivot)>0 && j>l){
                j--;
            }
            String tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        nums[j] = pivot;
        nums[l] = nums[j];
        return j;
    }

    private int compareStrings(String num, String pivot) {
        if (num.length()==pivot.length()){
            return num.compareTo(pivot);
        }
        return num.length()-pivot.length();
    }
}

