package trees;


import java.util.Stack;

/**
 * Created by srinivas on 2/8/17.
 *
 * Top view
 */
public class TopView {

    private static void topView(TreeNode root) {
        if(root == null) {
            return;
        }

        Stack<TreeNode> stack =  new Stack<>();
        TreeNode temp = root;
        while (temp != null){
            stack.add(temp);
            temp = temp.leftChild;
        }
        while(!stack.isEmpty()) {
            temp = stack.pop();
            System.out.print(temp.data + " ");
        }
        temp = root;
        while(temp.rightChild != null) {
            temp = temp.rightChild;
            System.out.print(temp.data + " ");
        }
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

        topView(root);
    }
}
