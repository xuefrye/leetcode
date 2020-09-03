package cn.xuefei.剑指offer;

/**
 * @author: xuefei
 * @date: 2020-09-01
 * @version: 1.0
 * @description: TODO
 */
public class JZ4重建二叉树 {
    public static void main(String[] args) {
        JZ4重建二叉树 solution = new JZ4重建二叉树();
        solution.reConstructBinaryTree(new int[]{1, 2, 4, 7, 3, 5, 6, 8},new int[]{4, 7, 2, 1, 5, 3, 8, 6});
    }

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        TreeNode treeNode = reConstructBinaryTree(0, pre.length - 1, 0, in.length - 1, pre, in);

        return treeNode;
    }

    public TreeNode reConstructBinaryTree(int preL, int preR, int inL, int inR, int[] pre, int[] in) {
        if(preL > preR || inL > inR) return null;

        TreeNode root = new TreeNode(pre[preL]);

        int rootIndexIn = 0;

        for (int i = inL; i <= inR; i++) {
            if (pre[preL] == in[i]) {
                rootIndexIn = i;
                break;
            }
        }

        int leftLen = rootIndexIn - inL;

        root.left = reConstructBinaryTree(preL + 1, preL + leftLen, inL, rootIndexIn - 1, pre, in);
        root.right = reConstructBinaryTree(preL + leftLen + 1, preR, rootIndexIn + 1, inR, pre, in);

        return root;
    }
}
