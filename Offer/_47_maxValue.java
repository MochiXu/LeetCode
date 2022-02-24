package Offer;

/**
 * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
 * 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。
 * 给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 * <p>
 * <p>
 * 思路：动态规划
 * dp更新的时候需要根据上方，左侧以及左上侧的dp进行确定
 */
public class _47_maxValue {
    public int maxValue(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int res = -1;
        int[][] dp = new int[m + 2][n + 2];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]) + grid[i - 1][j - 1];
                if (dp[i][j] > res) res = dp[i][j];
            }
        }
        return res;
    }

    public static void main(String args[]) {
        _47_maxValue maxValue = new _47_maxValue();
        int[][] input = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        System.out.println(maxValue.maxValue(input));
    }
}
