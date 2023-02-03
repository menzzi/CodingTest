#include <stdio.h>

int main(){
    int H;
    int M;
    scanf("%d %d",&H,&M);
    
    if(H>0){
    if(M>=45){
        M=M-45;
        H=H;
        printf("%d %d",H,M);
    }else if(M<45){
        M=M+60-45;
        H=H-1;
        printf("%d %d",H,M);
        }
    }else if(H==0){
    if(M>=45){
        M=M-45;
        H=H;
        printf("%d %d",H,M);
    }else if(M<45){
        M=M+60-45;
        H=23;
        printf("%d %d",H,M);
        }
    }
   
}