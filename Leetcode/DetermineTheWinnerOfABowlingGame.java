// url: https://leetcode.com/problems/determine-the-winner-of-a-bowling-game/

class Solution {

    public int calculateScore(int[] player) {
        int score = 0, mul = 0;
        for(int i: player) {
            if(mul > 0) {
                score += 2*i;
                mul--;
            } else score += i;
            if(i == 10) mul = 2;
        }
        return score;
    }

    public int isWinner(int[] player1, int[] player2) {
        int score1 = calculateScore(player1), score2 = calculateScore(player2);
        return score1 == score2? 0: score1 > score2? 1: 2;
    }
}
