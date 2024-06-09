package com.java.learning.lld.cacheds;

public class CacheDataStructureApplication {
    public static void main(String[] args) {
        CacheDataStructure<String, Integer> cache = new CacheDataStructure<>();
        cache.put("Vimlesh", 123);
        cache.put("Akash", 124);
        cache.put("XYZ", 111);
        System.out.println(cache.get("Vimlesh"));
    }
}
