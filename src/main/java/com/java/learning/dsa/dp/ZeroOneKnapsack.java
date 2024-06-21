package com.java.learning.dsa.dp;


import java.util.Arrays;

public class ZeroOneKnapsack {
    public static void main(String[] args) {
//        int[] price = new int[]{2,6,7,4,8,9};
//        int[] wt = new int[]{5,5,7,2,49,9};
//        int capacity = 25;
        ////ans = 26

        int[] price = new int[]{10,15,40};
        int[] wt = new int[]{1,2,3};
        int capacity = 6;
        ///ans = 65

        System.out.println(pickItems(wt, price, capacity));

    }

    private static int pickItems(int[] wt, int[] price, int capacity) {
        int curCap = 0;
        int[][] dp = new int[price.length+1][capacity+1];
        for (int[] dpArr : dp){
            Arrays.fill(dpArr, -1);
        }
        return pickItem(wt, price, curCap, 0, capacity, dp);
    }

    private static int pickItem(int[] wt, int[] price, int curCap, int n, int capacity, int[][] dp) {
        if (n>wt.length-1){
            return 0;
        }
        if (dp[n][curCap]!=-1) return dp[n][curCap];
        int profitWithoutPicking = pickItem(wt, price, curCap, n+1, capacity, dp);
        int profitWithPicking =  curCap+wt[n]>capacity? 0: price[n] + pickItem(wt, price, curCap + wt[n], n+1, capacity, dp);
        return dp[n][curCap] = Math.max(profitWithPicking, profitWithoutPicking);
    }
}
