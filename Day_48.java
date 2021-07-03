// url = https://www.hackerrank.com/challenges/java-stdin-stdout/problem

// Here i learnt that sometimes we have to clear the buffer so we have added a empty line in Line: 13

import java.util.Scanner;

public class Day_48 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int i = scan.nextInt();
        double d = scan.nextDouble();
        scan.nextLine();
        String s = scan.nextLine();
        scan.close();

        // Write your code here.

        System.out.println("String: " + s);
        System.out.println("Double: " + d);
        System.out.println("Int: " + i);
    }
}
