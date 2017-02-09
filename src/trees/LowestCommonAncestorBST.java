package trees;

/**
 * Created by srinivas on 2/9/17.
 *
 * Lowest common ancestor of BST 
 */
public class LowestCommonAncestorBST {

    private static TreeNode lcaBST(TreeNode root, Integer n1, Integer n2) {
        if(root.data > Math.max(n1, n2)) {
            return lcaBST(root.leftChild, n1, n2);
        } else if(root.data < Math.min(n1, n2)) {
            return lcaBST(root.rightChild, n1, n2);
        }
        return root;
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

        TreeNode res = lcaBST(root, 18, 22);
        System.out.print(res.data);

    }
}
