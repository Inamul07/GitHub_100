// url: https://leetcode.com/problems/count-and-say/

class Solution {
    public String countAndSay(int n) {
        String currString = "1";
        for(int i = 2; i <= n; i++) {
            int currCount = 0;
            char currChar = currString.charAt(0);
            StringBuilder newString = new StringBuilder();
            for(int j = 0; j < currString.length(); j++) {
                if(currString.charAt(j) != currChar) {
                    newString.append(currCount).append(currChar);
                    currChar = currString.charAt(j);
                    currCount = 0;
                }
                currCount++;
            }
            newString.append(currCount).append(currChar);
            currString = newString.toString();
        }
        return currString;
    }
}
