package trees;

/**
 * Created by srinivas on 1/4/17.
 */
public class BinarySearchTree {


    private TreeNode root;

    public TreeNode find(Integer data) {
        if(root != null) {
            return root.find(data);
        }
        return null;
    }

    public Integer smallest() {
        if(root != null) {
            return root.smallest();
        }
        return null;
    }

    public Integer largest() {
        if(root != null) {
            return root.largest();
        }
        return null;
    }

    public void insert(Integer data) {
        if(root == null) {
            root = new TreeNode(data);
        } else {
            root.insert(data);
        }
    }

    public void delete(Integer data) {
        TreeNode current = this.root;
        TreeNode previous = this.root;
        boolean isLeftChild = false;

        // This is the case when the tree does not exist
        if(current == null) {
            return;
        }

        // We need to loop it because until we find current is equal to null (data is not in the tree)
        // or we find the data in the current node
        while (current != null && current.getData().intValue() != data.intValue()) {
            previous = current;

            if(data.intValue() < current.getData().intValue()) {
                current = current.getLeftChild();
                isLeftChild = true;
            } else {
                current =  current.getRightChild();
                isLeftChild = false;
            }
        }

        // Here we check if the current node is null, if it null then we should conclude that
        // the data we were searching is not found in the tree
        if(current == null) {
            return;
        }


        if(current.getLeftChild() == null && current.getRightChild() == null) {
            if(current == root) {
                root = null;
            } else {
                if(isLeftChild) {
                    previous.setLeftChild(null);
                } else {
                    previous.setRightChild(null);
                }
            }
        } else if(current.getRightChild() == null) {
            if(current == root) {
                root = current.getLeftChild();
            } else if(isLeftChild) {
                previous.setLeftChild(current.getLeftChild());
            } else {
                previous.setRightChild(current.getLeftChild());
            }
        } else if(current.getLeftChild() == null) {
            if(current == root) {
                root = current.getRightChild();
            } else if(isLeftChild) {
                previous.setLeftChild(current.getRightChild());
            } else {
                previous.setRightChild(current.getRightChild());
            }
        } else {
            TreeNode successor = getSuccessor(current);
            if(current == root) {
                root = successor;
            } else if (isLeftChild) {
                previous.setLeftChild(successor);
            } else {
                previous.setRightChild(successor);
            }
            successor.setLeftChild(current.getLeftChild());
        }
    }

    private TreeNode getSuccessor(TreeNode node) {
        TreeNode parentOfSuccessor = node;
        TreeNode successor = node;
        TreeNode current = node.getRightChild();

        while (current != null) {
            parentOfSuccessor = successor;
            successor = current;
            current = current.getLeftChild();
        }

        if(successor != node.getRightChild()) {
            // We will be setting the left child of parentOfSuccessor to right child of successor
            // if successor's right child is null (no problem)
            // if successor's right child has some node or node tree, it would not be lost
            // there wont be left child because we would traversed it in the above loop
            parentOfSuccessor.setLeftChild(successor.getRightChild());
            successor.setRightChild(node.getRightChild());
        }

        return successor;
    }

}
