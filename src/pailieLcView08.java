import java.util.*;

public class pailieLcView08 {
    LinkedList<String> list = new LinkedList<String>();
    public String[] permutation(String S) {
//        HashMap<Character, Integer> map = new HashMap<>();
//        for (int i = 0; i < S.length(); i++) {
//            map.put(S.charAt(i), map.getOrDefault(S.charAt(i),0)+1);
//        }
//        for (Character key : map.keySet()) {
//            System.out.println("key: "+key+" value: "+map.get(key));
//        }
//        ArrayList<StringBuilder> resList = new ArrayList<>();
//        dfs(map, 0, map.keySet().size(), resList, new StringBuilder());
//        String[] res = new String[resList.size()];
//        for (int i = 0; i < resList.size(); i++) {
//            res[i] = String.valueOf(resList.get(i));
//        }
//
//        return res;
        dfs(S.toCharArray(), 0);
        return list.toArray(new String[0]);
    }


    public void dfs(char[] c, int k) {
        if (k == c.length){
            list.add(new String(c));
            return;
        }

        HashSet<Character> set = new HashSet<>();
        for (int i = k; i<c.length; i++) {
            if (!set.contains(c[i])) {
                set.add(c[i]);
                swap(c, i, k);
                dfs(c,k+1);
                swap(c, i, k);
            }
        }
    }

    public void swap(char[] c, int i, int k) {
        char temp = c[i];
        c[i] = c[k];
        c[k] = temp;
    }

    public void dfsFei(HashMap<Character, Integer> map,int k, int len, ArrayList<StringBuilder> resList, StringBuilder builder) {
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
                dfsFei(map, k + 1, len, resList, builder);
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
