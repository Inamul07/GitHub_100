// url: https://leetcode.com/problems/max-dot-product-of-two-subsequences/

class Solution {

    Map<String, Integer> map;

    private int dfs(int i, int j, int[] nums1, int[] nums2) {
        if(i == nums1.length || j == nums2.length) return Integer.MIN_VALUE;
        if(map.containsKey(i + "," + j)) return map.get(i + "," + j);
        int v1 = dfs(i+1, j, nums1, nums2), v2 = dfs(i, j+1, nums1, nums2), v3 = dfs(i+1, j+1, nums1, nums2);
        int v4 = (v3 != Integer.MIN_VALUE? v3: 0) + (nums1[i] * nums2[j]), v5 = (nums1[i] * nums2[j]);
        int res = Math.max(Math.max(Math.max(Math.max(v1, v2), v3), v4), v5);
        map.put(i + "," + j, res);
        return res;
    }

    public int maxDotProduct(int[] nums1, int[] nums2) {
        map = new HashMap<>();
        return dfs(0, 0, nums1, nums2);
    }
}
