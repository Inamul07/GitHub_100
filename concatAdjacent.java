/* An array of N integers is passed as the input. The program must print a pair of adjacent values if the concatenated value is 
divisible by another integer X. The value of X is also passed as the input to the program. If there is no such pair, the 
program must print -1 as the output.

Example Input/ Output:
6
2 4 8 6 5 11
4

Output:
2 4
4 8
6 8
5 6

Explanation:
Here X = 4.
2 and 4 forms 24 which is divisible by 4.
4 and 8 can form 48 or 84 and both are divisible by 4.
8 and 6 form 68 which is divisible by 4.
6 and 5 form 56 which is divisible by 4.
*/

import java.util.*;
public class concatAdjacent {

    static long value(long x, long y) {
        long temp = y, mul = 1;
        while(temp > 0) {
            mul *= 10;
            temp /= 10;
        }
        return x * mul + y;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] arr = new long[n];
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        int x = sc.nextInt();
        int temp = 0;
        for(int i = 0; i < n - 1; i++) {
            long val = value(arr[i], arr[i + 1]);
            if(val % x == 0) {
                temp = 1;
                System.out.println(arr[i] + " " + arr[i + 1]);
            } else {
                val = value(arr[i + 1], arr[i]);
                if(val % x == 0) {
                    temp = 1;
                    System.out.println(arr[i + 1] + " " + arr[i]);
                }
            }
        }
        if(temp == 0)
            System.out.println(-1);
    }
}
