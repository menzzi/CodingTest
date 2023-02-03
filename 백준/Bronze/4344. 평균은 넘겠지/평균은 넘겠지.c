#include <stdio.h>

int main(){
    int c,n=0;
    scanf("%d",&c);
    for(int i=0;i<c;i++)
    {
      int score[1000],sum=0;
      double avg=0.00;
      scanf("%d",&n);
      for(int j=0;j<n;j++)
      {
          scanf("%d",&score[j]);
          sum+=score[j];
      } 
      avg=(double)sum/n;
      int count=0;
    
      for(int j=0;j<n;j++){
          if(avg<score[j])
                count++;
      }
      printf("%.3f%%\n",(double)count*100/n);
    }
    return 0;
}       