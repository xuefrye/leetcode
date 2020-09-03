package cn.xuefei.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Author: xuefrye
 * Date: 2020/5/30 22:18
 * Version: 1.0
 * File: _958_二叉树的完全性检验
 * Description:
 */
public class _958_二叉树的完全性检验 {
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) return false;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        boolean leafStatus = false;

        while(!queue.isEmpty()){
            TreeNode poll = queue.poll();

            if(leafStatus && (poll.left != null || poll.right != null)) return false;

            if(poll.left != null){
                queue.add(poll.left);
            }else if(poll.right != null){
                return false;
            }

            if(poll.right != null){
                queue.add(poll.right);
            }else {
                leafStatus = true;
            }
        }

        return true;
    }
}
