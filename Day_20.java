import java.util.Scanner;
import java.util.HashSet;
import java.util.ArrayList;
public class Day_20 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<Integer> newList = new ArrayList<Integer>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < n; i++){
            int val = sc.nextInt();
            list.add(val);
        }
        for(int i = 0; i < list.size(); i++){
            int val = list.get(i);
            int flag = 0;
            HashSet<Integer> digits = new HashSet<Integer>();
            while(val > 0) {
                int ud = val % 10;
                if(digits.contains(ud)){
                    flag = 1;
                    break;
                }
                else 
                    digits.add(ud);
                val /= 10;
            }
            if(flag == 0)
                newList.add(list.get(i));
        }
        System.out.print(newList);
        sc.close();
    }
}public class Day_20 {
    
}
