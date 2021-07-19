import java.util.*;

public class stackBrackets {

    static boolean isLeft(char bracket) {
        if(bracket == '(' || bracket == '[' || bracket == '{')
            return true;
        return false;
    }

    static char reverse(char bracket) {
        if(bracket == '(')
            return ')';
        else if(bracket == '[')
            return ']';
        return '}';
    }

    public static void main(String[] args) {
        Stack<Character> stack = new Stack<Character>();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        sc.close();
        for(char ch : str.toCharArray()) {
            if(isLeft(ch)) {
                stack.push(ch);
                continue;
            } 
            if(stack.isEmpty() || ch != reverse(stack.pop())) {
                System.out.println("Invalid");
                break;
            }
        }
        if(stack.isEmpty()) {
            System.out.println("Valid");
        } else {
            System.out.println("Invalid");
        }
    }
}
