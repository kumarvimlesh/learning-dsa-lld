package com.java.learning.dsa.string;

import java.util.HashMap;
import java.util.Map;

/**
 *  1781. Sum of Beauty of All Substrings
 *
 *  The beauty of a string is the difference in frequencies between the most frequent and least frequent characters.
 * For example, the beauty of "abaacc" is 3 - 1 = 2.
 * Given a string s, return the sum of beauty of all of its substrings.
 */
public class SumOfBeautOfString {
    public static void main(String[] args) {
        int sumOfBeauty = findSumOfBeauty("aabcbaa");
        System.out.println(sumOfBeauty);
    }

    private static int findSumOfBeauty(String string) {
        int ans = 0;
        for (int i = 0; i < string.length(); i++) {
            int[] freq = new int[26];
            for (int j = i; j < string.length(); j++) {
                freq[string.charAt(j)-'a']++;
                ans += beauty(freq);
            }
        }
        return ans;
    }

    private static int beauty(int[] freq) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int count : freq){
            if (count>max) max = count;
            if (count<min && count!=0) min = count;
        }
//        System.out.println("Beauty of '"+substring+"' : "+(max-min));
        return max-min;
    }
}
