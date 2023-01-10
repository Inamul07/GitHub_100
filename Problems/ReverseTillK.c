/* Given a string and an integer k, you need to reverse the first k characters for every 2k characters counting from the start of the string. 
If there are less than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, 
then reverse the first k characters and left the other as original.*/

#include<stdio.h>
#include<string.h>
void main(){
    char s[10000];
    int k;
    scanf("%s\n%d",s,&k);
    for(int i=k-1;i>=0;i--){
        printf("%c",s[i]);
    }
    for(int i=k;i<strlen(s);i++){
        printf("%c",s[i]);
    }
}
