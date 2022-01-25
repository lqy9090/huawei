import java.util.HashMap;

public class minWindowNc28 {

    public String minWindow (String S, String T) {
        //表示窗口左右位置的指针
        int left =0, right = 0;
        //start-最后结果字符串开始位置，minLen-最后字符串长度
        int start = 0, minLen = Integer.MAX_VALUE;
        HashMap<Character, Integer> need = new HashMap<>(); //T的所有字符以及他们的个数
        HashMap<Character, Integer> window = new HashMap<>(); //窗口的所有字符以及它们的个数，如果包含need的所有字符，并且对应个数都不小于各字符个数,则是可行的
        for (int i = 0; i < T.length(); i++) {
            char c = T.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int match = 0;

        while (right < S.length()) {
            char ch = S.charAt(right);
            if (need.containsKey(ch)) {
                window.put(ch, window.getOrDefault(ch, 0) + 1);
                if (window.get(ch).equals(need.get(ch))) match++;
            }
            right++;

            //当且仅当已有字符串已经包含了所有目标字符串的字符，且出现频次一定大于或等于指定频次
            while (match == need.size()) {
                //当窗口的长度比已有的最短值小时，更改最小值，并记录起始位置
                if (right - left < minLen) {
                    minLen = right - left;
                    start = left;
                }
                char ch2 = S.charAt(left);
                //如果左边即将要去掉的字符被目标字符串需要
                if (need.containsKey(ch2)) {
                    window.put(ch2, window.getOrDefault(ch2, 0) - 1);
                    if (window.get(ch2) < need.get(ch2)) match--;
                }
                left ++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : S.substring(start, start+minLen);
    }


    //滑动窗口模板
//    void window(string s, string t) {
//        unordered_map<char, int> window, target;
//        for (char c : t) { ++target[c]; }
//        int left = 0, right = 0;    // 初始化双指针
//    ...                         // 定义状态值
//        while (right < s.size()) {
//            // 增大窗口
//            char c = s[righ]
//                    ++right;
//        ...                     // 更新window
//            while (达到缩小窗口的条件) {
//            ...                 // 更新状态值
//                char c = s[left];
//                ++left;
//            ...                 // 更新window/状态值
//            }
//        }
//    }

    public static void main(String[] args) {
        minWindowNc28 solution = new minWindowNc28();
        String S = "XDOYEZODEYXNZ", T = "XYZ";
        String s = solution.minWindow(S, T);
        System.out.println(s);
    }
}
