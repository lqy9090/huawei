import java.util.*;

public class shensouHj41 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            HashSet<Integer> set = new HashSet<>();//存放所有可能的结果，不用担心重复问题
            set.add(0);//初始化为0
            int n = in.nextInt();//个数
            int[] w = new int[n];
            int[] nums = new int[n];
            for(int i=0;i<n;i++){
                w[i] = in.nextInt();//砝码的重量
            }
            for(int i=0;i<n;i++){
                nums[i] = in.nextInt();//砝码个数
            }
            for(int i=0;i<n;i++){//遍历砝码
                ArrayList<Integer> list = new ArrayList<>(set);//取当前所有的结果
                for(int j=1;j<=nums[i];j++){//遍历个数
                    for (Integer integer : list) {
                        set.add(integer + w[i] * j);
                    }
                }
                System.out.println(set);
            }
            System.out.println(set.size());
        }
    }
}
