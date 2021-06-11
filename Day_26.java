/* Write a Java program to print the second smallest even number from an arrayList */
import java.util.*;
public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter The No. Of Elements: ");
        int n = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<Integer> newList = new ArrayList<Integer>();
        System.out.println("Enter The Elements Of The ArrayList:");
        for(int i = 0; i < n; i++){
            int val = sc.nextInt();
            list.add(val);
        }
        Collections.sort(list);
        for(int i = 0; i < n; i++)
            if(list.get(i) % 2 == 0)
                newList.add(list.get(i));
        sc.close();
        if(newList.get(1) % 2 == 1)
            System.out.print("There are Not Enough Even Numbers");
        else
            System.out.print("The Second Smallest Even Number is " + newList.get(1));
    }
}