// url: https://leetcode.com/problems/minimum-number-of-operations-to-make-array-continuous/

// O(n log n)
class Solution {
    public int minOperations(int[] nums) {
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        for(int i = 1; i < nums.length; i++) if(nums[i] != nums[i-1]) list.add(nums[i]);
        int r = 0, res = Integer.MAX_VALUE;
        for(int l = 0; l < list.size(); l++) {
            int x1 = list.get(l), x2 = list.get(l) + nums.length - 1;
            while(r < list.size() && list.get(r) <= x2) r++;
            res = Math.min(res, nums.length - (r - l));
        }
        return res;
    }
}


// Brute-Force (TLE)
class Solution {
    public int minOperations(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i: nums) set.add(i);
        int res = Integer.MAX_VALUE;
        for(int num: nums) {
            int val = 0;
            for(int i = num; i < num + nums.length; i++) if(!set.contains(i)) val++;
            res = Math.min(res, val);
        }
        return res;
    }
}
