// url: https://leetcode.com/problems/shortest-common-supersequence/

// DP Table
class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        String[] prev = new String[str2.length() + 1];
        for(int i = 0; i <= str2.length(); i++) {
            if(i == str2.length()) prev[i] = "";
            else prev[i] = str2.substring(i);
        }
        for(int i = str1.length()-1; i >= 0; i--) {
            String[] curr = new String[str2.length() + 1];
            for(int j = 0; j < str2.length(); j++) curr[j] = "";
            curr[str2.length()] = str1.substring(i);

            for(int j = str2.length()-1; j >= 0; j--) {
                if(str1.charAt(i) == str2.charAt(j)) {
                    curr[j] = str1.charAt(i) + prev[j+1];
                } else {
                    String l = str1.charAt(i) + prev[j];
                    String r = str2.charAt(j) + curr[j+1];
                    if(l.length() < r.length()) curr[j] = l;
                    else curr[j] = r;
                }
            }
            prev = Arrays.copyOf(curr, curr.length);
        }
        return prev[0];
    }
}
