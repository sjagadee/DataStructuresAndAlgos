package trees;

/**
 * Created by srinivas on 2/9/17.
 *
 * Balanced binary tree means for a node height of (left sub tree) - (right sub tree)  <= 1. i.e either 0 or 1
 *
 */
public class BalancedBinaryTree {

    private static Integer balancedHeight(TreeNode root) {
        if(root ==null) {
            return 0;
        }
        Integer left = balancedHeight(root.leftChild);
        Integer right = balancedHeight(root.rightChild);

        if(Math.abs(left.intValue() - right.intValue()) > 1) {
            return -1;
        }

        if(left == -1 || right == -1) {
            return -1;
        }
        return 1 + Math.max(left, right);
    }

    private static boolean isBalanced(TreeNode root) {
        if(balancedHeight(root) > -1) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        BSTDemo bst = new BSTDemo();
        TreeNode root = bst.insert(null, 25);
        bst.insert(root, 20);
        bst.insert(root, 35);
        bst.insert(root, 18);
        bst.insert(root, 22);
        bst.insert(root, 30);
        bst.insert(root, 40);

        boolean ret = isBalanced(root);

        if(ret) {
            System.out.print("The tree is Balanced");
        } else {
            System.out.print("The tree is Un - Balanced");
        }
    }
}
