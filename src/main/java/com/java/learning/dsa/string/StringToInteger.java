package com.java.learning.dsa.string;

/**
 * ------------------
 * Leetcode - 8. String to Integer (atoi)
 * <a href="https://leetcode.com/problems/string-to-integer-atoi/description/">...</a>
 * ----------------
 * Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer.
 *
 * The algorithm for myAtoi(string s) is as follows:
 *
 * Whitespace: Ignore any leading whitespace (" ").
 * Signedness: Determine the sign by checking if the next character is '-' or '+', assuming positivity if neither present.
 * Conversion: Read the integer by skipping leading zeros until a non-digit character is encountered or the end of the string is reached. If no digits were read, then the result is 0.
 * Rounding: If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then round the integer to remain in the range. Specifically, integers less than -231 should be rounded to -231, and integers greater than 231 - 1 should be rounded to 231 - 1.
 * Return the integer as the final result.
 */
public class StringToInteger {
    public static void main(String[] args) {
        String s = "21474836460";
        int output = myAtoi(s);
        System.out.println(output);
    }

    private static int myAtoi(String s) {
        if (s.isEmpty()) return 0;
        StringBuilder outputString = new StringBuilder();
        boolean pos = true;
        int i = 0;
        while (i<s.length()){
            if (s.charAt(i) == ' ') i++;
            else break;
        }
        if (i<s.length() && s.charAt(i)=='-') {
            pos = false;
        }
        if (i<s.length() && (s.charAt(i) == '-' || s.charAt(i) == '+')) i++;
        while (i<s.length()){
            if (s.charAt(i) == '0') i++;
            else break;
        }
        while (i<s.length()){
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                outputString.append(s.charAt(i));
                i++;
            }
            else break;
        }
        if (outputString.toString().isEmpty()) return 0;
        if (outputString.toString().length()>10){
            if (pos) return Integer.MAX_VALUE;
            else return Integer.MIN_VALUE;
        }
        if (pos && outputString.toString().length()>9 && outputString.toString().compareTo("2147483647")>0)
            return Integer.MAX_VALUE;
        if (!pos && outputString.toString().length()>9 && outputString.toString().compareTo("2147483647")>0)
            return Integer.MIN_VALUE;
        return Integer.parseInt(outputString.toString()) * (pos? 1 : -1);
    }
}
