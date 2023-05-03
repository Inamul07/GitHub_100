// url: https://leetcode.com/problems/find-the-difference-of-two-arrays/

class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<Integer> list1 = new ArrayList<>(), list2 = new ArrayList<>();
        Set<Integer> set1 = new HashSet<>(), set2 = new HashSet<>();
        for(int i: nums1) set1.add(i);
        for(int i: nums2) set2.add(i);
        for(int i: set2) if(!set1.contains(i)) list2.add(i);
        for(int i: set1) if(!set2.contains(i)) list1.add(i);
        List<List<Integer>> res = new ArrayList<>();
        res.add(list1); res.add(list2);
        return res;
    }
}
