import java.util.Arrays;
import java.util.HashMap;

public class Solution {

    /**
     *
     * @param numbers int整型一维数组
     * @param target int整型
     * @return int整型一维数组
     */
    public int[] twoSum (int[] numbers, int target) {
        int index1 =0,index2 =0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            Integer num2 = target - numbers[i];
            if (map.containsKey(num2)) {
                index1 = i+1;
                index2 = map.get(num2)+1;
            }
            map.put(numbers[i], i);
        }

        return new int[]{Math.min(index1, index2), Math.max(index1, index2)};
    }

    public int jumpFloor(int target) {
        int a=0,b=1,sum=0;
        for (int i = 0; i < target; i++) {
            sum = a+b;
            a = b;
            b = sum;
        }
        return b;
    }

    public static void main(String[] args) {

        Solution solution = new Solution();
//        int[] numbers = {-3,4,3,90};
//        int[] ints = solution.twoSum(numbers, 0);
//        System.out.println(Arrays.toString(ints));
        int res = solution.jumpFloor(2);
        System.out.println(res);

    }
}
