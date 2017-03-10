package trees;

/**
 * Created by srinivas on 2/11/17.
 *
 * Converting a Binary tree to circular doubly linked list
 */
public class TreeToList {

    public static TreeNode treeToList(TreeNode n) {

        if(n == null) {
          return n;
        }

        TreeNode leftList = treeToList(n.leftChild);
        TreeNode rightList = treeToList(n.rightChild);

        n.leftChild = n;
        n.rightChild = n;

        n = concat(leftList, n);
        n = concat(n, rightList);
        return n;
    }

    private static TreeNode concat(TreeNode a, TreeNode b) {

        if(a == null && b == null) {
            return null;
        }

        if(a == null) return b;
        if(b == null) return a;

        TreeNode aEnd = a.leftChild;
        TreeNode bEnd = b.leftChild;

        aEnd.rightChild = b;
        b.leftChild = aEnd;

        bEnd.rightChild = a;
        a.leftChild = bEnd;

        return a;

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
        bst.insert(root, 12);
        bst.insert(root, 28);
        bst.insert(root, 42);

        bst.preOrderTraversal(root);


        TreeNode n = treeToList(root);

        TreeNode temp = n;
        while(temp.data != n.rightChild.data) {
            System.out.print(n.data + " ");
            n = n.rightChild;
        }
    }
}
