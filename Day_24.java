import java.util.Scanner;
public class Day_24 {
    static boolean isArmstrong(int n) {
        int temp = n, sum = 0;
        while(temp > 0) {
            int ud = temp % 10;
            sum += (ud * ud * ud);
            temp /= 10;
        }
        if(sum == n)
            return true;
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while(true) {
            if(isArmstrong(n)) {
                System.out.print(n);
                break;
            }
            n += 1;
        }
        sc.close();
    }
}