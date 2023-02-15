// url: https://leetcode.com/problems/to-lower-case/

// Solution - 1
class Solution {
  public String toLowerCase(String s) {
    return s.toLowerCase();
  }
}

// Solution - 2
class Solution {
    public String toLowerCase(String s) {
        String res = "";
        for(char ch: s.toCharArray()) {
            if(ch < 97 && Character.isLetter(ch)) ch += 32;
            if(!Character.isLetter(ch))res += Character.valueOf(ch) + "";
            else res += ch + "";
        }
        return res;
    }
}
