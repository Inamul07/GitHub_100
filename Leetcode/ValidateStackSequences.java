// url: https://leetcode.com/problems/validate-stack-sequences/

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int p1 = 0, p2 = 0;
        while(p1 < pushed.length) {
            stack.push(pushed[p1++]);
            while(!stack.isEmpty() && stack.peek() == popped[p2]) {
                stack.pop();
                p2++;
            }
        }
        while(p2 < popped.length) {
            if(stack.peek() != popped[p2++]) return false;
            stack.pop();
        }
        return true;
    }
}
