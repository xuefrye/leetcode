package cn.xuefei.剑指offer;

/**
 * @author: xuefei
 * @date: 2020-09-01
 * @version: 1.0
 * @description: TODO
 */
public class JZ57二叉树的下一个结点 {

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if(pNode == null) return null;

        if (pNode.right != null) {
            return getLeftest(pNode.right);
        } else {
            TreeLinkNode parent = pNode.next;

            while(parent != null){
                if(isLeftChild(parent,pNode)){
                    return parent;
                }else{
                    parent = parent.next;
                    pNode = pNode.next;
                }
            }

            return null;
        }
    }

    public TreeLinkNode getLeftest(TreeLinkNode root) {
        while (root.left != null) {
            root = root.left;
        }

        return root;
    }

    public boolean isLeftChild(TreeLinkNode parent, TreeLinkNode child) {
        return parent.left == child;
    }
}
