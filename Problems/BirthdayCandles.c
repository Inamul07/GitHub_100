/* You are in charge of the cake for a child's birthday. 
You have decided the cake will have one candle for each year of their total age. 
They will only be able to blow out the tallest of the candles. Count how many candles are tallest.

Example
candles = [4,4,1,3]
The maximum height candles are 4 units high. There are 2 of them, so return 2. */

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
 * Complete the 'birthdayCakeCandles' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts INTEGER_ARRAY candles as parameter.
 */

int birthdayCakeCandles(int candles_count, int* candles) {
    int max = candles[0], count = 0;
    for(int i = 1;i < candles_count;i++)
        if(candles[i] > max)
            max = candles[i];
    for(int i = 0;i < candles_count;i++)
        if(candles[i] == max)
            count += 1;
    return count;
}

int main()
{
    FILE* fptr = fopen(getenv("OUTPUT_PATH"), "w");

    int candles_count = parse_int(ltrim(rtrim(readline())));

    char** candles_temp = split_string(rtrim(readline()));

    int* candles = malloc(candles_count * sizeof(int));

    for (int i = 0; i < candles_count; i++) {
        int candles_item = parse_int(*(candles_temp + i));

        *(candles + i) = candles_item;
    }

    int result = birthdayCakeCandles(candles_count, candles);

    fprintf(fptr, "%d\n", result);

    fclose(fptr);

    return 0;
}
