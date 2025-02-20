// url: https://leetcode.com/problems/find-unique-binary-string/

class Solution {
    public String findDifferentBinaryString(String[] nums) {
        Set<String> set = new HashSet<>();
        for(String num: nums) set.add(num);
        int num = 0;
        while(true) {
            StringBuilder bin = new StringBuilder(Integer.toBinaryString(num));
            while(bin.length() < nums[0].length()) bin.insert(0, "0");
            if(!set.contains(bin.toString())) return bin.toString();
            num++;
        }
    }
}
