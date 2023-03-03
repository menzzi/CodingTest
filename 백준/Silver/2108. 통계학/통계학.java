import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        
    	Scanner scan = new Scanner(System.in);
    	int N = scan.nextInt();
    	
    	int[] arr = new int[N];
    	
    	ArrayList<Integer> list = new ArrayList<>();
    	
    	int[] count = new int[8001];
    	
    	for(int i=0;i<N;i++) {
    		arr[i] = scan.nextInt();
    	}
    
    	
    	int sum = 0;
    	int a;
    	int c = 0;
    	int d = 0;
    	int max = 0;
    
    	
    	for(int i=0;i<N;i++) {
    		sum += arr[i];
    	}
    	a=(int)Math.round((double)sum/N);
    	
    	Arrays.sort(arr);
    	
    	
    	int b = arr[N/2];
    	
    	if(N!=1)d = arr[N-1]-arr[0];
    	

    	for(int i=0;i < N;i++) {
    		count[arr[i]+4000]++;
    	}
    	for(int i=0;i<count.length;i++) {
    		if(count[i]>max) max = count[i];
    	}
    	
    	for(int i=0;i<count.length;i++) {
    		if(count[i]==max)list.add(i);
    	}
    	if(list.size() >= 2) c = list.get(1);
    	else c = list.get(0);
    	
    	c-=4000;
    	
    	System.out.println(a);
    	System.out.println(b);
    	System.out.println(c);
    	System.out.println(d);
    	
    }
}