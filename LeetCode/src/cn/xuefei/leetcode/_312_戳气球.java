package cn.xuefei.leetcode;

import java.util.Arrays;

/**
 * Author: xuefrye
 * Date: 2020/6/14 1:41
 * Version: 1.0
 * File: _312_戳气球
 * Description:
 */
public class _312_戳气球 {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] points = new int[n + 2];
        points[0] = points[n + 1] = 1;
        System.arraycopy(nums, 0, points, 1, n);

        // 戳破i,j之间所有的气球的最大值.
        int[][] dp = new int[nums.length + 2][nums.length + 2];

        for (int[] ints : dp) {
            Arrays.fill(ints, 0);
        }

        for (int len = 1; len <= dp.length; len++) {
            for (int start = 0; start + len - 1 <= dp.length - 1; start++) {
                int i = start;
                int j = start + len - 1;
                int max = 0;

                for (int k = i + 1; k <= j - 1; k++) {
                    // 要使第k个气球与i,j相邻要先戳破i,k之间,k,j之间的气球
                    max = Math.max(max, dp[i][k] + dp[k][j] + points[i] * points[k] * points[j]);
                }
                dp[i][j] = max;
            }
        }

        return dp[0][nums.length + 1];
    }

    public static void main(String[] args) {
//        lenPrint(new int[]{1,2,3,4,5});

        _312_戳气球 p = new _312_戳气球();
        System.out.println(p.maxCoins(new int[]{3, 1, 5, 8}));
    }


    // 按照长度顺序打印数组.
    public static void lenPrint(int[] arr) {
        for (int len = 1; len <= arr.length; len++) {
            for (int start = 0; start + len - 1 <= arr.length - 1; start++) {
                int i = start;
                int j = start + len - 1;

                printArr(arr, i, j);
            }
        }
    }

    // 打印一个数组
    private static void printArr(int[] arr, int i, int j) {
        for (int k = i; k <= j; k++) {
            System.out.print(arr[k] + " ");
        }
        System.out.println();
    }
}
