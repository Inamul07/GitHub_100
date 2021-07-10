import java.util.*;
public class Day_35 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), temp = 0;
        for(int i = 2; i < n; i++){
            if(n % i == 0){
                temp = 1;
                break;
            }
        }
        if(temp == 0)
            System.out.print("It is Prime");
        else
            System.out.print("It is not prime");
        sc.close();
    }
}
