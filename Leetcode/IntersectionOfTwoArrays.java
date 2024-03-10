// url: https://leetcode.com/problems/intersection-of-two-arrays/

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for(int i: nums1) set.add(i);
        List<Integer> list = new ArrayList<>();
        int idx = 0;
        for(int i: nums2) {
            if(set.contains(i)) {
                list.add(i);
                set.remove(i);
            }
        }
        int[] arr = new int[list.size()];
        for(int i: list) arr[idx++] = i;
        return arr;
    }
}
