// url: https://leetcode.com/problems/successful-pairs-of-spells-and-potions/

class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        for(int i = 0; i < spells.length; i++) {
            int start = 0, end = potions.length-1, mid = 0;
            while(start <= end) {
                mid = start + (end - start) / 2;
                if((long) spells[i] * (long) potions[mid] >= success) end = mid-1;
                else start = (mid++)+1;
            }
            spells[i] = potions.length - mid;
        }
        return spells;
    }
}
