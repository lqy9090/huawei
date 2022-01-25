import java.util.Scanner;

public class otherHj60 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int minDiff = Integer.MAX_VALUE;
            int minI = 0;
            for (int i = n; i >= n/2; i--) {
                int temp = n -i;
                if (check(i)&&check(temp)) {
//                System.out.println(i + " " + temp);
                    if (i - temp < minDiff){
                        minI = i;
                        minDiff = Math.min(minDiff, i - temp);
                    }
                }
            }
            System.out.println(n - minI);
            System.out.println(minI);
        }

    }

    public static boolean check(int n) {
        int prime = 2;
        while (prime < n) {
            if (n % prime == 0) {
                return false;
            }else {
                prime ++;
            }
        }

        return true;
    }
}
