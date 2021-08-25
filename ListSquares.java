/* Get input of an ArrayList and return update them as their squares */
import java.util.ArrayList;
import java.util.Scanner;
public class ListSquares {
    public static void main(String[] args) {
        ArrayList<Integer> List = new ArrayList<Integer>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < n; i++){
            int val = sc.nextInt();
            List.add(val);
        }
        for(int i = 0; i < List.size(); i++){
            List.set(i, List.get(i)*List.get(i));
        }
        System.out.print(List);
        sc.close();
    }
}
