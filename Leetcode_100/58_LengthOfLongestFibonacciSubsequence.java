// url: https://leetcode.com/problems/length-of-longest-fibonacci-subsequence/

class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int maxSeq = 0;
        Set<Integer> set = new HashSet<>();
        for(int i: arr) set.add(i);
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr.length; j++) {
                if(i == j) continue;
                int fNum = arr[i], sNum = arr[j], currSeq = 2;
                if(fNum > sNum) continue;
                while(set.contains(fNum + sNum)) {
                    int temp = fNum;
                    fNum = sNum;
                    sNum = temp + sNum;
                    currSeq++;
                }
                maxSeq = Math.max(maxSeq, currSeq);
            }
        }
        return maxSeq >= 3? maxSeq: 0;
    }
}
