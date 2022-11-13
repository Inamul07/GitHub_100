// url: https://leetcode.com/problems/reverse-words-in-a-string/

class Solution {
    public String reverseWords(String s) {
        String[] arr = s.trim().split(" ");
        String res = "";
        for(int i = arr.length-1; i >= 0; i--) {
            if(arr[i].isEmpty()) continue;
            if(i != arr.length-1) res += " ";
            res += arr[i].trim();
        }
        return res;
    }
}
