/* A C Program To Perform Matrix Multiplication Between Two Matrices */
#include<stdio.h>
void main() {
    int M1row,M2row,M1col,M2col;
    printf("Enter No. Of Rows & Cols For M1: ");
    scanf("%d %d",&M1row,&M1col);
    printf("Enter No. Of Rows & Cols For M2: ");
    scanf("%d %d",&M2row,&M2col);
    if(M1col != M2row)
        printf("Dimension Error");
    else{
        int M1[M1row][M1col], M2[M2row][M2col], M3[M1row][M2col];
        printf("Enter The Elements Of M1:\n");
        for(int i = 0; i < M1row; i++)
            for(int j = 0; j < M1col; j++)
                scanf("%d",&M1[i][j]);
        printf("Enter The Elements Of M2:\n");
        for(int i = 0; i < M2row; i++)
            for(int j = 0; j < M2col; j++)
                scanf("%d",&M2[i][j]);
        for(int i = 0; i < M1row; i++)
            for(int j = 0; j < M2col; j++)
                M3[i][j] = 0;
        for(int i = 0; i < M1row; i++)
            for(int j = 0;  j < M2col; j++)
                for(int k = 0; k < M1col; k++)
                    M3[i][j] += M1[i][k] * M2[k][j];
        printf("M1 * M2:\n");
        for(int i = 0; i < M1row; i++){
            for(int j = 0;  j < M2col; j++)
                printf("%d ",M3[i][j]);
            printf("\n");
        }
    }
}
