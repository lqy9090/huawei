import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class zuheLc77_2 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (k <= 0 || n < k) {
            return res;
        }

        Deque<Integer> path = new ArrayDeque<>();
        dfs(n, k, 1, path, res);

        return res;
    }

    private void dfs(int n, int k, int index,Deque<Integer> path, List<List<Integer>> res) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i <= n - (k - path.size()) + 1; i++) {
            path.addLast(i);
            dfs(n,k,i+1, path, res);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        int n = 4,k =2;
        zuheLc77_2 solution = new zuheLc77_2();
        List<List<Integer>> res = solution.combine(n, k);
        for (List<Integer> c : res) {
            System.out.println(c.toString());
        }
    }
}
