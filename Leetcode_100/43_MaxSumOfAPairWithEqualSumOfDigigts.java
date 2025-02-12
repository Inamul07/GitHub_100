// url: https://leetcode.com/problems/max-sum-of-a-pair-with-equal-sum-of-digits/

class Solution {

    private int sumDigit(int num) {
        int sum = 0;
        while(num > 0) {
            sum += (num%10);
            num /= 10;
        }
        return sum;
    }

    public int maximumSum(int[] nums) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        int res = -1;
        for(int i: nums) {
            int sum = sumDigit(i);
            map.putIfAbsent(sum, new PriorityQueue<>((a, b) -> b-a));
            map.get(sum).add(i);
        }
        for(int i: map.keySet()) {
            if(map.get(i).size() < 2) continue;
            int num1 = map.get(i).remove(), num2 = map.get(i).remove();
            res = Math.max(res, num1 + num2);
        }
        return res;
    }
}
