/* The program must accept an integer matrix of size R*C and an integer K as the input. The program must rotate the four 
quadrants within the given matrix K times in the clockwise direction. Then the program must print the revised matix as
the output.
NOTE: The values of R and C are always even.

Example Input/ Output:
4 4
10 20 11 22
30 40 33 44
55 66 50 60
77 88 70 80
2

Output:
50 60 55 66
70 80 77 88
11 22 10 20
33 44 30 40
*/

import java.util.*;
public class rotateFourQuadrants {

    static void print(int[][] m) {
        int r = m.length, c = m[0].length;
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++)
                System.out.print(m[i][j] + " ");
            System.out.println();
        }
    }

    static void shift(int[][] m, int k) {
        if(k == 0)
            print(m);
        else {
            int r = m.length, c = m[0].length;
            int[][] temp = new int[r][c];
            // For 1st Quad:
            for(int i = 0; i < r/2; i++)
                for(int j = c/2; j < c; j++)
                    temp[i + (r/2)][j] = m[i][j];
            // For 2nd Quad:
            for(int i = 0; i < r/2; i++)
                for(int j = 0; j < c/2; j++)
                    temp[i][j + (c/2)] = m[i][j];
            // For 3rd Quad:
            for(int i = r/2; i < r; i++)
                for(int j = 0; j < c/2; j++)
                    temp[i - (r/2)][j] = m[i][j];
            // For 4th Quad:
            for(int i = r/2; i < r; i++)
                for(int j = c/2; j < c; j++)
                    temp[i][j - (c/2)] = m[i][j];
            shift(temp, k-1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        int[][] m = new int[r][c];
        for(int i = 0; i < r; i++)
            for(int j = 0; j < c; j++)
                m[i][j] = sc.nextInt();
        int k = sc.nextInt();
        k = k % 4;
        if(k == 0)
            print(m);
        else 
            shift(m, k);
    }
}