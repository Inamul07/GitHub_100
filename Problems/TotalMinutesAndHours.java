import java.util.*;

public class TotalMinutesAndHours {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine()), h = 0, m = 0;
        for(int i = 0; i < n; i++) {
            String[] time = sc.next().split("\\:");
            h += Integer.parseInt(time[0]);
            m += Integer.parseInt(time[1]);
        }
        h += (m/60);
        m %= 60;
        System.out.println(h + " " + m);
    }
}
