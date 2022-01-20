import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class sort101 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = 0;
        int n = 0;
        List<Integer> list = new ArrayList<>();
        while (scanner.hasNext()){
            int number = scanner.nextInt();
            if (k == 0) {
                n = number;
                k++;
            }else if (k != -1) {
                list.add(number);
                k++;

                if (k == n+1) k = -1;
            }else {
                if (number == 0) quickSortAsc(list,0,n-1);
                else quickSortDesc(list, 0, n-1);
                System.out.println(list.toString());
            }
        }
        scanner.close();
    }

    public static void quickSortAsc(List<Integer> num, int left, int right) {
        if (left > right) return;
        int i = left;
        int j = right;
        int base = num.get(i);
        while (i != j) {
            while (num.get(j) >= base && i < j) {
                j--;
            }
            while (num.get(i) <= base && i < j) {
                i++;
            }
            if (i < j) {
                Integer temp = num.get(i);
                num.set(i, num.get(j));
                num.set(j, temp);
            }
        }
//        System.out.print("i: "+i+"j: "+j);
//        System.out.print(" before: "+num);
        num.set(left, num.get(i));
        num.set(i, base);
//        System.out.println(" after: "+num);
        quickSortAsc(num, left, i - 1);
        quickSortAsc(num, i + 1, right);
    }

    public static void quickSortDesc(List<Integer> num, int left, int right) {
        if (left > right) return;
        int i = left;
        int j = right;
        int base = num.get(i);
        while (i != j) {
            while (num.get(j) <= base && i < j) {
                j--;
            }
            while (num.get(i) >= base && i < j) {
                i++;
            }
            if (i < j) {
                Integer temp = num.get(i);
                num.set(i, num.get(j));
                num.set(j, temp);
            }
        }
//        System.out.print("i: "+i+"j: "+j);
//        System.out.print(" before: "+num);
        num.set(left, num.get(i));
        num.set(i, base);
//        System.out.println(" after: "+num);
        quickSortDesc(num, left, i - 1);
        quickSortDesc(num, i + 1, right);
    }
}
