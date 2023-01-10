/* Write a program to print prime numbers b/w two intervals */

import java.util.*;
public class prineBwIntervals {
    static boolean isprime(int n) {
        int temp = 0;
        for(int i = 2; i < n; i++) {
            if(n % 2 == 0){
                temp = 1;
                break;
            }
        }
        if(temp == 0)
            return true;
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), count = 0, val = 1;
        while(true) {
            if(isprime(val)) {
                System.out.print(val + " ");
                count++;
            }
            if(count == n)
                break;
            val++;
        }
        sc.close();
    }
}
