import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        str = str.toUpperCase();
        Map<Character,Integer> map = new HashMap<>();

        for(int i = 0; i < str.length(); i++) {
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i),1) + 1);
        }

        int max = 0;
        char answer = '?';
        int count = 0;
        for(Character ch : map.keySet()) {
            int number = map.get(ch);
            if(number > max) {
                max = number;
                answer = ch;
                count = 1;
            } else if(number == max) {
                count++;
            }
        }
        if(count > 1) {
            System.out.println("?");
            return;
        }
        System.out.println(answer);
    }
}