/* Write a program implementing add & get method of ArraList */
import java.util.*;
public class ArrayListGet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<Integer>();
        int n = sc.nextInt();
        for(int i = 0; i < n; i++){
            int val = sc.nextInt();
            list.add(val);
        }
        for(int i = 0; i < n; i++)
            if(list.get(i) % 2 == 1)
                System.out.print(list.get(i));
        sc.close();
    }
}
