import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class pailieLcView08 {
    public String[] permutation(String S) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            map.put(S.charAt(i), map.getOrDefault(S.charAt(i),0)+1);
        }
        for (Character key : map.keySet()) {
            System.out.println("key: "+key+" value: "+map.get(key));
        }
        ArrayList<StringBuilder> resList = new ArrayList<>();
        dfs(map, 0, map.keySet().size(), resList, new StringBuilder());
        String[] res = new String[resList.size()];
        for (int i = 0; i < resList.size(); i++) {
            res[i] = String.valueOf(resList.get(i));
        }

        return res;
    }

    public void dfs(HashMap<Character, Integer> map,int k, int len, ArrayList<StringBuilder> resList, StringBuilder builder) {
        System.out.println("k: "+k);
        for (Character key : map.keySet()) {
            System.out.println("key: "+key+" value: "+map.get(key));
        }
        if (k == len) {
            resList.add(builder);
            return;
        }
        for (Character ch : map.keySet()) {
            if (map.get(ch)>0){
                builder.append(ch);
                map.put(ch, map.get(ch) - 1);
                dfs(map, k + 1, len, resList, builder);
            }
            k = 0;
        }
    }

    public static void main(String[] args) {
        pailieLcView08 solution = new pailieLcView08();
        String s = "qqe";
        String[] res = solution.permutation(s);
        for (String re : res) {
            System.out.println(re);
        }

    }
}
