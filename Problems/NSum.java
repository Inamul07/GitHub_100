/* Write a java program to calculate sum of n numbers [1 to n] */
import java.util.*;
public class NSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), sum = 0;
        for(int i = 1; i <= n; i++)
            sum += i;
        System.out.print("Sum Of " + n + " numbers = " + sum);
        sc.close();
    }
}
