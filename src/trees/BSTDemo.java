package trees;

/**
 * Created by srinivas on 2/8/17.
 *
 *
 * This class has:
 * 1. Insert
 * 2. Search
 * 3. Recursive Tree Traversals (in, pre, post)
 */
public class BSTDemo {

    static TreeNode root;

    public static TreeNode insert(TreeNode root, int data) {
        if(root == null) {
            root = new TreeNode(data);
            return root;
        }
        if(root.data > data) {
            if(root.leftChild == null) {
                root.leftChild = new TreeNode(data);
            } else {
                root.leftChild = insert(root.leftChild, data);
            }
        } else if (root.data < data) {
            if(root.rightChild == null) {
                root.rightChild = new TreeNode(data);
            } else {
                root.rightChild = insert(root.rightChild, data);
            }
        }
        return root;
    }

    public static TreeNode search(TreeNode root, int data) {
        if(root == null || root.data == data) {
            return root;
        } else if(root.data < data && root.rightChild != null) {
            return search(root.rightChild, data);
        } else if(root.data > data && root.leftChild != null) {
            return search(root.leftChild, data);
        }
        return null;
    }

    public static void preOrderTraversal(TreeNode root) {
        if(root!= null) {
            System.out.print(root.data + " ");
            preOrderTraversal(root.leftChild);
            preOrderTraversal(root.rightChild);
        }
    }

    public static void inOrderTraversal(TreeNode root) {
        if(root!= null) {
            inOrderTraversal(root.leftChild);
            System.out.print(root.data + " ");
            inOrderTraversal(root.rightChild);
        }
    }

    public static void postOrderTraversal(TreeNode root) {
        if(root != null) {
            postOrderTraversal(root.leftChild);
            postOrderTraversal(root.rightChild);
            System.out.print(root.data + " ");
        }
    }

    public static void main(String[] args) {
        root = insert(null, 25);
        insert(root, 20);
        insert(root, 35);
        insert(root, 18);
        insert(root, 22);
        insert(root, 30);
        insert(root,40);

        preOrderTraversal(root);

    }

}
