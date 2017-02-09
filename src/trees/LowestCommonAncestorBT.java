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
 *
 * In this we try to find the lowest common ancestor of the two nodes which are provided to us
 *
 */
public class LowestCommonAncestorBT {

    private static TreeNode lcaBT(TreeNode root, TreeNode n1, TreeNode n2) {
        if(root == null) {
            return null;
        }
        if(root == n1 || root == n2) {
            return root;
        }
        TreeNode left = lcaBT(root.leftChild, n1, n2);
        TreeNode right = lcaBT(root.rightChild, n1, n2);

        if(left == null && right == null) {
            return null;
        }
        if(left != null && right != null) {
            return root;
        }

        return left != null ? left: right;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(10);
        TreeNode n2 = new TreeNode(24);
        TreeNode n3 = new TreeNode(12);

        TreeNode n4 = new TreeNode(54);
        TreeNode n5 = new TreeNode(34);
        TreeNode n6 = new TreeNode(13);

        BinaryTree.insertBt(n1, n2, 1);
        BinaryTree.insertBt(n1, n3, 2);
        BinaryTree.insertBt(n3, n4, 1);
        BinaryTree.insertBt(n3, n5, 2);
        BinaryTree.insertBt(n2, n6, 2);

        TreeNode ret = lcaBT(n1, n4, n5);
        System.out.print(ret.data);
    }

}
