// url: https://leetcode.com/problems/number-of-laser-beams-in-a-bank/

class Solution {
    public int numberOfBeams(String[] bank) {
        List<Integer> numDevices = new ArrayList<>();
        for(String row: bank) {
            int count = 0;
            for(char ch: row.toCharArray()) if(ch == '1') count++;
            if(count != 0) numDevices.add(count);
        }
        int numBeams = 0;
        for(int i = 1; i < numDevices.size(); i++) numBeams += (numDevices.get(i) * numDevices.get(i-1));
        return numBeams;
    }
}
