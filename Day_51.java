import java.util.*;
public class Day_51 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(((n % 4 == 0) && (n % 100 != 0)) || (n % 400 == 0))
            System.out.println("It is Leap Year");
        else
            System.out.println("Not a Leap Year");
        sc.close();
    }
}
