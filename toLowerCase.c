/*Implement function ToLowerCase() that has a string parameter str, and returns the same string in lowercase.*/

#include<stdio.h>
#include<string.h>

char toLowerCase(char c){
    if(c<97)
        c+=32;
    return c;
}

void main(){
    char s[100];
    scanf("%s",s);
    for(int i=0;i<strlen(s);i++)
        printf("%c",toLowerCase(s[i]));
}
