// Skillrack DC 27-Jul-2022

import java.util.*;

class MatrixZigZagTraversal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine()), flag = 0, len = n-1;
        char[][] m = new char[n][n];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++) m[i][j] = sc.next().charAt(0);
        int lim = n/2;
        if(n%2 == 0) lim = (n/2) - 1;
        for(int i = 0; i <= lim; i++) {
            int j = 0;
            if(i%2 == 1) j = n-1;
            while(true) {
                if(m[i][j] == m[len-i][len-j]) {
                    System.out.print(m[i][j] + " ");
                    flag = 1;
                }
                if(i%2 == 0) j++;
                else j--;
                if(j == -1 || j == n) break;
            }
        }
        if(flag == 0) System.out.println(-1);
    }
}
