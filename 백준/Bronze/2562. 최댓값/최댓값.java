import java.util.*;

class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int[] arr = new int[9];
        
        for(int i=0;i<9;i++)
        {
            arr[i] = in.nextInt();
        }
        
        int Max = arr[0];
        int count = 1;
        
        for(int i=1;i<9;i++)
        {
            if(arr[i] > Max)
            {
                Max = arr[i];
                count = (i+1);
            }
        }
        System.out.println(Max);
        System.out.println(count);
        
    }
}