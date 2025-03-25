// url: https://leetcode.com/problems/check-if-grid-can-be-cut-into-sections/

class Solution {

    private boolean canCut(int[][] arr) {
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        int cuts = 0, prevEnd = arr[0][1];
        for(int i = 0; i < arr.length; i++) {
            if(arr[i][0] >= prevEnd) {
                cuts++;
                if(cuts == 2) return true;
            }
            prevEnd = Math.max(prevEnd, arr[i][1]);
        }
        return false;
    }

    public boolean checkValidCuts(int n, int[][] rectangles) {
        int[][] verticalCuts = new int[rectangles.length][2];
        int[][] horizontalCuts = new int[rectangles.length][2];
        for(int i = 0; i < rectangles.length; i++) {
            int x = rectangles[i][0], y = rectangles[i][2];
            verticalCuts[i][0] = Math.min(x, y);
            verticalCuts[i][1] = Math.max(x, y);
            x = rectangles[i][1];
            y = rectangles[i][3];
            horizontalCuts[i][0] = Math.min(x, y);
            horizontalCuts[i][1] = Math.max(x, y);
        }
        return canCut(verticalCuts) || canCut(horizontalCuts);
    }
}
