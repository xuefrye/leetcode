package cn.xuefei.leetcode;

/**
 * Author: xuefrye
 * Date: 2020/5/31 11:55
 * Version: 1.0
 * File: _110_平衡二叉树
 * Description:
 */
public class _110_平衡二叉树 {
    public boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
    }

    public int getHeight(TreeNode root) {
        if (root == null) return 0;

        int leftHeight = getHeight(root.left);
        if(leftHeight == -1) return -1;

        int rightHeight = getHeight(root.right);
        if(rightHeight == -1) return -1;

        return Math.abs(rightHeight - leftHeight) < 2 ? Math.max(rightHeight, leftHeight) + 1 : -1;
    }
}
