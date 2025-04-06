# url: https://leetcode.com/problems/largest-divisible-subset/

class Solution:
    def largestDivisibleSubset(self, nums: List[int]) -> List[int]:

        def dfs(idx: int) -> List[int]:
            if idx == len(nums):
                return []
            if idx in map:
                return map[idx]
            res = [nums[idx]]
            for i in range(idx+1, len(nums)):
                if nums[i] % nums[idx] == 0:
                    calc = [nums[idx]] + dfs(i)
                    if len(calc) > len(res):
                        res = calc
            map[idx] = res
            return res
        
        nums.sort()
        map = {}

        res = []
        for i in range(0, len(nums)):
            calc = dfs(i)
            if len(calc) > len(res):
                res = calc
        return res

'''
JAVA CODE:
class Solution {

    Map<Integer, List<Integer>> map;

    private List<Integer> dfs(int idx, int[] nums) {
        if(idx == nums.length) return new ArrayList<>();
        if(map.containsKey(idx)) return map.get(idx);
        List<Integer> res = new ArrayList<>();
        res.add(nums[idx]);
        for(int i = idx+1; i < nums.length; i++) {
            if(nums[i] % nums[idx] == 0) {
                List<Integer> calc = dfs(i, nums);
                calc.add(0, nums[idx]);
                if(calc.size() > res.size()) res = new ArrayList<>(calc);
            }
        }
        map.put(idx, new ArrayList<>(res));
        return res;
    }

    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            List<Integer> calc = dfs(i, nums);
            if(calc.size() > res.size()) res = new ArrayList<>(calc);
        }
        return res;
    }
}
'''
