package cn.xuefei.leetcode;

/**
 * Author: xuefrye
 * Date: 2020/5/30 0:06
 * Version: 1.0
 * File: _700_二叉搜索树中的搜索
 * Description:
 */
public class _700_二叉搜索树中的搜索 {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null) return null;

        if(root.val == val){
            return root;
        }else if(root.val < val){
            return searchBST(root.right,val);
        }else{
            return searchBST(root.left,val);
        }
    }

    public TreeNode searchBST2(TreeNode root, int val) {
        while(root != null && root.val != val){
            root = root.val > val ? root.left : root.right;
        }

        return root;
    }
}
