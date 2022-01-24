import java.util.Arrays;

public class dynamicNc17 {
    public int getLongestPalindromeFei (String A) {
        //对于倒过来的字符串已经在本来字符中出现失败 如："‘acabacba’ccbacd’abcabaca‘"
        char[] str = A.toCharArray();
        StringBuilder reverse = new StringBuilder(A).reverse();
        char[] reverseStr= reverse.toString().toCharArray();
        int[][] lenArray = new int[A.length()][A.length()];
        int maxLen = 0;
        System.out.println("  "+Arrays.toString(reverseStr));
        for (int i = 0; i < A.length(); i++) {
            for (int j = 0; j<A.length(); j++){
                if (str[i]==reverseStr[j]){
                    lenArray[i][j] = (i==0||j==0)?1: lenArray[i - 1][j - 1] + 1;
                }else {
                    lenArray[i][j] = 0;
                }
                maxLen = Math.max(lenArray[i][j], maxLen);
            }
            System.out.println(str[i]+" "+Arrays.toString(lenArray[i]));
        }
        return maxLen;
    }

    public int getLongestPalindrome(String A) { //动态规划
        int n = A.length();
        boolean[][] dp = new boolean[n][n];
        int maxLen = 0;
        //字符串长度差：diff = j-i,即当前要比较的字符出啊长度
        for (int diff = 0; diff <= n + 1; diff++) {
            //起始下标
            for (int i = 0; i < n - diff; i++) {
                //终点下标
                int j = diff+i;
                if (A.charAt(i) == A.charAt(j)) {
                    if (diff <= 1) {
                        dp[i][j] = true;
                    }else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                    if (dp[i][j]){
                        maxLen = diff +1;
                    }
                }

            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        dynamicNc17 solution = new dynamicNc17();
//        String str = "acabacbaccbacdabcabaca";
//        String str = "abbba";
//        String str = "b";
        String str = "acbdcbbbdbdaaccbcacdacdccababcddabddaaaaaaabdbabcdddaacabacbacbbdabdacddbbadaacbbdcbccacacdabcabacacbbbdcccacdcdcdcbcbabdcdacdddbbabcaccddddddabdacaabccdcabcbcbabacaaaccaccaddabbdadcdacdcdbaadbcabdcdcaaacbcadccbbddbaddcaddcaadcbbcbbdcbdadcddabdddcdbddbbdabaaddcaadd";
        int len = solution.getLongestPalindrome(str);
        System.out.println(len);
    }
}
