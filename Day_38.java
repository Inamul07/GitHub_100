
/* Write a Java Program to calculate No. of days between two dates */
import java.util.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;
public class Day_38 {

    static void Difference(String fromDate, String toDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            long d1 = sdf.parse(fromDate).getTime();
            long d2 = sdf.parse(toDate).getTime();

            System.out.print((d2 - d1) / (1000 * 60 * 60 * 24) + " Days");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter From Date (DD/MM/YYYY) : ");
        String fromDate = sc.nextLine();
        System.out.print("Enter To Date (DD/MM/YYYY) : ");
        String toDate = sc.nextLine();
        Difference(fromDate, toDate);
        sc.close();
    }
}