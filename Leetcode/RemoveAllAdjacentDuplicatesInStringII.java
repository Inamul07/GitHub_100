// url: https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/

class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Character> charStack = new Stack<>();
        Stack<Integer> countStack = new Stack<>();
        for(char ch: s.toCharArray()) {
            if(!charStack.isEmpty() && charStack.peek().equals(ch)) {
                charStack.push(ch);
                countStack.push(countStack.pop() + 1);
                if(!charStack.isEmpty() && !countStack.isEmpty() && countStack.peek().equals(k)) {
                    countStack.pop();
                    for(int i = 0; i < k; i++) charStack.pop();
                }
            } else {
                charStack.push(ch);
                countStack.push(1);
            }
        }
        s = "";
        for(char ch: charStack) s += ch + "";
        return s;
    }
}
