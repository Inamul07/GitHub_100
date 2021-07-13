/* Write a java program to perform toUpperCase() */
import java.util.*;
public class toUpperCase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch >= 97)
                ch -= 32;
            System.out.print(ch);
        }
        sc.close();
    }
}
