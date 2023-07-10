package GoogleFoobar;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class SolutionL32 {

    private static int[][] bfs(int r, int c, int[][] map) {
        Queue<int[]> q = new LinkedList<>();
        int[][] graph = new int[map.length][map[0].length];
        q.add(new int[] { r, c });
        graph[r][c] = 1;
        while (!q.isEmpty()) {
            int[] node = q.remove();
            int[][] coords = new int[][] { { -1, 0 }, { 0, -1 }, { 0, 1 }, { 1, 0 } };
            for (int[] coord : coords) {
                int nr = node[0] + coord[0], nc = node[1] + coord[1];
                if (nr < 0 || nr >= map.length || nc < 0 || nc >= map[0].length || graph[nr][nc] != 0)
                    continue;
                graph[nr][nc] = graph[node[0]][node[1]] + 1;
                if (map[nr][nc] == 0)
                    q.add(new int[] { nr, nc });
            }
        }
        return graph;
    }

    public static int solution(int[][] map) {
        int[][] startToEnd = bfs(0, 0, map), endToStart = bfs(map.length - 1, map[0].length - 1, map);
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < map.length; i++)
            System.out.println(Arrays.toString(startToEnd[i]) + " " + Arrays.toString(endToStart[i]));
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (startToEnd[i][j] != 0 && endToStart[i][j] != 0)
                    res = Math.min(res, startToEnd[i][j] + endToStart[i][j] - 1);
            }
        }
        return res;
    }
}

public class PrepareTheBunniesEscape {
    public static void main(String[] args) {
        System.out.println(
                SolutionL32.solution(new int[][] { { 0, 1, 1, 0 }, { 0, 0, 0, 1 }, { 1, 1, 0, 0 }, { 1, 1, 1, 0 } }));
        // System.out.println(SolutionL32.solution(new int[][]{{0, 0, 0, 0, 0, 0}, {1,
        // 1, 1, 1, 1, 0}, {0, 0, 0, 0, 0, 0}, {0, 1, 1, 1, 1, 1}, {0, 1, 1, 1, 1, 1},
        // {0, 0, 0, 0, 0, 0}}));
    }
}

/*
 * You're awfully close to destroying the LAMBCHOP doomsday device and freeing
 * Commander Lambda's bunny prisoners, but once they're free of the prison
 * blocks, the bunnies are going to need to escape Lambda's space station via
 * the escape pods as quickly as possible. Unfortunately, the halls of the space
 * station are a maze of corridors and dead ends that will be a deathtrap for
 * the escaping bunnies. Fortunately, Commander Lambda has put you in charge of
 * a remodeling project that will give you the opportunity to make things a
 * little easier for the bunnies. Unfortunately(again), you can't just remove
 * all obstacles between the bunnies and the escape pods - at most you can
 * remove one wall per escape pod path, both to maintain structural integrity of
 * the station and to avoid arousing Commander Lambda's suspicions.
 * 
 * You have maps of parts of the space station, each starting at a prison exit
 * and ending at the door to an escape pod. The map is represented as a matrix
 * of 0sand 1s, where 0s are passable space and 1s are impassable walls. The
 * door out of the prison is at the top left (0,0) and the door into an escape
 * pod is at the bottom right (w-1,h-1).
 * 
 * Write a function answer(map) that generates the length of the shortest path
 * from the prison door to the escape pod, where you are allowed to remove one
 * wall as part of your remodeling plans. The path length is the total number of
 * nodes you pass through, counting both the entrance and exit nodes. The
 * starting and ending positions are always passable (0). The map will always be
 * solvable, though you may or may not need to remove a wall. The height and
 * width of the map can be from 2 to 20. Moves can only be made in cardinal
 * directions; no diagonal moves are allowed.
 */