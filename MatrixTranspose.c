#include <stdio.h>

int main() {
    int rows,cols;
    printf("Enter Rows & Cols Of Matrix:\n");
    scanf("%d %d",&rows,&cols);
    int M[rows][cols];
    printf("Enter Elements Of Matrix:\n");
    for(int i=0;i<rows;i++)
        for(int j=0;j<cols;j++)
            scanf("%d",&M[i][j]);
    printf("Transpose of Matrix:\n");
    for(int i=0;i<cols;i++){
        for(int j=0;j<rows;j++)
            printf("%d ",M[j][i]);
        printf("\n");    
    }    
    return 0;
}
