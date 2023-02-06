// url: https://leetcode.com/problems/shuffle-the-array/

// Brute Force

class Solution {
    public int[] shuffle(int[] nums, int n) {
        if(n == 1) return nums;
        int x1 = 0, x2 = n, idx = 0;
        int[] res = new int[nums.length];
        for(int i = 0; i < nums.length; i+=2) {
            res[i] = nums[x1];
            res[i+1] = nums[x2];
            x1++;
            x2++;
        }
        return res;
    }
}

// Bit Manipulation

class Solution {
    public int[] shuffle(int[] nums, int n) {
        for(int i = 0; i < n; i++) {
            nums[i] = nums[i] << 10;
            nums[i] = nums[i] | nums[i+n]; // Merge x & y
        }
        int idx = nums.length-1;
        for(int i = n-1; i >= 0; i--) {
            nums[idx] = nums[i] & (1024-1);
            nums[idx-1] = nums[i] >> 10;
            idx -= 2;
        }
        return nums;
    }
}

