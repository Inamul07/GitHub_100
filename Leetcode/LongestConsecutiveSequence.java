// url: https://leetcode.com/problems/longest-consecutive-sequence/

class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i: nums) set.add(i);
        int maxSeq = 0;
        for(int i: nums) {
            if(!set.contains(i-1)) {
                int seq = 1;
                while(set.contains(i+1)) {
                    seq++;
                    i++;
                }
                maxSeq = Math.max(maxSeq, seq);
            }
        }
        return maxSeq;
    }
}
