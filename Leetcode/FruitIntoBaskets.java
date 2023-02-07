// url: https://leetcode.com/problems/fruit-into-baskets/

class Solution {
    public int totalFruit(int[] fruits) {
        if(fruits.length <= 2) return fruits.length;
        Map<Integer, Integer> map = new HashMap<>();
        int start = 0, total = 0, maxTotal = 0;
        for(int end = 0; end < fruits.length; end++) {
            map.put(fruits[end], map.getOrDefault(fruits[end], 0) + 1);
            total++;
            while(map.size() > 2) {
                int val = fruits[start];
                map.put(val, map.get(val) - 1);
                if(map.get(fruits[start]) == 0) map.remove(fruits[start]);
                total--;
                start++;
            } 
            maxTotal = Math.max(total, maxTotal);
        }
        return maxTotal;
    }
}
