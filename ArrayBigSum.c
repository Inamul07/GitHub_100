/* In this challenge, you are required to calculate and print the sum of the elements in an array, 
keeping in mind that some of those integers may be quite large. */

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
long parse_long(char*);

/*
 * Complete the 'aVeryBigSum' function below.
 *
 * The function is expected to return a LONG_INTEGER.
 * The function accepts LONG_INTEGER_ARRAY ar as parameter.
 */

long aVeryBigSum(int ar_count, long* ar) {
    long int sum = 0;
    for(int i=0;i<ar_count;i++){
        sum += ar[i];
    }
    return sum;
}

int main()
{
    FILE* fptr = fopen(getenv("OUTPUT_PATH"), "w");

    int ar_count = parse_int(ltrim(rtrim(readline())));

    char** ar_temp = split_string(rtrim(readline()));

    long* ar = malloc(ar_count * sizeof(long));

    for (int i = 0; i < ar_count; i++) {
        long ar_item = parse_long(*(ar_temp + i));

        *(ar + i) = ar_item;
    }

    long result = aVeryBigSum(ar_count, ar);

    fprintf(fptr, "%ld\n", result);

    fclose(fptr);

    return 0;
}

