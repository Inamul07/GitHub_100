/* Write a Java Program to find maximum and minimum from an ArrayList */
import java.util.*;
public class Day_28 {
    public static void main() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter The No. Of Elements: ");
        int n = sc.nextInt();
        for(int i = 0; i < n; i++){
            int val = sc.nextInt();
            list.add(val);
        }
        int max = list.get(0), min = list.get(0);
        for(int i = 1; i < n; i++){
            if(list.get(i) > max)
                max = list.get(i);
            if(list.get(i) < min)
                min = list.get(i);
        }
        System.out.print("Max = " + max);
        System.out.print("Min = " + min);
        sc.close();
    }
}