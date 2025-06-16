package com.java.learning.dsa;

import java.util.PriorityQueue;

/**
 * Re-arrange the character in such way that no 2 adjacent char have same.
 * return "" if not possible
 * #mensbrand #interview
 */
public class ReArrangeCharacter {
    public static void main(String[] args) {
        String input = "aabcdsaaaak";
        String output = reArrange(input);
        System.out.println(output);
    }

    private static String reArrange(String input) {
        int[] freq = new int[26];
        for(char c: input.toCharArray()){
            freq[c - 'a'] += 1;
        }
        PriorityQueue<CharCount> priorityQueue = new PriorityQueue<>((b, a) -> Integer.compare(a.count, b.count));
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] == 0) continue;
            CharCount charCount = new CharCount((char) ('a' + i), freq[i]);
            priorityQueue.add(charCount);
        }

        StringBuilder stringBuilder = new StringBuilder();
        while(!priorityQueue.isEmpty()){
            CharCount charCount = priorityQueue.poll();
            if (!stringBuilder.isEmpty() && charCount.c == stringBuilder.charAt(stringBuilder.length() - 1)) {
                if (priorityQueue.isEmpty()) return "";
                CharCount charCount1 = priorityQueue.poll();
                stringBuilder.append(charCount1.c);
                charCount1.count = charCount1.count - 1;
                if (charCount1.count > 0) priorityQueue.add(charCount1);
            }
            else {
                stringBuilder.append(charCount.c);
                charCount.count = charCount.count - 1;
            }
            if (charCount.count > 0) priorityQueue.add(charCount);
        }
        return stringBuilder.toString();
    }

    private static class CharCount{
        char c;
        int count;

        CharCount(char c, int count){
            this.c = c;
            this.count = count;
        }
    }
}
