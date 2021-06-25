import java.util.*;
public class Day_40 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine(), rev = "";
        int i = str.length() - 1;
        while(i >= 0) 
            rev += str.charAt(i--);
        System.out.println("Reverse of the string is " + rev);
        if(str.equals(rev)) 
            System.out.println("It is a pallindrome");
        else
            System.out.println("It is not a pallindrome");
        sc.close();
    }
}