package cn.xuefei.leetcode;

/**
 * Author: xuefrye
 * Date: 2020/5/30 2:11
 * Version: 1.0
 * File: _98_验证二叉搜索树
 * Description:
 */
public class _98_验证二叉搜索树 {
    public boolean isValidBST(TreeNode root) {
        if (root == null || (root.right == null && root.left == null)) return true;

        boolean flag = true;
        if (root.left != null) {
            flag &= rightMost(root.left) < root.val;
        }

        if (root.right != null) {
            flag &= leftMost(root.right) > root.val;
        }

        return isValidBST(root.left) && isValidBST(root.right) && flag;
    }

    public int leftMost(TreeNode node){
        while(node.left != null){
            node = node.left;
        }

        return node.val;
    }

    public int rightMost(TreeNode node){
        while(node.right != null){
            node = node.right;
        }

        return node.val;
    }
}
