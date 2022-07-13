// url: https://leetcode.com/problems/container-with-most-water/

class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0, i = 0, j = height.length-1;
        while(i < j) {
            maxArea = Math.max(maxArea, (j-i)*(Math.min(height[i], height[j])));
            if(height[i] < height[j]) i++;
            else j--;
        }
        return maxArea;
    }
}