// url: https://leetcode.com/problems/minimum-cost-to-make-array-equal/

class Pair {
    int num, cost;

    Pair(int num, int cost) {
        this.num = num;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "{" + num + ", " + cost + "}";
    }
}

class Solution {
    public long minCost(int[] nums, int[] cost) {
        List<Pair> list = new ArrayList<>();
        long totalCost = 0, currCost = 0, key = -1, minCost = 0;
        for(int i = 0; i < nums.length; i++) {
            list.add(new Pair(nums[i], cost[i]));
            totalCost += cost[i];
        }
        Collections.sort(list, (Pair a, Pair b) -> {
            return a.num - b.num;
        });
        for(Pair pair: list) {
            currCost += pair.cost;
            if(currCost > (totalCost/2)) {
                key = pair.num;
                break;
            }
        }
        System.out.println(key);
        for(Pair pair: list) minCost += (pair.cost * Math.abs(pair.num-key));
        return minCost;
    }
}
