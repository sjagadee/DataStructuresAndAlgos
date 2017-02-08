package trees;

/**
 * Created by srinivas on 1/4/17.
 */
public class TreeNode {

    Integer data;
    TreeNode leftChild;
    TreeNode rightChild;

    public TreeNode(Integer data) {
        this.data = data;
    }

    public Integer smallest() {
        if(this.leftChild == null) {
            return this.data;
        } else {
            return this.leftChild.smallest();
        }
    }

    public Integer largest() {
        if(this.rightChild == null) {
            return this.data;
        } else {
            return this.rightChild.largest();
        }
    }

    public TreeNode find(Integer data) {
        // We check if the given data and current node data is equal, then we return the current node
        if(data == this.data) {
            return this;
        }

        // if the given data is less than that of the current data and left tree is not null, then we
        // call find method recursively on left sub tree
        if(data.intValue() < this.data.intValue() && leftChild != null) {
            return leftChild.find(data);
        }

        // finally when the data is greater than that of the current data and right tree is not null
        // then we call find method recursively on right sub tree
        if(rightChild != null) {
            return rightChild.find(data);
        }

        return null;
    }

    public void insert(Integer data) {

        // check if the data to be inserted is greater than the data present in the current node
        if(data.intValue() >= this.data.intValue()) {
            // if the right tree is null,  then insert new node with the data provided as right sub tree
            if(this.rightChild == null) {
                this.rightChild = new TreeNode(data);
            }
            // if the right tree has node, then make a recursive call to insert in the right sub tree
            else {
                this.rightChild.insert(data);
            }
        }

        // if the data to be inserted is leaser than the data present in the current node
        else {
            // if the left tree is null, then insert new node with data provided as left sub tree
            if(this.leftChild == null) {
                this.leftChild = new TreeNode(data);
            }
            // if the left tree has node, then make a recursive call to insert in the left sub tree
            else {
                this.leftChild.insert(data);
            }
        }
    }

    public Integer getData() {
        return data;
    }

    public TreeNode getLeftChild() {
        return leftChild;
    }

    public TreeNode getRightChild() {
        return rightChild;
    }

    public void setLeftChild(TreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public void setRightChild(TreeNode rightChild) {
        this.rightChild = rightChild;
    }
}
