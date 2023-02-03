#include <stdio.h>

int main(){
    int n;
    scanf("%d",&n);
    char test[80];
    int sum,score;
    for(int i=0;i<n;i++){
        scanf("%s",&test);
        sum=0;
        score=1;  
        for(int j=0;j<strlen(test);j++){
            if(test[j]=='O'){
              sum+=score;
              score++;
            }
            if(test[j]=='X')score=1;
        }
        printf("%d\n",sum);
    }
 return 0;   
}