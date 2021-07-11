/* Write a program to print the second smallest even number in a list */

#include <stdio.h>

void sort(int arr[], int n)
{
    int i, j;
    for (i = 0; i < n - 1; i++){
        for (j = 0; j < n - i - 1; j++){
            if (arr[j] > arr[j + 1]){
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
    }
}

void main()
{
    int n;
    scanf("%d", &n);
    int arr[n], count = 0;
    for (int i = 0; i < n; i++)
        scanf("%d", &arr[i]);
    for (int i = 0; i < n; i++){
        if (arr[i] % 2 == 0)
            arr[count++] = arr[i];
    }
    arr[count] = '\0';
    sort(arr, count);
    if(arr[1] % 2 != 0 || arr[1] == 0)
        printf("Your Data Inputs Does Not Contain Enough Even Numbers");
    else
        printf("Second Smallest Even Number is = %d",arr[1]);
}
