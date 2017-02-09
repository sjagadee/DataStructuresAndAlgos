package trees;

/**
 * Created by srinivas on 2/8/17.
 *
 * Height of a binary tree/ binary search tree
 */
public class HeightOfBinaryTree {

    private static Integer heightOfBT(TreeNode root) {
        if(root == null) {
            return 0;
        }

        Integer left = heightOfBT(root.leftChild);
        Integer right = heightOfBT(root.rightChild);

        return 1 + Math.max(left, right);
    }

    public static void main(String[] args) {
        BSTDemo bst = new BSTDemo();

        TreeNode root = bst.insert(null, 25);
        bst.insert(root, 18);
        bst.insert(root, 10);
        bst.insert(root, 20);
        bst.insert(root, 35);
        bst.insert(root, 29);
        bst.insert(root, 6);
        bst.insert(root, 9);
        bst.insert(root, 32);

        Integer ret = heightOfBT(root);
        System.out.print("Height of the tree: " + ret);
    }

}
