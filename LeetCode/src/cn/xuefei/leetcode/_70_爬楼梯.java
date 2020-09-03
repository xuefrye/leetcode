package cn.xuefei.leetcode;

/**
 * Author: xuefrye
 * Date: 2020/6/10 11:15
 * Version: 1.0
 * File: _70_爬楼梯
 * Description:
 */
public class _70_爬楼梯 {
    Integer dp[];

    public int climbStairs(int n) {
//        if(n == 0) return 0;
//        if(n == 1) return 1;
//        if(n == 2) return 2;


        dp = new Integer[n+1];
//        dp[0] = 0;
//        dp[1] = 1;
//        dp[2] = 2;

        return climb(n);
    }

    public int climb(int n) {
        if(n <=2 ) return n;

        if(dp[n] != null)
            return dp[n];

        dp[n] = climb(n - 1) + climb(n - 2);
        return dp[n];
    }

    public static void main(String[] args) {
        _70_爬楼梯 problem = new _70_爬楼梯();

        int i = problem.climbStairs(1);
        System.out.println(i);
    }
}
