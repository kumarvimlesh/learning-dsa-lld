package com.java.learning.dsa.interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


/// Merge Intervals

/**
 * Leetcode 56
 * 56. Merge Intervals
 * Solved
 * Medium
 * Topics
 * premium lock icon
 * Companies
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
 */
public class MergeInterval {
    public static void main(String[] args){
        int[] ineterval1 = new int[]{4, 7};
        int[] ineterval2 = new int[]{3, 10};
        int[][] mergedIntervals = getMergedIntervals(ineterval1, ineterval2).toArray(new int[0][]);
        for (int[] interval : mergedIntervals) {
            System.out.println(interval[0] + " " + interval[1]);
        }

        /// /
        int[][] intervals = new int[][]{{2,3},{4,5},{6,7},{8,9},{1,10}};
        mergedIntervals = merge(intervals);
        for (int[] interval : mergedIntervals) {
            System.out.println(interval[0] + " " + interval[1]);
        }
    }



    public static int[][] merge(int[][] intervals) {
        intervals = Arrays.stream(intervals).sorted(Comparator.comparingInt(a -> a[0])).toArray(int[][]::new);
        List<int[]> ans = new ArrayList<>();
        int[] current = intervals[0];
        for(int i = 1; i<intervals.length; i++){
            List<int[]> mergedIntervals = getMergedIntervals(current, intervals[i]);
            if(mergedIntervals.size()==1){
                current = mergedIntervals.get(0);
            }
            else{
                ans.add(mergedIntervals.get(0));
                current = mergedIntervals.get(1);
            }
        }
        ans.add(current);
        return ans.toArray(new int[0][]);
    }


    private static List<int[]> getMergedIntervals(int[] interval1, int[] interval2) {
        if (interval1[0]>interval2[0]){
            return getMergedIntervals(interval2, interval1);
        }
        if (interval2[0]>interval1[1])
            return List.of(interval1, interval2);
        else {
            if(interval2[1]<=interval1[1]){
                return List.of(interval1);
            }
            else {
                return List.of(new int[]{interval1[0], interval2[1]});
            }
        }
    }
}
