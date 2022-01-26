import java.util.*;

public class otherHj28 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] arr = new int[n];
            ArrayList<Integer> odds = new ArrayList<>(); //奇数
            ArrayList<Integer> evens = new ArrayList<>();//偶数
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
                if (arr[i] % 2 == 1) {
                    odds.add(arr[i]);
                }else {
                    evens.add(arr[i]);
                }
            }

            int M = odds.size(), N = evens.size();
            int[] P = new int[N];Arrays.fill(P, 0);
            boolean[] vis = new boolean[N];
            int count = 0;
            for (Integer odd : odds) {
                //标记右侧元素是否被访问
                Arrays.fill(vis, false);
                if (match(odd, P, evens, vis)) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    public static boolean match(int odds, int[] P, List<Integer> evens, boolean[] vis) {
        for (int i = 0; i < evens.size(); i++) {
            //该位置右侧数据没被访问过，并且能和odds成为素数伴侣
            if (isPrime(odds + evens.get(i)) && !vis[i]) {
                vis[i] = true;

                //如果i位置偶数还没有奇数伴侣， 则与左侧奇数组成伴侣
                // 如果已经有伴侣，并且这个奇数伴侣能找到新偶数伴侣，就把这个奇数让给其他人,当前奇数为新伴侣
                if (P[i] == 0 || match(P[i], P, evens, vis)) {
                    P[i] = odds;
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isPrime(int n) {
        int prime = 2;
        while (prime <= Math.sqrt(n)) {
            if (n % prime == 0) {
                return false;
            }else {
                prime++;
            }
        }
        return true;
    }
}
