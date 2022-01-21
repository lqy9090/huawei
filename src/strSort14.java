import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class strSort14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k =1;
        List<String> words = new ArrayList<>();
        while (scanner.hasNext()) {
            String word = scanner.next();
            words.add(word);
            if (k == n) {
                System.out.println(words.toString());
                quickSort(words, 0, words.size() - 1);
                for (String wordItme : words) {
                    System.out.println(wordItme);
                }
            }
            k++;
        }
        scanner.close();
    }

    public static void quickSort(List<String> words, int left, int right) {
        if (left > right) return;
        int i = left;
        int j = right;
        String base = words.get(left);
        while (i != j) {
            while (words.get(j).compareTo(base) >= 0 && i < j) {
                j--;
            }

            while (words.get(i).compareTo(base) <= 0 && i < j) {
                i++;
            }
            if (i < j) {
                String temp = words.get(i);
                words.set(i, words.get(j));
                words.set(j, temp);
            }
        }

        words.set(left, words.get(i));
        words.set(i, base);
        quickSort(words, left, i - 1);
        quickSort(words, i + 1, right);
    }
}
