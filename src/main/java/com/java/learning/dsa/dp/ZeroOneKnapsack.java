package com.java.learning.dsa.dp;


import java.util.Arrays;

public class ZeroOneKnapsack {
    public static void main(String[] args) {
        int[] price = new int[]{2,6,7,4,8,9};
        int[] wt = new int[]{5,5,7,2,49,9};
        int capacity = 25;
        //ans = 26

//        int[] price = new int[]{10,15,40};
//        int[] wt = new int[]{1,2,3};
//        int capacity = 6;
//        ///ans = 65

//        System.out.println(pickItems(wt, price, capacity));
        System.out.println(knapsackTopToBottom(wt, price, capacity));

    }

    private static int knapsackTopToBottom(int[] wt, int[] price, int capacity) {
        int[][] dp = new int[price.length+1][capacity+1];
        for(int i = 0;i<price.length+1;i++){
            dp[i][0] = 0;
        }
        for (int i = 0; i<capacity+1;i++){
            dp[0][i] = 0;
        }

        for(int i=1;i<price.length+1;i++){
            for(int j = 1;j<capacity+1;j++){
                int profitWithoutPicking = dp[i-1][j]; //pickItem(wt, price, curCap, n+1, capacity, dp);
                int profitWithPicking =  wt[i-1]>j? 0 : price[i-1] + dp[i-1][j-wt[i-1]];// +wt[n]>capacity? 0: price[n] + pickItem(wt, price, curCap + wt[n], n+1, capacity, dp);
                dp[i][j] = Math.max(profitWithPicking, profitWithoutPicking);
            }
        }
        return dp[price.length][capacity];
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
