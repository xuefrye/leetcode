package cn.xuefei.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Author: xuefrye
 * Date: 2020/6/14 22:24
 * Version: 1.0
 * File: _111_二叉树的最小深度
 * Description:
 */
public class _111_二叉树的最小深度 {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int deep = 1;
        while (!queue.isEmpty()) {
            // 当前层的数量,要全部poll掉
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (isLeaf(node)) return deep;
                else {
                    if (node.left != null) queue.add(node.left);
                    if (node.right != null) queue.add(node.right);
                }
            }
            deep++;
        }

        return deep;
    }

    boolean isLeaf(TreeNode node) {
        return node.right == null && node.left == null;
    }
}
