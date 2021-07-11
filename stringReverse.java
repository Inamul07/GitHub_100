import java.util.*;
public class stringReverse {
    static String strrev(String str) {
        int len = str.length();
        String rev = "";
        for(int i = len-1; i >= 0; i--)
            rev += str.charAt(i);
        return rev;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a String: ");
        String str = sc.nextLine();
        String rev = strrev(str);
        System.out.print("Reverse of the String is "+rev);
        sc.close();
    }
}
