import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Integer> st = new Stack<>();

        int N = Integer.parseInt(br.readLine());
        int result = 0;

        for(int i=0;i<N;i++){
            int num = Integer.parseInt(br.readLine());
            if(num==0){
                st.pop();
            }else{
                st.push(num);
            }
        }
        while(!st.isEmpty()){
            result += st.pop();
        }

        System.out.println(result);
    }
}