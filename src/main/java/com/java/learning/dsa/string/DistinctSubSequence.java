package com.java.learning.dsa.string;


/*
115. Distinct Subsequences
Solved
Hard
Topics

Given two strings s and t, return the number of distinct subsequences of s which equals t.

The test cases are generated so that the answer fits on a 32-bit signed integer.
 */
public class DistinctSubSequence {
    public static void main(String[] args) {
        DistinctSubSequence distinctSubSequence = new DistinctSubSequence();
        System.out.println(distinctSubSequence.numDistinctRec("babgbag", "bag"));
        System.out.println(distinctSubSequence.numDistinctDP("babgbag", "bag"));
    }

    private int numDistinctDP(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n+1][m+1];
        for (int i = 0; i <= n; i++) {
            dp[i][m] = 1;
        }

        for (int i = n-1; i >= 0; i--) {
            for (int j = m-1; j >= 0; j--) {
                dp[i][j] = dp[i+1][j];
                if (s.charAt(i) == t.charAt(j))
                    dp[i][j] += dp[i+1][j+1];
            }
        }
        return dp[0][0];
    }

    public int numDistinctRec(String s, String t) {
        int[][] memo = new int[s.length()][t.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < t.length(); j++) {
                memo[i][j] = -1;
            }
        }
        return subSeq(s, t, 0, 0, memo);
    }

    private int subSeq(String s, String t, int sInd, int tInd, int[][] memo) {
        if(tInd == t.length()) return 1;
        if (sInd==s.length()) return 0;
        if (memo[sInd][tInd] != -1) return memo[sInd][tInd];
        int curCount = 0;
        curCount += subSeq(s, t, sInd + 1, tInd, memo);
        if (s.charAt(sInd) == t.charAt(tInd)){
            curCount += subSeq(s, t, sInd + 1, tInd + 1, memo);
        }
        memo[sInd][tInd] = curCount;
        return curCount;
    }

}
