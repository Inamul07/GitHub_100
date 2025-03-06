# url: https://leetcode.com/problems/find-missing-and-repeated-values/

class Solution(object):
    def findMissingAndRepeatedValues(self, grid):
        n = len(grid) * len(grid[0])
        actualSum, compSum = (n * (n + 1)) // 2, 0
        actualSqSum, compSqSum = (n * (n + 1) * ((2 * n) + 1)) // 6, 0
        for i in range(0, len(grid)):
            for j in range(0, len(grid[0])):
                compSum += grid[i][j]
                compSqSum += (grid[i][j] ** 2)
        sumDiff = actualSum - compSum
        sqSumDiff = actualSqSum - compSqSum
        y = (sumDiff + (sqSumDiff // sumDiff)) / 2
        x = y - sumDiff
        return [x, y]


# Java
'''
class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length * grid[0].length;
        long actualSum = (n * (n + 1)) / 2;
        long compSum = 0;
        long actualSqSum = (n * (n + 1) * ((2 * n) + 1)) / 6;
        long compSqSum = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                compSum += (long) grid[i][j];
                compSqSum += (long) (grid[i][j] * grid[i][j]);
            }
        }
        int sumDiff = (int) (actualSum - compSum);
        int sqSumDiff = (int) (actualSqSum - compSqSum);
        int y = (int) (sumDiff + (sqSumDiff / sumDiff)) / 2;
        int x = (int) (y - sumDiff);
        return new int[] {x, y};
    }
}

/*

Let x be the duplicate number and y be the missing number

Sum of n numbers = n * (n + 1) / 2

By this formula,
compSum - x + y = actualSum
=> y - x = (actualSum - compSum) --> (1)

Sum of squares of n = n * (n + 1) * (2n + 1) / 6

By this formula,
compSqSum - x^2 + y^2 = actualSqSum
=> y^2 - x^2 = (actualSqSum - compSqSum) --> (2)

we know that,
(y^2 - x^2) = (y + x) * (y - x)

From eq 1 & 2,
(y + x) = (actualSqSum - compSqSum) / (actualSum - compSum) --> (3)

Using eq 1 & 3,
y = ((actualSum - compSum) + ((actualSqSum - compSqSum) / (actualSum - compSum))) / 2

x = y - (actualSum - compSum) --> (From eq 1)

*/
'''
