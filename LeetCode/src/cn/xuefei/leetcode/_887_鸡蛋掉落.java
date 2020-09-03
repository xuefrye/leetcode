package cn.xuefei.leetcode;

/**
 * Author: xuefrye
 * Date: 2020/6/13 20:48
 * Version: 1.0
 * File: _887_鸡蛋掉落
 * Description:
 */
public class _887_鸡蛋掉落 {
    public int superEggDrop(int K, int N) {
        // k个蛋 n楼
        int[][] dp = new int[K + 1][N + 1];

        for (int i = 0; i < dp[0].length; i++) {
            dp[1][i] = i;
        }

        for (int i = 0; i < dp.length; i++) {
            dp[i][1] = 1;
        }

        for (int k = 2; k <= K; k++) {
            for (int n = 2; n <= N; n++) {

//                int minTimes = n + 1;
//                for (int x = 1; x <= n; x++) {
//                    minTimes = Math.min(minTimes, Math.max(dp[k - 1][x - 1], dp[k][n - x]) + 1);
//                }
//
//                dp[k][n] = minTimes;
//
                int left = 1;
                int right = n;

                while (left <= right) {
                    int mid = (left + right) / 2;
                    int breakCount = dp[k - 1][mid - 1]; //增函数
                    int noBreakCount = dp[k][n - mid]; //减函数

                    if (breakCount - noBreakCount > 0) {
                        right = mid - 1;
                    } else if (breakCount - noBreakCount < 0) {
                        left = mid + 1;
                    } else {
                        break;
                    }
                }


                dp[k][n] = Math.max(dp[k - 1][left - 1], dp[k][n - left]) + 1;
            }
        }

        return dp[K][N];
    }

    public static void main(String[] args) {
        _887_鸡蛋掉落 p = new _887_鸡蛋掉落();
        System.out.println(p.superEggDrop(8, 10000));
        System.out.println(p.superEggDrop(2, 6));
    }
}
