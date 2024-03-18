// url: https://leetcode.com/problems/sum-of-unique-elements/

class Solution {
    public int sumOfUnique(int[] nums) {
        Map<Integer, Boolean> map = new HashMap<>();
        int sum = 0;
        for(int i: nums) {
            if(map.containsKey(i) && map.get(i)) {
                sum -= i;
                map.put(i, false);
            } else if(!map.containsKey(i)) {
                sum += i;
                map.put(i, true);
            }
        }
        return sum;
    }
}
