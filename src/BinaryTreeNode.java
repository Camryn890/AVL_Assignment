/**
 * Author: Hussein Suleman
 * Represents a node in the binary tree
 * @param <dataType> The type of data stored
 */
public class BinaryTreeNode<dataType>{

    /**
     * The data stored in the node
     */
    Origin data;

    /**
     * Represents the left child node
     */
    BinaryTreeNode<dataType> left;

    /**
     * Represents the right child node
     */
    BinaryTreeNode<dataType> right;

    /**
     * The height of the node in the binary tree
     */
    int height;

    /**
     * Constructs a new BinaryTreeNode with the data given
     * @param data The data stored in the node
     * @param left The left child node
     * @param right The right child node
     */
    public BinaryTreeNode(Origin data, BinaryTreeNode<dataType> left, BinaryTreeNode<dataType> right)
    {
        this.data = data;
        this.left = left;
        this.right = right;
        height = 0;
    }

    /**
     * Gets the left child node
     * @return The left child node
     */
    BinaryTreeNode<dataType> getLeft(){ return left;}

    /**
     * Gets the right child node
     * @return The right child node
     */
    BinaryTreeNode<dataType> getRight(){return right;}

    /**
     * Gets the data stored in the node
     * @return The data stored in the node
     */
    Origin getData(){ return data;}

}
