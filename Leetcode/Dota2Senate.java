// url: https://leetcode.com/problems/dota2-senate/

class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> rq = new LinkedList<>(), dq = new LinkedList<>();
        for(int i = 0; i < senate.length(); i++) {
            if(senate.charAt(i) == 'R') rq.add(i);
            else dq.add(i);
        }
        while(!rq.isEmpty() && !dq.isEmpty()) {
            int i = rq.poll(), j = dq.poll();
            if(i < j) rq.add(i+senate.length());
            else dq.add(i+senate.length());
        }
        return rq.isEmpty()? "Dire": "Radiant";
    }
}
