package cn.xuefei.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author: xuefrye
 * Date: 2020/6/14 17:50
 * Version: 1.0
 * File: _51_N皇后
 * Description:
 */
public class _51_N皇后 {
    //存放答案
    List<List<String>> ans = new ArrayList<>();
    //是否已经使用过
    boolean[] used;
    //存放一个全排列
    List<Integer> paiLie = new ArrayList<>();
    //当前棋盘的布局
    char[][] qiPan;

    public List<List<String>> solveNQueens(int n) {
        used = new boolean[n];
        // 填好一个棋盘全是'.'
        qiPan = new char[n][n];
        for (char[] chars : qiPan) {
            Arrays.fill(chars, '.');
        }
        dfs(n);
        return ans;
    }

    public void dfs(int n) {
        if (paiLie.size() == n) {
            //ans.add(qiPan);
            return;
        }

        for (int i = 0; i < n; i++) {
            int col = paiLie.size();
            int row = i;
            if (used[i] || !check(qiPan, row, col)) continue;

            qiPan[row][col] = 'Q';
            used[i] = true;
            paiLie.add(i);
            dfs(n);
            paiLie.remove(paiLie.size() - 1);
            used[i] = false;
            qiPan[row][col] = '.';
        }
    }

    private boolean check(char[][] qiPan, int row, int col) {
        //检查左上
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (qiPan[i][j] == 'Q') return false;
        }

        //检查右上
        for (int i = row + 1, j = col - 1; i < qiPan.length && j >= 0; i++, j--) {
            if (qiPan[i][j] == 'Q') return false;
        }

        return true;
    }

    public static void main(String[] args) {
        _51_N皇后 p = new _51_N皇后();
        p.solveNQueens(4);
    }
}
