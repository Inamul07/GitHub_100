#include<stdio.h>

void main() {

    int row, col;
    printf("Enter No. Of Rows & Cols:\n");
    scanf("%d %d",&row,&col);
    int M1[row][col], M2[row][col];
    printf("Enter The Elements Of M1:\n");
    for(int i = 0; i < row; i++)
        for(int j = 0; j < col; j++)
            scanf("%d",&M1[i][j]);
    printf("Enter The Elements Of M2:\n");
    for(int i = 0; i < row; i++)
        for(int j = 0; j < row; j++)
            scanf("%d",&M2[i][j]);
    printf("M1 + M2:\n");
    for(int i = 0; i < row; i++){
        for(int j = 0; j < col; j++)
            printf("%d ",M1[i][j] + M2[i][j]);
        printf("\n");
    }

}
