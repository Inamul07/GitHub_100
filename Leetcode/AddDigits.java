// url: https://leetcode.com/problems/add-digits/

// Solution 1
class Solution {
    public int addDigits(int num) {
        if(num == 0) return 0;
        return num%9==0? 9: num%9;
    }
}


// Solution 2
class Solution {
    public int addDigits(int num) {
        do {
            int sum = 0;
            while(num > 0) {
                sum += num%10;
                num /= 10;
            }
            num = sum;
        } while(num/10 != 0);
        return num;
    }
}
