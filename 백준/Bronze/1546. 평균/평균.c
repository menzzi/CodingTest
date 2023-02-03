#include <stdio.h>

int main(){
    double arr[1000],max=0,result=0;
    int n;
    scanf("%d",&n);
    
    for(int i=0;i<n;i++){
            scanf("%lf",&arr[i]);
            if(arr[i]>max){
                max=arr[i];
            }
    }
    for(int i=0;i<n;i++){
        arr[i]=arr[i]/max*100.0;
        result+=arr[i];
    }

    printf("%.2lf",(result/(double)n));
    return 0;
}