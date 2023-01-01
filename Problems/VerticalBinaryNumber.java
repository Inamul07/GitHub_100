import java.util.*;

public class VerticalBinaryNumber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[][] mat = new char[Integer.toBinaryString(n).length()][n];
        int col=0, maxRow=0;
        for(int i=n;i>=1;i--) {
            int row = 0;
            String bin = Integer.toBinaryString(i);
            for(char ch:bin.toCharArray()) {
                mat[row++][col] = ch;
            }
            if(row > maxRow) maxRow = row;
            col++;
        }
        for(int i=0;i<maxRow;i++) {
            for(int j=0;j<col;j++) {
                System.out.print(mat[i][j]=='0' || mat[i][j]=='1' ? mat[i][j]+"" : "");
            }
            System.out.println();
        }
    }
}
