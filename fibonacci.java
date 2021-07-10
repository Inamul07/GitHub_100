import java.util.Scanner;
public class fibonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter The No. Of Terms:");
        int n = sc.nextInt();
        int f_term = 0, s_term = 1;
        System.out.println(f_term + "\n" + s_term);
        for(int i = 2; i < n; i++) {
            int temp = s_term;
            s_term = f_term + s_term;
            f_term = temp;
            System.out.println(s_term);
        }
        sc.close();
    }
}
