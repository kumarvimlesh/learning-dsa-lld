package com.java.learning.test;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args){
        //countOccurenceOfCharInString();

        //reverseStringWithoutReversingSpecialChars();
        functionalInterfaceQuest();
    }

    private static void functionalInterfaceQuest() {
        /**
         * printSecondHighestInList
         */
        List<Integer> list = List.of(1,5,6,3,2,1,6,5,8);
//        System.out.print(list.stream().filter(a -> a!=list.stream().max(Integer::compare).get()).max(Integer::compare).get());
//        System.out.print(list.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst().get());


        /**
         * removeDublicateFromList
         */

//        list.stream().distinct().forEach(System.out::print);

        /**
         * Given a list of strings, group them by their lengths using Java Streams and functional interfaces.
         */

        List<String> stringList = List.of("Hello", "Apple", "Phone", "Car");
        Map<Integer, List<String>> ans = stringList.stream().collect(Collectors.groupingBy(String::length, Collectors.toList()));
                ans.entrySet().forEach(a->{
                    System.out.println(a.getKey());
                    a.getValue().stream().forEach(System.out::println);
                });
        String str = String.format("[%s]", new String(String.join(",", stringList)));
        System.out.println(str);
        System.out.println(stringList.stream().collect(Collectors.joining(",","[","]")));
    }



    private static void reverseStringWithoutReversingSpecialChars() {
        String s = "hello@jx8&3$)";
        System.out.print((char) 59);
        char[] arr = s.toCharArray();
        int l = 0, r = s.length()-1;
        while (l<r){
            while((int) arr[l] < 65 || (int) arr[l] > 144) l++;
            while ((int) arr[r] < 65 || (int) arr[r] > 144) r--;
            char tmp = arr[l];
            System.out.println("l = "+ l + " r = "+ r);
            arr[l] = arr[r];
            arr[r] = tmp;
            l++;
            r--;
        }
        System.out.print(String.copyValueOf(arr));
    }

    private static void countOccurenceOfCharInString() {
        String str = "hello";
        System.out.print(Arrays.stream(str.split("")).collect(Collectors.groupingBy(Function.identity(),Collectors.counting())));
    }
}

