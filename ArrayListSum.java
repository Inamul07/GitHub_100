/* Get n elements of a list and return the sum of the list */

import java.util.*;
public class ArrayListSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter No. Of Elements: ");
        int n = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<Integer>();
        System.out.print("Enter " + n + " Elements:\n");
        for(int i = 0; i < n; i++){
            int val = sc.nextInt();
            list.add(val);
        }
        int sum = 0;
        for(int i = 0; i < n; i++)
            sum += list.get(i);
        System.out.print("Sum = " + sum);
        sc.close();
    }
}
