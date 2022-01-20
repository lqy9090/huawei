import java.util.HashMap;
import java.util.Scanner;

public class hj23 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            char[] chars = s.toCharArray();
            HashMap<Character, Integer> map = new HashMap<>();
            int min = Integer.MAX_VALUE;
            int minKey = 0;
            for (char ch : chars) {
                int num = map.getOrDefault(ch, 0)+1;
                if (num < min){
                    min = num;
                    minKey = ch;
                }
                map.put(ch, num);
            }
            for (char ch : chars) {
                if (map.get(ch) != min) {
                    System.out.print(ch);
                }
            }
        }
    }
}
