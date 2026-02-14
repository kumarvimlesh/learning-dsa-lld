package com.java.learning.dsa.magneticForceBetweenTwoBalls;

import java.util.Arrays;

class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        return binarySearch(position, m);
    }

    private int binarySearch(int[] position, int m) {
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
}