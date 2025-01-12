// url: https://leetcode.com/problems/check-if-a-parentheses-string-can-be-valid/
class Solution {
    public boolean canBeValid(String s, String locked) {
        if(s.length()%2 != 0) return false;
        Stack<Integer> lockedStack = new Stack<>();
        Stack<Integer> unlockedStack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            if(locked.charAt(i) == '0') unlockedStack.push(i);
            else if(s.charAt(i) == '(') lockedStack.push(i);
            else {
                if(lockedStack.isEmpty() && unlockedStack.isEmpty()) return false;
                if(lockedStack.isEmpty()) unlockedStack.pop();
                else lockedStack.pop();
            }
        }
        while(!lockedStack.isEmpty()) {
            int idx = lockedStack.pop();
            if(unlockedStack.isEmpty() || unlockedStack.peek() < idx) return false;
            unlockedStack.pop();
        }
        return true;
    }
}
