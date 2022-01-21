import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class brotherWord27 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = 0, n = 0, tk = 0;
        String target = null;
        List<String> brotherWords = new ArrayList<>();
        while (scanner.hasNext()) {
            String str = scanner.next();
            if (k==0) {
                n = Integer.parseInt(str);
                k++;
            }else if (k == n+1){
                target = str;
                k++;
            }else if (k == n+2){
                //兄弟单词数组
                tk = Integer.parseInt(str);
                List<String> brotherWord = findBrotherWord(brotherWords, target);
                System.out.println("brotherWord: " + brotherWord);
                //字典排序
                quickSort(brotherWord, 0, brotherWord.size() - 1);

                System.out.println(brotherWord.size());
                String word = tk > brotherWord.size() ? null : brotherWord.get(tk - 1);
                if (word != null) System.out.println(word);
                brotherWords.clear();
                k = 0;
            }else {
                brotherWords.add(str);
                k++;
            }

        }
        scanner.close();
    }


    public static List<String> findBrotherWord(List<String> words, String target) {
        HashMap<Character, Integer> tarMap = new HashMap<>();
        for (int i = target.length() - 1; i >= 0; i--) {
            char tarKey = target.charAt(i);
            tarMap.put(tarKey, tarMap.getOrDefault(tarKey, 0) + 1);
        }
        ArrayList<String> brotherWords = new ArrayList<>();
        for (String word : words) {
            if (!word.equals(target) && word.length() == target.length()) {
//                System.out.println("word: "+word);
//                String regex = "[" + target + "]";
//                Pattern pattern = Pattern.compile(regex);
//                Matcher m = pattern.matcher(word);
                HashMap<Character, Integer> letterMap = new HashMap<>();
                for (int i = word.length() - 1; i >= 0; i--){
                    letterMap.put(word.charAt(i), letterMap.getOrDefault(word.charAt(i), 0) + 1);
                }
                Set<Character> letter = letterMap.keySet();
                boolean flag = true;
                for (Character item : letter) {
                    if (!letterMap.get(item).equals(tarMap.get(item))){
                        flag = false;
                    }
                }
                if (flag) brotherWords.add(word);
//                while (m.find()) {
//                    String key = m.group();
//                    Integer num =  map.getOrDefault(key, 0)+1;
//                    map.put(key, num);
//                }
//                if (set.size() == target.length()) brotherWords.add(word);
            }
        }

        return brotherWords;
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
