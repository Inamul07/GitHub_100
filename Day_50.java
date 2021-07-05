import java.util.*;
public class Day_50 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char ch = str.charAt(0);
        int temp = 0;
        if(ch >= 97)
            ch -= 32;
        System.out.print(ch);
        for(int i = 1; i < str.length(); i++) {
            ch = str.charAt(i);
            if(temp++ == 1) {
                ch -= 32;
                System.out.print(ch);
                continue;
            }
            if(Character.isWhitespace(ch)) {
                System.out.print(" ");
                temp = 1;
                continue;
            } else
                System.out.print(ch);
            temp = 0;
        }
        sc.close();
    }
}