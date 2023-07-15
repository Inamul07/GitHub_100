import java.util.Scanner;

public class MinimumListChanges {
    public static void main(String[] args) {
        String[] s = new Scanner(System.in).nextLine().split(" ");
        int res1 = 0, res2 = 0;
        for(int i = 0; i < s.length; i++) {
            int num = Integer.parseInt(s[i]);
            if(i%2 == 0 && num%2 != 0) res1++;
            else if(i % 2 == 0) res2++;
            else if(num % 2 == 0) res1++;
            else res2++;
        }
        System.out.println(Math.min(res1, res2));
    }
}
