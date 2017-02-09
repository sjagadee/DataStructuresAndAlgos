package trees;

/**
 * Created by srinivas on 2/8/17.
 *
 * check if the given binary tree is binary search tree
 * assuming that this tree does not contain any duplicate values
 */
public class CheckIfBTisBST {

    private static boolean isBST(TreeNode root, Integer min, Integer max) {
        if(root == null) {
            return true;
        }
        if(root.data < min || root.data > max) {
            return false;
        }
        return isBST(root.leftChild, min, root.data) && isBST(root.rightChild, root.data, max);
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

        boolean res = isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        if(res) {
            System.out.print("The given binary tree is binary search tree (BST)");
        } else {
            System.out.print("The given binary tree is not binary search tree (BST)");
        }
    }
}
