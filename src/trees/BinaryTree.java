package trees;

/**
 * Created by srinivas on 2/9/17.
 *
 *        10
 *     /     \
 *    24     12
 *     \    /  \
 *     13  54  34
 *
 * Is the created binary tree
 *
 */
public class BinaryTree {

    public static void insertBt(TreeNode parent, TreeNode child, Integer orientation) {
        if(orientation == 1) {
            parent.setLeftChild(child);
        } else if(orientation == 2) {
            parent.setRightChild(child);
        }
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(10);
        TreeNode n2 = new TreeNode(24);
        TreeNode n3 = new TreeNode(12);

        TreeNode n4 = new TreeNode(54);
        TreeNode n5 = new TreeNode(34);
        TreeNode n6 = new TreeNode(13);


        insertBt(n1, n2, 1);
        insertBt(n1, n3, 2);
        insertBt(n3, n4, 1);
        insertBt(n3, n5, 2);
        insertBt(n2, n6, 2);

        BSTDemo.preOrderTraversal(n1);

    }
}
