public class dynamicLc5 {

    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;int begin = 0;
        boolean[][] dp = new boolean[len][len]; //dp[i][j]表示s[i..j]是否是回文串
        //初始化：所有长度为1的字串都是回文串
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        char[] charArray = s.toCharArray();
        //递推开始
        //先枚举字串长度
        for (int L = 2; L <= len; L++) {
            //枚举左边界，左边界的上限设置可以宽松一些
            for (int i = 0; i < len; i++) {
                //由L和i确定右边界
                int j = L+i-1;
                //如果右边界越界，退出循环，此时右边没有和左边想等的字符
                if (j >= len) {
                    break;
                }

                if (charArray[i] != charArray[i]) {
                    dp[i][j] = false;
                }else {
                    if (j-i<3){
                        //长度为2的字串是回文字串
                        dp[i][j] = true;
                    }else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                //只要dp[i][j] == true成立，就表示字串s[i..j]是回文，此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j-i+1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }
}
