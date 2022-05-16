/* The program must accept two string values S1 and S2 as the input. The program must find the positions of the first
occurrence of all characters of S2 in S1. Then the program must print the characters in S1 from the minimum position
to the maximum position among the positions obtained.
NOTE: All characters of S2 always occur atleast once in S1.

Example Input/ Output:
corporate
oar

Output:
orpora

Explanation:
Here S1 = corporate, S2 = oar
The position of first occurrence of o in string S1 is 2.
The position of first occurrence of a in string S1 is 7.
The position of first occurrence of r in string S1 is 3.
The characters from the 2nd position(minimum position) to the 7th position(maximum position) in S1 are orpora.
*/

import java.util.*;
public class SubstringFirstOccurrence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        int[] pos = new int[s2.length()];
        for(int i = 0; i < s2.length(); i++) {
            char ch = s2.charAt(i);
            for(int j = 0; j < s1.length(); j++) {
                if(ch == s1.charAt(j)) {
                    pos[i] = j;
                    break;
                }
            }
        }
        int max = pos[0], min = pos[0];
        for(int i = 0; i < pos.length; i++) {
            if(pos[i] > max)
                max = pos[i];
            if(pos[i] < min)
                min = pos[i];
        }
        for(int i = min; i <= max; i++)
            System.out.print(s1.charAt(i));
    }
}
