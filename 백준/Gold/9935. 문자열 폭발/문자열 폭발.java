import java.util.*;
import java.io.*;

class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String str = br.readLine();
        String explosion = br.readLine();
        int length = explosion.length();

        Stack<Character> st = new Stack<>();
        for(int i = 0; i < str.length(); i++) {
            st.push(str.charAt(i));

            if(st.size() >= length) {
                boolean flag = true;
                for(int j = 0; j < length; j++) {
                    if(st.get(st.size() - length + j) != explosion.charAt(j)) {
                        flag = false;
                        break;
                    }
                }

                if(flag) {
                    for(int j = 0; j < length; j++) {
                        st.pop();
                    }
                }
            }
        }


        if(st.isEmpty()) {
            System.out.println("FRULA");
        }else {
            StringBuilder sb = new StringBuilder();
            for(char ch : st) {
                sb.append(ch);
            }
            System.out.println(sb);
        }
    }
}