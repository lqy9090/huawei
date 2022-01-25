import java.util.ArrayList;
import java.util.Arrays;

public class otherLc204 {
    public int countPrimesV1(int n) { //超出时间范围
        int ans = 0;
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 2; i < n; i++) {
            boolean check = check(i);
            if (check) {
                res.add(i);
                ans += 1;
            }
        }
        System.out.println(res);
        return ans;
    }

    public static boolean check(int n) {
        int prime = 2;
        while (prime <=  Math.sqrt(n)) {
            if (n % prime == 0) {
                return false;
            }else {
                prime++;
            }
        }
        return true;
    }

    public int countPrimes(int n) {
        int[] isPrime = new int[n];
        Arrays.fill(isPrime, 1);
        int ans = 0;
        for (int i = 2; i < n; ++i) {//2一定是质数
            if (isPrime[i] == 1) { //当x是质数的时候，那么大于x的2x、3x...一定不是质数
                ans += 1;
                if ((long) i * i < n) { //乘法口诀
                    for (int j = i * i; j < n; j += i) { //+i 实现倍数
                        isPrime[j] = 0;
                    }
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        otherLc204 solution = new otherLc204();
        int i = solution.countPrimes(10);
        System.out.println(i);
    }
}
