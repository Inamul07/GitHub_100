// url: https://leetcode.com/problems/remove-all-occurrences-of-a-substring/

class Solution {
    public String removeOccurrences(String s, String part) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            int currIdx = sb.length()-1, partIdx = part.length()-1;
            boolean found = true;
            while(partIdx >= 0) {
                if(currIdx < 0 || sb.charAt(currIdx) != part.charAt(partIdx)) {
                    found = false;
                    break;
                }
                currIdx--;
                partIdx--;
            }
            if(found) {
                partIdx = part.length()-1;
                currIdx = sb.length()-1;
                while(partIdx >= 0) {
                    sb.deleteCharAt(currIdx);
                    currIdx--;
                    partIdx--;
                }
            }
        }
        return sb.toString();
    }
}
