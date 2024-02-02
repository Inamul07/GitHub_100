// url: https://leetcode.com/problems/sequential-digits/

class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        Queue<Integer> q = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        for(int i = 1; i <= 9; i++) q.add(i);
        while(!q.isEmpty()) {
            int num = q.remove();
            if(num >= low && num <= high) res.add(num);
            int newNum = (num * 10) + ((num%10) + 1);
            if(newNum <= high && newNum%10 != 0) q.add(newNum);
        }
        return res;
    }
}
