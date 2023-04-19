import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);

        while (true) {

            String str = scan.nextLine();
            if (str.charAt(0) == '.') break;

            System.out.println(stack(str));

        }
    }

    public static String stack(String str) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == '(' || str.charAt(i) == '[') {
                st.push(str.charAt(i));
            } else if (str.charAt(i) == ')') {
                if (st.isEmpty() || st.peek() == '[') {
                    return "no";
                } else if (st.peek() == '(') {
                    st.pop();
                }
            } else if (str.charAt(i) == ']') {
                if (st.isEmpty() || st.peek() == '(') {
                    return "no";
                } else if (st.peek() == '[') {
                    st.pop();
                }
            }
        }
        if (str.charAt(str.length() - 1) == '.') {
            if (st.isEmpty()) {
                return "yes";
            } else {
                return "no";
            }
        }
        return "no";
    }
}
