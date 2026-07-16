class Solution {
    boolean helper(int i, int j, String s, String p, int dp[][]) {
        //base cases
        if (i >= 0 && j >= 0 && dp[i][j] != -1) {
            return dp[i][j] == 1;
        }
        if (i < 0 && j < 0) {
            return true;
        }
        if (i >= 0 && j < 0) {
            return false;
        }
        if (i < 0 && j >= 0) {
            for (int k = 0; k <= j; k++) {
                if (p.charAt(k) != '*') {
                    return false;
                }
            }
            return true;
        }
        //explore all possiblities
        //if char matches or char in s2 is ?
        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
            dp[i][j] = helper(i - 1, j - 1, s, p, dp) ? 1 : 0;
        }
        //if s2 has *
        else if (p.charAt(j) == '*') {
            dp[i][j] = (helper(i, j - 1, s, p, dp) || helper(i - 1, j, s, p, dp)) ? 1 : 0;
        } else {
            dp[i][j] = 0;
        }
        return dp[i][j] == 1;
    }

    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        int dp[][] = new int[n][m];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        return helper(n - 1, m - 1, s, p, dp);
    }
}