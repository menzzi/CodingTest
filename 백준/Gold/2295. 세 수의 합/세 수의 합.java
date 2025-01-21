import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int[] numbers = new int[number];
        for(int i = 0; i < number; i++) {
            numbers[i] = scanner.nextInt();
        }

        Arrays.sort(numbers);

        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < number; i++) {
            for(int j = i; j < number; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }

        int max = -1;
        for(int i = number - 1; i > 0; i--) {
            for(int j = 0; j < number; j++) {
                int k = numbers[i] - numbers[j];
                if(set.contains(k)) {
                    max = Math.max(max, numbers[i]);
                }
            }
        }

        System.out.println(max);
    }
}