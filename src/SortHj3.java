import java.util.*;
import java.util.stream.Collectors;

public class SortHj3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k=0;
        int n=0;
        List<Integer> nums = new ArrayList<>();
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            if (k == 0){
                n = num;
            }else if (k > 0){
               nums.add(num);
            }

            if (k == n) {
                quickSort(nums, 0, n-1);
                System.out.println(nums.toString());
                Set<Integer> collect = new LinkedHashSet<>(nums);
                for (Integer element : collect) {
                    System.out.println(element);
                }
                k=0;
                nums.clear();
            }else {
                k++;
            }
        }


    }

    public static void quickSort(List<Integer> numbers,int left,int right) {

        if (left > right) return;
        int i = left, j = right;
        int base = numbers.get(left);
        while (i < j) {
            while (i<j && numbers.get(j) >= base) {
                j--;
            }
            while (i<j && numbers.get(i) <= base) {
                i++;
            }
            if (i < j) {
                int temp = numbers.get(i);
                numbers.set(i, numbers.get(j));
                numbers.set(j, temp);
            }
        }
        numbers.set(left, numbers.get(i));
        numbers.set(i, base);
        quickSort(numbers, left, i - 1);
        quickSort(numbers, i + 1, right);
    }
}
