// url: https://leetcode.com/problems/happy-number/

class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<Integer>();
        while(set.add(n)) {
            int sum = 0;
            while(n > 0) {
                sum += (n % 10) * (n % 10);
                n /= 10;
            }
            if(sum == 1)
                return true;
            else if(sum == 4)
                return false;
            n = sum;
        }
        return false;
    }
}
