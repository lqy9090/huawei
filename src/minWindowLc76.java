import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class minWindowLc76 {
    Map<Character, Integer> need = new HashMap<Character, Integer>();
    Map<Character, Integer> window = new HashMap<Character, Integer>();

    public String minWindow(String s, String t) {
        int tLen = t.length();
        int sLen = s.length();
        if (tLen ==0 || sLen ==0) return "";

        //先把t中的字符放到need中并计数
        for (int i = 0; i < tLen; i++) {
            char c = t.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int minLen = Integer.MAX_VALUE, start = 0;
        int valid = 0;//已经匹配成功的字符种类数 (非字符个数)

        //当右指针去到字符串末尾前
        while (right < sLen) {
            char c = s.charAt(right);
            right++;//右指针向右滑

            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) { //字符匹配并且数量相等
                    valid++;
                }
            }
            while (valid == need.size()) {
                if (right - left < minLen) {
                    start = left;
                    minLen = right -left;
                }

                char c1 = s.charAt(left);
                left++;
                if (need.containsKey(c1)) {
                    if (window.get(c1).equals(need.get(c1))) valid--;
                    window.put(c1, window.getOrDefault(c1, window.getOrDefault(c1, 0) - 1));
                }
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start+minLen);
    }

}
