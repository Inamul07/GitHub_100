package DynamicArray;

import java.util.*;

public class DynamicArray {
    
    int limit;
    int size = 0;
    int[] arr;

    public DynamicArray() {
        limit = 3;
        arr = new int[limit];
    }

    public DynamicArray(int limit) {
        this.limit = limit;
        arr = new int[limit];
    }

    public void add(int element) {
        if(limit == size) {
            limit *= 2;
            arr = Arrays.copyOf(arr, limit);
        }
        arr[size++] = element;
    }

    public void remove(int element) {
        int[] newArr = new int[limit];
        for(int i = 0, j = 0; i < size; i++) {
            if(arr[i] == element) 
                j++;
            newArr[i] = arr[j];
        }
        size--;
        arr = newArr;
    }

    public void removeAt(int index) {
        int value = arr[index];
        remove(value);
    }

    public int get(int index) {
        return arr[index];
    }

    public int size() {
        return size;
    }
    
}
