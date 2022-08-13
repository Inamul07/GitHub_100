/* 
 * The program must accept an integer matrix of size R*C as input.
 * The program must print YES if the given matrix can be arranged in such a way
 * that each column must not contain any duplicates. Else the program must print 
 * NO as output.
 * 
 * Input:
 * 3 3
 * 4 5 5 
 * 4 6 7
 * 7 5 7
 * 
 * Output:
 * YES
 * 
 * Explanation:
 * The given matrix can be rearranged as
 * 4 4 5
 * 5 5 6
 * 7 7 7
 * 
 */

import java.util.*;

public class UniqueColumns {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt(), c = sc.nextInt();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < r*c; i++) {
            int num = sc.nextInt();
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for(int i: map.keySet()) {
            if(map.get(i) > c) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}