/* The program must accept a string S as the imput. The string S contains multiple words seperated by a space, but
some groups of words are enclosed within double quotes. The program must split the string S into words without 
breaking the words within the double qupotes. Finally, the program must print the words in seperate line.

Example Input/ Output:
cat dog "lion tiger" mosquito bee ant "snake cobra crocodile" cow

Output:
cat
dog
lion tiger
mosquito 
bee 
ant
snake cobra crocodile
cow
*/

import java.util.*;
public class SplitStringDoubleQuotes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        boolean temp = false;
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '"') {
                temp = !temp;
                continue;
            }

            if(str.charAt(i) == ' ' && temp == false)
                System.out.println();
            else
                System.out.print(str.charAt(i));
        }
    }
}