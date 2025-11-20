class Solution {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for(int e : nums){
            if(freq.containsKey(e)) return true;
            else{
                freq.put(e, 1);
            }
        }
        return false;
    }
}