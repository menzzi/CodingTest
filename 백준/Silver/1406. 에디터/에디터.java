import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Character> front = new Stack<>();
        Stack<Character> back = new Stack<>();

        String str = br.readLine();

        for(int i=0;i<str.length();i++){
            front.push(str.charAt(i));
        }

        int N = Integer.parseInt(br.readLine());

        for(int i=0;i<N;i++){
            String S = br.readLine();
            char c = S.charAt(0);

            switch (c){
                case 'L' :
                    if(!front.isEmpty()){
                        back.push(front.pop());
                    }
                    break;
                case 'D' :
                    if(!back.isEmpty()){
                        front.push(back.pop());
                    }
                    break;
                case 'B' :
                    if(!front.isEmpty()){
                        front.pop();
                    }
                    break;
                case 'P' :
                    char t = S.charAt(2);
                    front.push(t);
                    break;

                default:
                    break;
            }
        }

       while(!front.isEmpty()){
           back.push(front.pop());
       }

       StringBuilder sb = new StringBuilder();
       while(!back.isEmpty()){
           sb.append(back.pop());
       }
       System.out.print(sb);
    }


}
