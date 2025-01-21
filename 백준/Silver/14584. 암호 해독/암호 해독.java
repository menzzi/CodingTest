import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String cipher = scanner.nextLine();
        int number = scanner.nextInt();
        scanner.nextLine();

        String[] dic = new String[number];

        for(int i = 0; i < number; i++) {
            dic[i] = scanner.nextLine();
        }

        while(true) {
            for(int i = 0; i < number; i++) {
                if(cipher.contains(dic[i])) {
                    System.out.println(cipher);
                    return;
                }
            }
            cipher = convertString(cipher);
        }
    }

    private static String convertString(String str) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length(); i++) {
            char ch = (char)('a' + (str.charAt(i) - 'a' + 1) % 26);
            sb.append(ch);
        }
        return sb.toString();
    }

}