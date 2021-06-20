/* Java Program to perform selection sort */
import java.util.*;
public class Day_34 {
    static void sort(ArrayList<Integer> list) {
        int n = list.size();
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                if(list.get(j) < list.get(i)) {
                    int temp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, temp);
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<Integer>();
        int n = sc.nextInt();
        for(int i = 0; i < n; i++){
            int val = sc.nextInt();
            list.add(val);
        }
        sort(list);
        System.out.print(list);
        sc.close();
    }
}