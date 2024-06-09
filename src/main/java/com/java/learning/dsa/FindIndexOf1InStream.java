package com.java.learning.dsa;

import java.util.stream.Stream;

public class FindIndexOf1InStream {

    private static int find1Index(Stream<Integer> integerStream){
        int[] arr = integerStream.mapToInt(Integer::intValue).toArray();
        int l = 0, h = arr.length-1;
        int index = Integer.MAX_VALUE;
        while (l<h){
            int mid = l + (h-l)/2;
            if(arr[mid]==1){
                index = Math.min(index, mid);
                h = mid -1;
            }
            else l = mid + 1;
        }
        return index+1;
    }

    public static void main(String[] args){


        Stream<Integer> integerStream = Stream.of(0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1);
        System.out.println(find1Index(integerStream));

        Stream<Integer> integerStream1 = Stream.of(0,0,0,0,1,1,1,1,1,1,1,1,1,1);
        System.out.println(find1Index(integerStream1));

        Stream<Integer> integerStream2 = Stream.of(1,1,1,1,1,1,1,1,1,1);
        System.out.println(find1Index(integerStream2));

    }
}
