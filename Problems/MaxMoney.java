import java.util.*;

public class MaxMoney {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), amt = 0;
        int[] nums = new int[n+2];
        nums[0] = 1;
        nums[n+1] = 1;
        for(int i = 1; i < n+1; i++) nums[i] = sc.nextInt();
        for(int i = 1; i < n+1; i++) amt += (nums[i-1] * nums[i] * nums[i+1]);
        System.out.println(amt);
    }
}
