package com.java.learning.dsa.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 1552. Magnetic Force Between Two Balls
 * In the universe Earth C-137, Rick discovered a special form of magnetic force between two balls if they are put in his new invented basket.
 * Rick has n empty baskets, the ith basket is at position[i],
 * Morty has m balls and needs to distribute the balls into the baskets such that the minimum magnetic force between any two balls is maximum.
 * Rick stated that magnetic force between two different balls at positions x and y is |x - y|.
 * Given the integer array position and the integer m. Return the required force.
 */
public class MagneticForceBetweenTwoBalls {
    private static int ans = 0;
    public static void main(String[] args) {
//        int[] position = {1,2,3,4,7};
//        int m = 3;
        int[] position = {5,4,3,2,1,1000000000};
        int m = 2;
        solution1(position, m);
        System.out.println(ans);
        solution2(position, m);
    }

    private static void solution2(int[] position, int m) {
        Arrays.sort(position);
        System.out.println(binarySearch(position, m));
    }

    private static void solution1(int[] position, int m) {
        backtrack(position, m, 0, new ArrayList<>());
    }

    private static int binarySearch(int[] position, int m) {
        int ans = 0;
        int l = 1;
        int h = position[position.length - 1] - position[0];
        while (l<=h){
            int mid = l + (h - l)/2;
            if (canPlace(position, m, mid)){
                ans = mid;
                l = mid + 1;
            }
            else {
                h = mid - 1;
            }
        }
        return ans;
    }

    private static boolean canPlace(int[] position, int m, int midDist) {
        int lastInd = 0, count = 1;
        for (int i = 1; i<position.length; i++){
            if(position[i] - position[lastInd] >= midDist){
                count++;
                lastInd = i;
                if (count == m) return true;
            }
        }
        return false;
    }

    private static void backtrack(int[] position, int m, int ind, List<Integer> current) {
        if (current.size() == m){
            int minForce = Integer.MAX_VALUE;
            for (int i = 0; i < current.size(); i++) {
                for (int j = i+1; j < current.size(); j++) {
                    minForce = Math.min(minForce, Math.abs(current.get(i) - current.get(j)));
                }
            }
            ans = Math.max(ans, minForce);
            return;
        }

        for (int i = ind; i < position.length; i++) {
            current.add(position[i]);
            backtrack(position,  m, i+1, current);
            current.remove(current.size() - 1);
        }

    }
}
