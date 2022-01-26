import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class mergeHJ8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = 0,k=0,key = 0;
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            if (k==0) {
                n = num;
            }else {
                if (k%2==0){
                    int sum = map.getOrDefault(key, 0)+ num;
//                    System.out.println("key: "+key+" sum: "+sum);
                    map.put(key, sum);
                }else {
                    key = num;
                }

            }
            if (k == n*2) {
                List<Integer> keys = new ArrayList<>(map.keySet());
                quickSort(keys, 0, keys.size() - 1);
                for (Integer keyT : keys) {
                    System.out.println(keyT + " " + map.get(keyT));
                }
            }
            k++;
        }
        scanner.close();
    }

    public static void quickSort(List<Integer> num, int left, int right) {
        if (left > right) return;
        int i = left;
        int j = right;
        int base = num.get(left);
        while (i < j) {
            while (num.get(j) >= base && i < j) {
                j--;
            }
            while (num.get(i) <= base && i < j) {
                i++;
            }
            if (i < j) {
                int temp = num.get(i);
                num.set(i, num.get(j));
                num.set(j, temp);
            }
        }

        num.set(left, num.get(i));
        num.set(i, base);
        quickSort(num, left, i - 1);
        quickSort(num, i + 1, right);
    }
}
