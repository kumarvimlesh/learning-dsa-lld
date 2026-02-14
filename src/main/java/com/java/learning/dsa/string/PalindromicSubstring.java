package com.java.learning.dsa.string;

/*
647. Palindromic Substrings

Medium

Given a string s, return the number of palindromic substrings in it.

A string is a palindrome when it reads the same backward as forward.

A substring is a contiguous sequence of characters within the string.
 */
public class PalindromicSubstring {
    public static void main(String[] args) {
        PalindromicSubstring palindromicSubstring = new PalindromicSubstring();
        System.out.println(palindromicSubstring.countSubstrings("aaa"));
    }
    public int countSubstrings(String s) {
        int count = 0;
        for(int i = 0; i< s.length(); i++){
            int l = i, r = i;
            while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
                count++;
                l--;
                r++;
            }
            l = i - 1;
            r = i;
            while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
                count++;
                l--;
                r++;
            }
        }
        return count;
    }
}
