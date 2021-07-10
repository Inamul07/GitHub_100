#include <assert.h>
#include <ctype.h>
#include <limits.h>
#include <math.h>
#include <stdbool.h>
#include <stddef.h>
#include <stdint.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char* readline();
char* ltrim(char*);
char* rtrim(char*);
char** split_string(char*);

int parse_int(char*);

/**
 * Complete the 'miniMaxSum' function below.
 *
 * The function accepts INTEGER_ARRAY arr as parameter.
 */

void miniMaxSum(int arr_count, int* arr) {
    long int sum[5] = {0,0,0,0,0};
    for(int i = 0;i < arr_count;i++){
        for(int j = 0;j < arr_count;j++){
            if(i == j)
                continue;
            sum[i] += arr[j];
        }
    }
    long int min = sum[0],max = sum[0];
    for(int i = 1;i < arr_count;i++){
        if(sum[i] > max)
            max = sum[i];
        if(sum[i] < min)
            min = sum[i];
    }
    printf("%ld %ld",min,max);
}


