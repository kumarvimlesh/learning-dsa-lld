package com.java.learning.dsa;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class StringToStringNoAdjaCharSame {

    public static void main(String[] args){
        String str = "AAAABBBBCCCCCC";
        //CACBCABCABCABC
        String output = noAdjaCharSameString(str);
        System.out.println(output);
    }

    /**
     * Given a string, convert to a string such that no adjacent characters are same in new string
     */
    private static String noAdjaCharSameString(String str) {
        Map<Character, Integer> freq = new ConcurrentHashMap<>();
        for(int i = 0;i<str.length();i++){
            freq.put(str.charAt(i), freq.getOrDefault(str.charAt(i), 0)+1);
        }
        StringBuilder ans = new StringBuilder();
        while(!freq.isEmpty()){
            freq.entrySet().stream().sorted((a, b) -> b.getValue()-a.getValue()).limit(2).map(a-> a.getKey())
                    .forEach(c -> {
                        ans.append(c);
                        freq.put(c, freq.getOrDefault(c, 0)-1);
                        if(freq.get(c)==0) freq.remove(c);
                    });
        }
        return ans.toString();
    }

}

