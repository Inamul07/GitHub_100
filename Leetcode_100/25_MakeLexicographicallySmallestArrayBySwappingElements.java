// url: https://leetcode.com/problems/make-lexicographically-smallest-array-by-swapping-elements/

class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        Map<Integer, Queue<Integer>> map = new HashMap<>();
        int[] copy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(nums);
        int prev = nums[0] - limit - 1;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] - prev > limit) map.put(nums[i], new LinkedList<>());
            else map.put(nums[i], map.get(prev));
            map.get(nums[i]).add(nums[i]);
            prev = nums[i];
        }
        int idx = 0;
        for(int i = 0; i < copy.length; i++) copy[i] = map.get(copy[i]).remove();
        return copy;
    }
}
