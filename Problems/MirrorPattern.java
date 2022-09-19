/*      
             n = 5
       
             *                 *
             * *             * *
             * * *         * * *
             * * * *     * * * *
             * * * * * * * * * *
             * * * *     * * * *
             * * *         * * *
             * *             * *
             *                 *
 */

import java.util.*;

public class MirrorPattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p1 = 0, p2 = (n*2)-1, hRow = ((n*2)-1)/2;
        for(int i = 0; i < (n*2)-1; i++) {
            for(int j = 0; j < (n*2); j++) {
                if(j <= p1 || j >= p2) System.out.print("* ");
                else System.out.print("  ");
            }
            if(i < hRow) {
                p1++;
                p2--;
            } else {
                p1--;
                p2++;
            }
            System.out.println();
        }

    }
}
