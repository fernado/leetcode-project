package pr.iceworld.fernando.leetcode.simple;

/**
 * 回文串–就是以中心为界，向两侧延伸，字符对称。因此，本题参数涉及到的即为左、右下标，
 * 所以dp函数设置为二维数组dp[i][j],其中i代表左侧下标，j代表右侧下标，
 * dp[i][j]代表的述值就是从i到j变为回文字符串需要的最小步数。
 * 转移函数分为i和j所代表的字符相等/不相等，两种情况。
 * 相等：如果相等，那么很明显，dp[i][j] = dp[i+1][j-1];
 * 不相等：对于不相等的情况，可以选择在右侧插入i对应的字符，或在左侧插入j对应的字符。
 * 插入i：dp[i][j] = dp[i+1][j]+1;
 * 插入j：dp[i][j] = dp[i][j-1]+1;
 * 故—dp[i][j] = Math.min(dp[i+1][j], dp[i][j-1])+1;
 */
class Huiwen {
    public static void main(String[] args) {
        Huiwen huiwen = new Huiwen();
        String s = "pr/iceworld/fernando/leetcode";
        System.out.println(huiwen.minInsertions(s));
    }

    public int minInsertions(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for (int i = s.length() - 2; i >= 0; i--) {
            for (int j = i + 1; j < s.length(); j++) {
                if (i == j) {
                    dp[i][j] = 0;
                }
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i][j - 1]) + 1;
                }
            }
        }

        return dp[0][s.length() - 1];
    }

}