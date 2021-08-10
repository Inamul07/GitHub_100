// url: https://leetcode.com/problems/baseball-game/

class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> newOps = new Stack<Integer>();
        int sum = 0;
        for(String s: ops) {
            if(s.equals("+")) {
                int nextVal = 0;
                nextVal += newOps.pop();
                nextVal += newOps.peek();
                newOps.push(nextVal - newOps.peek());
                newOps.push(nextVal);
            }
            else if(s.equals("D"))
                newOps.push(newOps.peek() * 2);
            else if(s.equals("C"))
                newOps.pop();
            else
                newOps.push((Integer.parseInt(s)));
        }
        Iterator<Integer> value = newOps.iterator();
        while(value.hasNext())
            sum += value.next();
        return sum;
    }
}
