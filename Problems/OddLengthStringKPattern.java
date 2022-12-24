import java.util.*;

public class OddLengthStringKPattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Stack<String> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            String val = "";
            if(i <= s.length()/2) {
                int lim = (s.length()/2)+1-i;
                for(int j = 0; j < lim; j++) {
                    if(j == 0) val += s.charAt(i);
                    else if(j == lim-1) val += s.charAt(s.length()-1-i);
                    else val += '*';
                }
                System.out.println(val);
                if(i != s.length()/2) stack.push(val);
            } else System.out.println(stack.pop());
        }
    }
}


/*
    PROGRAM

    P**M
    R*A
    OR
    G
    OR
    R*A
    P**M

*/
