package GoogleFoobar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution {

    private static List<List<Integer>> mirrorAtlas(int[] node, int[] dim, int distance) {
        List<List<Integer>> nodeMirror = new ArrayList<>();
        for (int i = 0; i < node.length; i++) {
            List<Integer> points = new ArrayList<>();
            for (int j = -(distance / dim[i]) - 1; j < (distance / dim[i] + 2); j++)
                points.add(getMirror(j, node[i], dim[i]));
            nodeMirror.add(points);
        }
        return nodeMirror;
    }

    private static int getMirror(int mirror, int coord, int dim) {
        int res = coord;
        int[] mirrorRot = new int[] { 2 * coord, 2 * (dim - coord) };
        if (mirror < 0)
            for (int i = mirror; i < 0; i++)
                res -= mirrorRot[(-i + 1) % 2];
        else
            for (int i = mirror; i > 0; i--)
                res += mirrorRot[i % 2];
        return res;
    }

    public static int solution(int[] dimensions, int[] your_position, int[] trainer_position, int distance) {
        List<List<List<Integer>>> mirror = new ArrayList<>();
        mirror.add(mirrorAtlas(your_position, dimensions, distance));
        mirror.add(mirrorAtlas(trainer_position, dimensions, distance));
        Set<Double> res = new HashSet<>();
        Map<Double, Double> angleDist = new HashMap<>();
        for (int i = 0; i < mirror.size(); i++) {
            for (int j : mirror.get(i).get(0)) {
                for (int k : mirror.get(i).get(1)) {
                    double beam = Math.atan2(your_position[1] - k, your_position[0] - j);
                    double l = Math.sqrt(Math.pow(your_position[0] - j, 2) + Math.pow(your_position[1] - k, 2));
                    int[] pos = new int[] { j, k };
                    if (!Arrays.equals(pos, your_position) && distance >= l) {
                        if (!angleDist.containsKey(beam) || angleDist.get(beam) > l) {
                            if (i == 0)
                                angleDist.put(beam, l);
                            else {
                                angleDist.put(beam, l);
                                res.add(beam);
                            }
                        }
                    }
                }
            }
        }
        return res.size();
    }
}

public class BringingAGunToATrainerFight {
    public static void main(String[] args) {
        System.out.println(Solution.solution(new int[] { 3, 2 }, new int[] { 1, 1 }, new int[] { 2, 1 }, 4));
        System.out.println(
                Solution.solution(new int[] { 300, 275 }, new int[] { 150, 150 }, new int[] { 185, 100 }, 500));
    }
}

/*
 * Uh-oh - you've been cornered by one of Commander Lambdas elite guards!
 * Fortunately, you grabbed a beam weapon from an abandoned guard post while you
 * were running through
 * 
 * the station, so you have a chance to fight your way out. But the beam weapon
 * is potentially dangerous to you as well as to the elite guard: its beams
 * reflect off walls, meaning you'll have to be very careful where you shoot to
 * avoid bouncing a shot toward yourself! Luckily, the beams can only travel a
 * certain maximum distance before becoming too weak to cause damage. You also
 * know that if a beam hits a corner, it will bounce back in exactly the same
 * direction. And of course, if the beam hits either you or the guard, it will
 * stop immediately (albeit painfully).
 * 
 * Write a function solution(dimensions, your_position, guard_position,
 * distance) that gives an array of 2 integers of the width and height of the
 * room, an array of 2 integers of your x and y coordinates in the room, an
 * array of 2 integers of the guard's x and y coordinates in the room, and
 * returns an integer of the number of distinct directions that you can fire to
 * hit the elite guard, given the maximum distance that the beam can travel.
 * 
 * The room has integer dimensions [1 < x_dim <= 1250, 1 < y_dim <= 1250]. You
 * and the elite guard are both positioned on the integer lattice at different
 * distinct positions (x, y) inside the room such that [0 < x < x_dim, 0 < y <
 * y_dim]. Finally, the maximum distance that the beam can travel before
 * becoming harmless will be given as an integer 1 < distance <= 10000.
 * 
 * For example, if you and the elite guard were positioned in a room with
 * dimensions [3, 2], your_position [1, 1], guard_position [2, 1], and a maximum
 * shot distance of 4, you could shoot in seven different directions to hit the
 * elite guard (given as vector bearings from your location): [1, 0], [1, 2],
 * [1, -2], [3, 2], [3, -2], [-3, 2], and [-3, -2]. As specific examples, the
 * shot at bearing [1, 0] is the straight line horizontal shot of distance 1,
 * the shot at bearing [-3, -2] bounces off the left wall and then the bottom
 * wall before hitting the elite guard with a total shot distance of sqrt(13),
 * and the shot at bearing [1, 2] bounces off just the top wall before hitting
 * the elite guard with a total shot distance of sqrt(5).
 */
