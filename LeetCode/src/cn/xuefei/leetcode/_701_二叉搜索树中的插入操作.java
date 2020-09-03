package cn.xuefei.leetcode;

/**
 * Author: xuefrye
 * Date: 2020/5/30 0:35
 * Version: 1.0
 * File: _701_二叉搜索树中的插入操作
 * Description:
 */
public class _701_二叉搜索树中的插入操作 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null){
            return new TreeNode(val);
        }

        TreeNode node = root;

        while (true) {
            if (val < node.val) {
                if(node.left == null){
                    node.left = new TreeNode(val);
                    return root;
                }else{
                    node = node.left;
                }
            } else {
                if(node.right == null){
                    node.right = new TreeNode(val);
                    return root;
                }else{
                    node = node.right;
                }
            }
        }
    }
}
