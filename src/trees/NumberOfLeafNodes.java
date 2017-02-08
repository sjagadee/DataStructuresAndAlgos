package trees;

/**
 * Created by srinivas on 2/8/17.
 *
 * This class has the method to find the number of leaf nodes for BT/ BST
 *
 * Leaf node means that specific node does not have any children nodes (both right child and left child are null)
 */
public class NumberOfLeafNodes {

    private static Integer numOfLeafNodes(TreeNode root) {
        if(root == null) {
            return 0;
        }
        // this situation when both right child and left child are null that means it is a leaf node
        if (root.rightChild == null && root.leftChild == null) {
            return 1;
        }

        return numOfLeafNodes(root.leftChild) + numOfLeafNodes(root.rightChild);
    }

    public static void main(String[] args) {
        BSTDemo bst = new BSTDemo();

        TreeNode root = bst.insert(null, 25);
        bst.insert(root, 18);
        bst.insert(root, 10);
        bst.insert(root, 20);
        bst.insert(root,35);
        bst.insert(root,29);

        Integer res = numOfLeafNodes(root);
        if(res != null) {
            System.out.print("The leaf node(s) present are: " + res);
        } else {
            System.out.print("No leaf node(s) present");
        }
    }
}
