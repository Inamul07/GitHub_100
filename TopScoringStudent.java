/* Names of N students and the marks scored by them in Maths, Physics and Chemistry are passed as the input. The program
must print the name of the student who has scored the maximum marks in these three subjects. (Assume only one student will 
be the top scorer).

Example Input/ Output:
4
Sasikumar:50:60:70
Arun:60:40:90
Manoj:50:50:60
Rekha:60:35:45

Output:
Arun

*/

import java.util.*;
public class TopScoringStudent {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] details = new String[n];
        int[] marks = new int[n];
        for(int i = 0; i < n; i++)
            marks[i] = 0;
        String max = "";
        for(int i = 0; i < n; i++)
            details[i] = sc.nextLine();
        for(int i = 0; i < n; i++) {
            String[] temp = new String[4];
            int count = 0;
            temp = details[i].trim().split(":");
            for(int j = 1; j < 4; j++)
                marks[count] += Integer.parseInt(temp[j]);
            if(count > 0 && marks[count] > marks[count - 1])
                max = temp[0];
            else 
                max = temp[0];
            count++;
        }
        System.out.println(max);
    }
}
