/* The Program must accept N integers and print the second largest value among N integers
Example Input/ Output:
3
100
2200
345

Output:
345
*/

import java.util.*;
public class secondLargest {
    
    static void sort(int[] arr) {
        int n = arr.length;
        for(int i = 0; i < n; i++) {
            int min = arr[i];
            for(int j = i + 1; j < n; j++) {
                if(arr[j] < arr[i]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        sort(arr);
        System.out.println(arr[n - 2]);
    }
