
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (i == 0) {
                    dp[i][j] = matrix[i][j];
                }
                else {
                    int up = matrix[i][j] + dp[i-1][j];

                    int left = Integer.MAX_VALUE;
                    if (j > 0) {
                        left = matrix[i][j] + dp[i-1][j-1];
                    }

                    int right = Integer.MAX_VALUE;
                    if (j < n-1) {
                        right = matrix[i][j] + dp[i-1][j+1];
                    }

                    dp[i][j] = Math.min(up, Math.min(left, right));
                }
            }
        }

        int ans = Integer.MAX_VALUE;

        for (int j = 0; j < n; j++) {
            ans = Math.min(ans, dp[m-1][j]);
        }

        return ans;
    }
}
