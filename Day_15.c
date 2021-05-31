// url : https://www.hackerrank.com/challenges/apple-and-orange/problem

void countApplesAndOranges(int s, int t, int a, int b, int apples_count, int* apples, int oranges_count, int* oranges) {
    int a_val = 0, o_val = 0;
    for(int i = 0;i < apples_count;i++){
        if(apples[i] >= (s-a) && apples[i] <= (t-a))
            a_val += 1;
    }
    for(int i = 0;i < oranges_count;i++){
        if(oranges[i] >= (s-b) && oranges[i] <= (t-b))
            o_val += 1;
    }
    printf("%d\n%d",a_val,o_val);
}