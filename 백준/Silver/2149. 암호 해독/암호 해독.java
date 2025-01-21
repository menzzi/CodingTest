import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String key = scanner.nextLine();
        String cipher = scanner.nextLine();

        int size = cipher.length() / key.length();

        String[] keyArray = key.split("");
        Arrays.sort(keyArray);

        List<Map.Entry<String, String>> list = new ArrayList<>();

        for(int i = 0; i < key.length(); i++) {
            int idx = i * size;
            list.add(Map.entry(keyArray[i], cipher.substring(idx, idx + size)));
        }

        boolean[] visited = new boolean[key.length()];
        char[][] answer = new char[size][key.length()];

        int index = 0;

        while(index < key.length()) {
            boolean isFound = false;
            for(int i = 0; i < list.size(); i++) {
                if(!visited[i] && list.get(i).getKey().equals(String.valueOf(key.charAt(index)))) {
                    String value = list.get(i).getValue();
                    for(int j = 0; j < size; j++) {
                        answer[j][index] = value.charAt(j);
                    }
                    visited[i] = true;
                    isFound = true;
                    break;
                }
            }
            if(isFound) index++;
        }

        StringBuilder result = new StringBuilder();
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < key.length(); j++) {
                result.append(answer[i][j]);
            }
        }
        System.out.println(result);
    }
}