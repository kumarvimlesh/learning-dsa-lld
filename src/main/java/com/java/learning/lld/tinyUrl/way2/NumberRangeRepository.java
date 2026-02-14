package com.java.learning.lld.tinyUrl.way2;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class NumberRangeRepository {
    private final Map<Integer, NumberRange> numberRangeMap;
    private final int rangeCount;
    private static NumberRangeRepository instance;

    private NumberRangeRepository() {
        numberRangeMap = new HashMap<>();
        numberRangeMap.put(1, new NumberRange(101, 200));
        numberRangeMap.put(2, new NumberRange(201, 300));
        numberRangeMap.put(3, new NumberRange(301, 400));
        numberRangeMap.put(4, new NumberRange(401, 500));
        rangeCount = 4;
    }

    public static NumberRangeRepository getInstance() {
        if (instance == null){
            instance = new NumberRangeRepository();
        }
        return instance;
    }

    public int getRandomNumberRange() {
        NumberRange numberRange =  numberRangeMap.get(new Random().nextInt(1, rangeCount + 1));
        numberRange.current++;
        return numberRange.current;
    }

    public static class NumberRange{
        int start;
        int end;
        int current;

        public NumberRange(int start, int end) {
            this.start = start;
            this.end = end;
            this.current = start;
        }
    }
}
