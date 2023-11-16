// url: https://leetcode.com/problems/find-unique-binary-string/

// Brute Force
class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int currNum = 0;
        Set<String> set = new HashSet<>();
        for(String s: nums) set.add(s);
        while(true) {
            String b = Integer.toBinaryString(currNum);
            StringBuilder bin = new StringBuilder();
            for(int i = 0; i < nums.length-b.length(); i++) bin.append("0");
            bin.append(b);
            if(!set.contains(bin.toString())) return bin.toString();
            currNum++;
        }
    }
}

// Backtracking
class Solution {

    Set<String> set;
    String res;

    private boolean backtrack(String s, int n) {
        if(s.length() == n) {
            if(!set.contains(s)) {
                res = s;
                return true;
            } else return false;
        }
        return backtrack(s + "0", n) || backtrack(s + "1", n);
    }

    public String findDifferentBinaryString(String[] nums) {
        set = new HashSet<>();
        res = "";
        for(String s: nums) set.add(s);
        backtrack("", nums.length);
        return res;
    }
}
