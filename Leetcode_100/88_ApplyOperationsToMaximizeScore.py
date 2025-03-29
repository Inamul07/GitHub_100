# url: https://leetcode.com/problems/apply-operations-to-maximize-score/

class Solution:
    def maximumScore(self, nums: List[int], k: int) -> int:
        MOD = (10 ** 9) + 7

        def modExp(base, exp, mod):
            result = 1
            while exp > 0:
                if exp % 2 == 1:
                    result = (result * base) % mod
                base = (base * base) % mod
                exp //= 2
            return result
        
        scores = []
        for num in nums:
            currScore = 0
            for i in range(2, int(sqrt(num)) + 1):
                if num % i == 0:
                    currScore += 1
                    while num % i == 0:
                        num //= i
            if num >= 2:
                currScore += 1
            scores.append(currScore)

        stack = []
        left = [-1] * len(nums)
        right = [len(nums)] * len(nums)
        for i, score in enumerate(scores):
            while stack and scores[stack[-1]] < score:
                right[stack.pop()] = i
            if stack:
                left[i] = stack[-1]
            stack.append(i)

        pq = [(-n, i) for i, n in enumerate(nums)]
        heapify(pq)
        res = 1
        while k > 0:
            n, index = heappop(pq)
            n = -n
            lCount = index - left[index]
            rCount = right[index] - index
            subArrCount = lCount * rCount
            numOperations = min(k, subArrCount)
            res = (res * modExp(n, numOperations, MOD)) % MOD
            k -= numOperations
        return res

''' Java (Fails 1 Testcase)
class Solution {

    private static final int MOD = (int) Math.pow(10, 9) + 7;

    private long modExp(long base, long exp, long mod) {
        long result = 1;
        while(exp > 0) {
            if(exp % 2 == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp /= 2;
        }
        return result;
    }

    public int maximumScore(List<Integer> nums, int k) {
        // Calculating prime scores
        List<Integer> scores = new ArrayList<>();
        for(int num: nums) {
            int currScore = 0;
            for(int i = 2; i <= Math.sqrt(num); i++) {
                if(num % i == 0) {
                    currScore++;
                    while(num % i == 0) num /= i;
                }
            }
            if(num >= 2) currScore++;
            scores.add(currScore);
        }

        // Monotonically Decreasing Stack (Pre-processing)
        Stack<Integer> stack = new Stack<>();
        List<Integer> left = new ArrayList<>(), right = new ArrayList<>();
        for(int i = 0; i < nums.size(); i++) {
            left.add(-1);
            right.add(nums.size());
        }
        for(int i = 0; i < scores.size(); i++) {
            while(!stack.isEmpty() && scores.get(stack.peek()) < scores.get(i)) right.set(stack.pop(), i);
            if(!stack.isEmpty()) left.set(i, stack.peek());
            stack.push(i);
        }

        // Using Priority Queue to get max values from input
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        long res = 1;
        for(int i = 0; i < nums.size(); i++) pq.add(new int[] {nums.get(i), i});
        while(k > 0) {
            int[] node = pq.remove();
            int lCount = node[1] - left.get(node[1]), rCount = right.get(node[1]) - node[1];
            int subArrayCount = lCount * rCount;
            int numOperations = Math.min(k, subArrayCount);
            res = (res * modExp(node[0], numOperations, MOD)) % MOD;
            k -= numOperations;
        }
        return (int) res;
    }
}
'''
