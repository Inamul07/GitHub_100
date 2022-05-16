import java.util.*;
public class MergeSort {
    static void merge(int[] arr, int l, int m, int r) {
        int[] temp = new int[r - l + 1];
        int p1 = l, p2 = m + 1, count = 0;
        while(p1 <= m && p2 <= r) {
            if(arr[p1] < arr[p2])
                temp[count++] = arr[p1++];
            else
                temp[count++] = arr[p2++];
        }
        while(p1 <= m) 
            temp[count++] = arr[p1++];
        while(p2 <= r) 
            temp[count++] = arr[p2++];
        for(int i = r; i >= l; i--) 
            arr[i] = temp[--count];
    }

    static void mergeSort(int[] arr, int l, int r) {
        if(l < r) {
            int m = l + (r - l) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m+1, r);
            merge(arr, l, m, r);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the total no. of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter the elements:\n");
        for(int i = 0; i < n; i++) 
            arr[i] = sc.nextInt();
        mergeSort(arr, 0, n-1);
        for(int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        sc.close();
    }
}
