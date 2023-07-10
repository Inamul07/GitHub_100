package GoogleFoobar;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;

class Tuple {
    int row, col, steps;

    Tuple(int row, int col, int steps) {
        this.row = row;
        this.col = col;
        this.steps = steps;
    }

    @Override
    public String toString() {
        return "[" + row + ", " + col + ", " + steps + "]";
    }
}

class Solution {

    private static boolean isValid(int r, int c) {
        return r >= 0 && r < 8 && c >= 0 && c < 8;
    }

    private static int bfs(int r, int c, int dr, int dc) {
        Queue<Tuple> q = new LinkedList<>();
        int[][] coords = new int[][] { { 1, 2 }, { 2, 1 }, { -1, -2 }, { -2, -1 }, { -1, 2 }, { 1, -2 }, { 2, -1 },
                { -2, 1 } };
        q.add(new Tuple(r, c, 0));
        Set<String> visited = new HashSet<>();
        visited.add(r + "," + c);
        while (!q.isEmpty()) {
            Tuple node = q.remove();
            int row = node.row, col = node.col;
            if (row == dr && col == dc)
                return node.steps;
            for (int[] coord : coords) {
                int nr = row + coord[0], nc = col + coord[1];
                if (isValid(nr, nc) && !visited.contains(nr + "," + nc)) {
                    q.add(new Tuple(nr, nc, node.steps + 1));
                    System.out.println(q.toString());
                    visited.add(nr + "," + nc);
                }
            }
            System.out.println(q.toString());
        }
        return -1;
    }

    public static int solution(int src, int dest) {
        if (src == dest)
            return 0;
        return bfs(src / 8, src % 8, dest / 8, dest % 8);
    }
}

public class DontGetVolunteered {
    public static void main(String[] args) {
        System.out.println(Solution.solution(0, 1));
    }
}

/*
 * As a henchman on Commander Lambda's space station, you;re expected to be
 * resourceful, smart, and a quick
 * thinker. It's not easy building a doomsday device and ordering the bunnies
 * around at the same time,
 * after all! Inorder to make sure that everyone is sufficiently quick-witted,
 * Commander Lambda has installed
 * new flooring outside the henchman dormitories. It looks like a chessboard,
 * and every morning and evening
 * you have to solve a new movement puzzle in order to cross the floor. That
 * would be fine if you got to
 * be the rook or the queen, but instead, you have to be the knight. Worse, if
 * you take too much time
 * solving the puzzle, you get "volunteered" as a test subject for the LAMBCHOP
 * doomsday device!
 * 
 * To help yourself get to and from your bunk every day, write a function called
 * solution(src, dest) which
 * takes in two parameters: the source square, on which you start, and the
 * destination square, which is
 * where you need to land to solve the puzzle. The function should return an
 * integer representing the
 * smallest number of moves it will take for you to travel from the source
 * square to the destination
 * square using a chess knight's moves (that is, two squares in any diection
 * immediately followed by one
 * square perpendicular to that direction, or vice versa, in an "L" shape). Both
 * the source and
 * destination squares will be an integer from 0 and 63, inclusive, and are
 * numbered like the example
 * chessboard below:
 * 
 * -------------------------
 * | 0| 1| 2| 3| 4| 5| 6| 7|
 * -------------------------
 * | 8| 9|10|11|12|13|14|15|
 * -------------------------
 * |16|17|18|19|20|21|22|23|
 * -------------------------
 * |24|25|26|27|28|29|20|31|
 * -------------------------
 * |32|33|34|35|36|37|38|39|
 * -------------------------
 * |40|41|42|43|44|45|46|47|
 * -------------------------
 * |48|49|50|51|52|53|54|55|
 * -------------------------
 * |56|56|58|59|60|61|62|63|
 * -------------------------
 */