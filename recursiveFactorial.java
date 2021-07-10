// Java Program For Performing Factorial Function Using Resursion
import java.util.Scanner;
public class Day_23 {
    static int fact(int n) {
        if(n == 0 || n == 1)
            return 1;
        else
            return n * fact(n - 1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.print("Factorial = " + fact(n));
    }
}
