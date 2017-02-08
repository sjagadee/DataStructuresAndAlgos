package trees;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by srinivas on 2/8/17.
 *
 * Level order traversal
 */
public class LevelOrderTraversal {

    private static void levelOrderTraversal(TreeNode root) {
        if(root == null) {
            return;
        }

        Queue<TreeNode> q = new ArrayBlockingQueue<TreeNode>(20);
        q.add(root);
        while(!q.isEmpty()) {
            root = q.poll();
            System.out.print(root.data + " ");

            if(root.leftChild != null) {
                q.add(root.leftChild);
            }
            if(root.rightChild != null) {
                q.add(root.rightChild);
            }
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

        levelOrderTraversal(root);
    }
}
