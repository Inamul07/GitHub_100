/* The Program must accept a character matrix of size RxC and string P representing a path inside the matrix as the input. The string P contains the
alphabets T, R, L and B. The path P always starts from the top-left position of the matrix(i.e the first row and first column of the matrix). The 
program must print all the characters which are present in the path P as output.

The path movement are given below:
T - move one position towards TOP
R - move one position towarfds RIGHT
L - move one position towarfds LEFT
B - move one position towarfds BOTTOM
*/

import java.util.*;

public class StringFromPath {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter No. of Rows & Cols:");
        int r = sc.nextInt();
        int c = sc.nextInt();
        char[][] mat = new char[r][c];
        System.out.println("Enter Character Matrix:");
        for(int i = 0; i < r; i++)
            for(int j = 0; j < c; j++)
                mat[i][j] = sc.next().charAt(0);
        System.out.println("Enter the Path:");
        sc.nextLine();
        String path = sc.nextLine();
        int x = 0, y = 0;
        System.out.print(mat[x][y]);
        for(char ch: path.toCharArray()) {
            if(ch == 'T')
                x -= 1;
            else if(ch == 'R')
                y += 1;
            else if(ch == 'L')
                y -= 1;
            else if(ch == 'B')
                x += 1;
            System.out.print(mat[x][y]);
        }
        sc.close();
    }
}
