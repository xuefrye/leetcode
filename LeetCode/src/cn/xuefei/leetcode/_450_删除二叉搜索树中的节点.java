package cn.xuefei.leetcode;

/**
 * Author: xuefrye
 * Date: 2020/5/30 2:41
 * Version: 1.0
 * File: _450_删除二叉搜索树中的节点
 * Description:
 */
public class _450_删除二叉搜索树中的节点 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.right == null && root.left == null)
                root = null;
            else if (root.right != null) {
                TreeNode nextNode = nextNode(root);
                // 既然右子树不为null那么后继节点nextNode不可能为null
                root.val = nextNode.val;
                root.right = deleteNode(root.right, nextNode.val);
            } else {
                TreeNode preNode = preNode(root);
                root.val = preNode.val;
                root.left = deleteNode(root.left, preNode.val);
            }
        }
        return root;
    }

    private TreeNode preNode(TreeNode node) {
        node = node.left;

        if (node == null) return null;

        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    private TreeNode nextNode(TreeNode node) {
        node = node.right;

        if (node == null) return null;

        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}
