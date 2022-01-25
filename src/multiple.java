import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class multiple {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int minN = Math.min(m, n);
        int maxN = Math.max(m, n);
        List<Integer> minList = new ArrayList<Integer>();
        for (int i = 1; i <= minN; i++) {
            minList.add(maxN * i);
        }
//        System.out.println(minList);
        for (int i = 1; i <= maxN; i++) {
            int temp = minN * i;
            if (minList.contains(temp)){
                System.out.println(temp);
                break;
            }
        }

    }

}
