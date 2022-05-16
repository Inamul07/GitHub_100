import java.util.*;

public class MaximumSubarrayOfSizeK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        int k = sc.nextInt();
        int start = 0, sum = 0, max = 0;
        for(int end = 0; end < arr.length; end++) {
            sum += arr[end];
            if(end >= k - 1) {
                max = Math.max(sum, max);
                sum -= arr[start];
                start++;
            }
        }
        System.out.println(max);
    }
}
