package com.java.learning.dsa.array;

import java.util.ArrayList;
import java.util.List;


/**
 * 118. Pascal's Triangle
 * Given an integer numRows, return the first numRows of Pascal's triangle.
 * In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
 *
 *
 * Ans
 *     [1]
 *    [1, 1]
 *   [1, 2, 1]
 *  [1, 3, 3, 1]
 * [1, 4, 6, 4, 1]
 */
public class PascalsTriangle {
    public static void main(String[] args) {
        int numsRow = 5;
        List<List<Integer>> ans = generate(numsRow);
        ans.forEach(pasRow -> {
            for (int i = 0; i < numsRow - pasRow.size(); i++) {
                System.out.print(" ");
            }
            System.out.println(pasRow);
        });
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i<numRows; i++){
            List<Integer> pasRow = new ArrayList<>();
            pasRow.add(1);
            for(int j = 1; j<i; j++){
                pasRow.add(j, ans.get(i-1).get(j-1) +ans.get(i-1).get(j));
            }
            if(i!=0) pasRow.add(i, 1);
            ans.add(pasRow);
        }
        return ans;
    }
}
