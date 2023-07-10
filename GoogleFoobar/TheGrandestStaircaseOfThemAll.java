package GoogleFoobar;

class SolutionL33 {
    public static int solution(int n) {
        int[][] dp = new int[n + 1][n + 1];
        dp[0][0] = 1;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= i)
                    dp[i][j] += dp[i - 1][j - i];
            }
        }
        return dp[n][n] - 1;
    }
}

public class TheGrandestStaircaseOfThemAll {
    public static void main(String[] args) {
        // System.out.println(SolutionL33.solution(3));
        System.out.println(SolutionL33.solution(200));
    }
}

/*
 * With the LAMBCHOP doomsday device finished, Commander Lambda is preparing to
 * debut on the galactic stage – but in order to make a grand entrance, Lambda
 * needs a grand staircase! As the Commander’s personal assistant, you’ve been
 * tasked with figuring out how to build the best staircase EVER.
 * 
 * Lambda has given you an overview of the types of bricks available, plus a
 * budget. You can buy different amounts of the different types of bricks (for
 * example, 3 little pink bricks, or 5 blue lace bricks). Commander Lambda wants
 * to know how many different types of staircases can be built with each amount
 * of bricks, so they can pick the one with the most options.
 * 
 * Each type of staircase should consist of 2 or more steps. No two steps are
 * allowed to be at the same height - each step must be lower than the previous
 * one. All steps must contain at least one brick. A step’s height is classified
 * as the total amount of bricks that make up that step. For example, when N =
 * 3, you have only 1 choice of how to build the staircase, with the first step
 * having a height of 2 and the second step having a height of 1: (# indicates a
 * brick)
 * 
 * #
 * ##
 * 21
 * When N = 4, you still only have 1 staircase choice:
 * 
 * #
 * #
 * ##
 * 31
 * But when N = 5, there are two ways you can build a staircase from the given
 * bricks. The two staircases can have heights (4, 1) or (3, 2), as shown below:
 * 
 * #
 * #
 * #
 * ##
 * 41
 * #
 * ##
 * ##
 * 32
 * Write a function called solution(n) that takes a positive integer n and
 * returns the number of different staircases that can be built from exactly n
 * bricks. n will always be at least 3 (so you can have a staircase at all), but
 * no more than 200, because Commander Lambda’s not made of money!
 */