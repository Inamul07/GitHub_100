/* The program must accept N integers as the input. The program must print the number of swaps 
required when sorting the given N integers in descending order using selection sort as output.  */

#include <stdio.h>
int main() {
    int n,max,count=0;
    scanf("%d",&n);
    int arr[n];
    for(int i=0;i<n;i++)
        scanf("%d",&arr[i]);
    for(int i=0;i<n-1;i++){
        max=arr[i];
        for(int j=i+1;j<n;j++){
            if(arr[i]<arr[j]){
                count++;
                break;
            }
        }
    }
    printf("%d",count);
    return 0;
}