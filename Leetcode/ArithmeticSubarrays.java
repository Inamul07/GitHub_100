// url: https://leetcode.com/problems/arithmetic-subarrays/

class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> res = new ArrayList<>();
        for(int i = 0; i < l.length; i++) {
            List<Integer> list = new ArrayList<>();
            for(int j = l[i]; j <= r[i]; j++) list.add(nums[j]);
            Collections.sort(list);
            int diff = list.get(1) - list.get(0);
            for(int j = 0; j < list.size()-1; j++) {
                if(list.get(j+1) - list.get(j) != diff) {
                    res.add(false);
                    break;
                }
            }
            if(res.size() != i+1) res.add(true);
        }
        return res;
    }
}
