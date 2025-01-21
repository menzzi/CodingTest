import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            String input = br.readLine();
            if(input == null) break;
            String[] str = input.split(" ");
            String s = str[0];
            String t = str[1];

            if(s.length() > t.length()) break;

            int idx = 0;
            boolean isCollect = false;
            for(int i = 0; i < t.length(); i++) {
                isCollect = false;
                if(s.charAt(idx) == t.charAt(i)) {
                    idx++;
                    isCollect = true;
                }
                if(idx == s.length())break;
            }

            if(isCollect) {
                sb.append("Yes").append("\n");
            } else {
                sb.append("No").append("\n");
            }

        }
        System.out.println(sb);
    }
}