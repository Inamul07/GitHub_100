// url: https://leetcode.com/problems/minimize-xor/
class Solution {
    public int minimizeXor(int num1, int num2) {
        int num2BitCount = 0;
        int checkBit = 1;
        for(int i = 0; i < 32; i++) {
            if((num2 & checkBit) != 0) num2BitCount++;
            checkBit <<= 1;
        }
        checkBit = (1 << 30);
        int x = 0;
        for(int i = 0; i < 32 && num2BitCount > 0; i++) {
            if((num1 & checkBit) != 0) {
                x |= checkBit;
                num2BitCount--;
            }
            checkBit >>= 1;
        }
        checkBit = 1;
        for(int i = 0; i < 32 && num2BitCount > 0; i++) {
            if((num1 & checkBit) == 0) {
                x |= checkBit;
                num2BitCount--;
            }
            checkBit <<= 1;
        }
        return x;
    }
}
