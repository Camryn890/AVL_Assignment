/**
 * Author: Hussein Suleman
 *Represents the binary tree
 * @param <dataType> the type of data stored in the binary tree
 */
public class BinaryTree<dataType> {
    /**
     * The root node of the binary tree
     */
    BinaryTreeNode<dataType> root;

    /**
     * Constructs an empty binary tree
     */
    public BinaryTree() {
        root = null;
    }

    /**
     * Gets the height of the binary tree
     *
     * @return The height of the binary tree
     */
    public int getHeight() {
        return getHeight(root);
    }

    /**
     * Gets the height of the binary tree rooted at the node given
     *
     * @param node The root node of the binary tree
     * @return The height of the binary tree rooted at the node given
     */
    public int getHeight(BinaryTreeNode<dataType> node) {
        if (node == null) {
            return -1;
        } else {
            return 1 + Math.max(getHeight(node.getLeft()), getHeight(node.getRight()));
        }
    }

    /**
     * Gets the number of nodes of the binary tree
     *
     * @return The size of the binary tree
     */
    public int getSize() {
        return getSize(root);
    }

    /**
     * Gets the number of nodes of the binary tree rooted at the given node
     *
     * @param node The root node of the binary tree
     * @return the size of the binary tree rooted at the given node
     */
    public int getSize(BinaryTreeNode<dataType> node) {
        if (node == null) {
            return 0;
        } else {
            return 1 + getSize(node.getLeft()) + getSize(node.getRight());
        }
    }

    /**
     * Prints the data of the given node
     *
     * @param node The node visited
     */
    public void visit(BinaryTreeNode<dataType> node) {
        System.out.println(node.getData());
    }

    /**
     * Does a pre-order traversal of the binary tree
     */
    public void preOrder() {
        preOrder(root);
    }

    /**
     * Does a pre-order traversal of the binary tree rooted at the given node
     *
     * @param node The root node of the binary tree
     */
    public void preOrder(BinaryTreeNode<dataType> node) {
        if (node != null) {
            visit(node);
            preOrder(node.getLeft());
            preOrder(node.getRight());
        }
    }

    /**
     * Does a post-order traversal of the binary tree
     */
    public void postOrder() {
        postOrder(root);
    }

    /**
     * Does a post-order traversal of the binary tree rooted at a given node
     *
     * @param node The root node of the binary tree
     */
    public void postOrder(BinaryTreeNode<dataType> node) {
        if (node != null) {
            postOrder(node.getLeft());
            postOrder(node.getRight());
            visit(node);
        }
    }

    /**
     * Does a inOrder traversal of the binary tree
     */
    public void inOrder() {
        inOrder(root);
    }

    /**
     * Does a inOrder traversal of the binary tree rooted at the given node
     *
     * @param node The root node of the binary tree
     */
    public void inOrder(BinaryTreeNode<dataType> node) {
        if (node != null) {
            inOrder(node.getLeft());
            visit(node);
            inOrder(node.getRight());
        }
    }
}
