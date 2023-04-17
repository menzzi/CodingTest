import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Character> input = new Stack<Character>();
        boolean flag = false;

        String str = br.readLine();

        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='>'){
                flag = false;
                System.out.print(str.charAt(i));
            }else if(str.charAt(i)=='<'){
                flag = true;
                while(!input.isEmpty()) {
                    System.out.print(input.pop());
                }
                System.out.print(str.charAt(i));
            }else if(str.charAt(i)==' '){
                while(!input.isEmpty()){
                    System.out.print(input.pop());
                }
                System.out.print(str.charAt(i));
            }else if(flag){
                System.out.print(str.charAt(i));
            }else if(!flag){
                input.push(str.charAt(i));
            }
        }

        while(!input.isEmpty()){
            System.out.print(input.pop());
        }

    }
}