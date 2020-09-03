package cn.xuefei.leetcode;

/**
 * Author: xuefrye
 * Date: 2020/5/30 22:36
 * Version: 1.0
 * File: _226_翻转二叉树
 * Description:
 */
public class _226_翻转二叉树 {
    public TreeNode invertTree(TreeNode root) {
        reverse(root);
        return root;
    }

    public void reverse(TreeNode root){
        if(root == null) return;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        reverse(root.left);
        reverse(root.right);
    }
}

