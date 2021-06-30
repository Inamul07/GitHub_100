import java.util.*;
public class Day_45 {
    static void swap(int[] list, int i, int j) {
        int temp = list[j];
        list[j] = list[i];
        list[i] = temp;
    }

    static int partition(int[] list, int l, int r) {
        int pivot = list[r];
        int i = l - 1;
        for(int j = l; j < r; j++) {
            if(list[j] < pivot) {
                i++;
                swap(list, i, j);
            }
        }
        swap(list, i + 1, r);
        return (i+1);
    }

    static void quickSort(int[] list, int l, int r) {
        if(l < r) {
            int pi = partition(list, l, r);
            quickSort(list, l, pi - 1);
            quickSort(list, pi + 1, r);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the no. of elements: ");
        int n = sc.nextInt();
        int[] list = new int[n];
        System.out.println("Enter the elements:");
        for(int i = 0; i < n; i++)
            list[i] = sc.nextInt();
        quickSort(list, 0, n-1);
        for(int i = 0; i < n; i++)
            System.out.print(list[i] + " ");
        sc.close();
    }
}