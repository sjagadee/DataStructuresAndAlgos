package trees;

/**
 * Created by srinivas on 2/9/17.
 * <p>
 * Converting a sorted array into balanced binary tree
 */
public class ArrayToBalancedBinaryTree {

    private static TreeNode arrayToBBT(Integer[] array, int first, int last) {

        if (first > last) {
            return null;
        }

        int mid = (first + last) / 2;
        TreeNode root = new TreeNode(array[mid]);

        root.leftChild = arrayToBBT(array, first, mid - 1);
        root.rightChild = arrayToBBT(array, mid + 1, last);

        return root;
    }

    public static void main(String[] args) {
        Integer[] array = {10, 20, 30, 40, 50, 60, 70, 80, 90};
        TreeNode res = arrayToBBT(array, 0, array.length-1);

        BSTDemo.inOrderTraversal(res);
    }
}
