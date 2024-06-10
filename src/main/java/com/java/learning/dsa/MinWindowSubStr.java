package com.java.learning.dsa;

import java.util.HashMap;
import java.util.Map;

public class MinWindowSubStr {
    /**
     * 76. Minimum Window Substring
     *
     * Given two strings s and t of lengths m and n respectively, return the minimum window
     * substring
     * of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".
     *
     * The testcases will be generated such that the answer is unique.
     * @param args
     */
    public static boolean match(Map<Character, Integer> t, Map<Character, Integer> s){
        for(Map.Entry<Character, Integer> entry : t.entrySet()){
            char key = entry.getKey();
            int cnt = entry.getValue();
            if(cnt> s.getOrDefault(key, 0)){
                return false;
            }
        }
        return true;
    }

    public static String minWindow(String s, String t) {
        if(s.length()<t.length()) return "";
        Map<Character, Integer> tFreq = new HashMap<>();
        for(char a: t.toCharArray()){
            if(tFreq.containsKey(a)){
                tFreq.put(a, tFreq.get(a)+1);
            }
            else{
                tFreq.put(a, 1);
            }
        }

        Map<Character, Integer> freq = new HashMap<>();
        int i = -1, j = s.length();
        int l = 0, h = 0;

        while(h<s.length()){
            freq.put(s.charAt(h), freq.getOrDefault(s.charAt(h), 0)+1);
            while(match(tFreq, freq)){
                if((h-l)<(j-i)){
                    i = l;
                    j = h;
                }
                freq.put(s.charAt(l),freq.get(s.charAt(l)) - 1);
                l++;
            }
            h++;
        }
        if(i<0 || j> s.length()) return "";
        return s.substring(i, j+1);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t));
    }


}
