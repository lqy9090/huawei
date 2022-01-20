import java.util.HashSet;
import java.util.Scanner;

public class charNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        char[] chars = s.toCharArray();
        HashSet<Character> set = new HashSet<>();
        for (char c : chars) {
            set.add(c);
        }
        System.out.println(set.size());
    }
}
