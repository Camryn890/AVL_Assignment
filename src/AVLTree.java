/**
 * Author: Hussein Suleman
 * Represents and AVL tree
 * @param <dataType> The type of data stored in the AVL tree
 */
public class AVLTree <dataType extends Comparable<String>>{

    /**
     * the root of the AVL tree
     */
    BinaryTreeNode<dataType> root;

    /**
     * Counter for the number of comparisons made during search operations.
     */
    public static int count = 0;

    /**
     *  Counter for the number of comparisons made during insertion
     */
    public static int counter = 0;

    /**
     * Constructs an empty AVL tree
     */
    AVLTree(){ root = null;}

    /**
     * Calculates the height of the tree at a given node
     * @param node The node of which the height is calculated
     * @return The height of the tree of the given node
     */
    public int height(BinaryTreeNode<dataType> node)
    {
        if(node != null){ return node.height;}
        return -1;
    }

    /**
     * Calculates the balance factor of the given node
     * @param node The node for which the balance factor needs to be calculated
     * @return The balance factor of the given node
     */
    public int balanceFactor( BinaryTreeNode<dataType> node){ return height(node.getRight()) - height(node.getLeft());}

    /**
     * Fixes the height of the given node
     * @param node The node for which the height has to be fixed
     */
    public void fixHeight(BinaryTreeNode<dataType> node){ node.height = Math.max(height(node.getLeft()),height(node.getRight()))+1;}

    /**
     * Rotates the subtree at given node to the right
     * @param p The root node of the subtree to be rotated.
     * @return The root node of new rotated tree
     */
    public BinaryTreeNode<dataType> rotateRight(BinaryTreeNode<dataType> p)
    {
        BinaryTreeNode<dataType> q = p.left;
        p.left = q.right;
        q.right = p;
        fixHeight(p);
        fixHeight(q);
        return q;
    }

    /**
     * Rotates the subtree at given node to the left
     * @param q  The root node of the subtree to be rotated.
     * @return The root node of new rotated tree
     */
    public BinaryTreeNode<dataType> rotateLeft(BinaryTreeNode<dataType> q)
    {
        BinaryTreeNode<dataType> p = q.right;
        q.right = p.left;
        p.left = q;
        fixHeight(q);
        fixHeight(p);
        return p;
    }

    /**
     * Balances the subtree at a given node
     * @param p The root node of the subtree to be balanced
     * @return The new root node after balancing
     */
    public BinaryTreeNode<dataType> balance (BinaryTreeNode<dataType> p)
    {
        fixHeight(p);
        if(balanceFactor(p) == 2)
        {
            if(balanceFactor(p.right) < 0)
            {
                p.right = rotateRight(p.right);
            }
            return rotateLeft(p);
        }
        if(balanceFactor(p) == -2)
        {
            if(balanceFactor(p.left) > 0)
            {
                p.left = rotateLeft(p.left);
            }
            return rotateRight(p);
        }
        return p;
    }

    /**
     * Inserts the given data into the tree
     * @param data The data that is inserted
     */
    public void insert(Origin data)
    {
        root = insert(data,root);
    }

    /**
     * Inserts the given data into the subtree rooted at a given node
     * @param data The data that is inserted
     * @param node The root node of the subtree in which data is inserted
     * @return The root node of balanced tree
     */
    public BinaryTreeNode<dataType> insert( Origin data, BinaryTreeNode<dataType> node)
    {
        if(node == null)
        {
            return new BinaryTreeNode<dataType>(data, null,null);
        }
        if(data.getTerm().compareTo(node.getData().getTerm()) <= 0 )
        {
            counter++;
            node.left = insert(data, node.left);
        }
        else{ counter++; node.right = insert(data, node.right);}
        return balance(node);
    }

    /**
     * Deletes the given data from the tree
     * @param data The data that is to be deleted
     */
    public void delete(Origin data) {root = delete(data,root);}

    /**
     * Deletes the given data from the subtree rooted at a given node
     * @param data The data to be deleted
     * @param node The root node of the subtree in which data is deleted
     * @return The root node of balanced tree
     */
    public BinaryTreeNode<dataType> delete(Origin data, BinaryTreeNode<dataType> node)
    {
        if(node == null){ return null;}
        if(data.getTerm().compareTo(node.getData().getTerm()) < 0)
        {
            node.left = insert(data, node.getLeft());
        }
        else if(data.getTerm().compareTo(node.getData().getTerm()) > 0)
        {
            node.right = delete(data, node.getRight());
        }
        else
        {
            BinaryTreeNode<dataType> q = node.left;
            BinaryTreeNode<dataType> r = node.right;
            if(r == null){ return q;}
            BinaryTreeNode<dataType> min = findMin(r);
            min.right = removeMin(r);
            min.left = q;
            return balance(min);
        }
        return balance(node);
    }

    /**
     * Finds the minimum node in the subtree rooted at a given node.
     * @param node The root node of the subtree
     * @return The minimum node in the subtree
     */
    public BinaryTreeNode<dataType> findMin(BinaryTreeNode<dataType> node)
    {
        if(node.left != null){ return findMin(node.left);}
        else{return node;}

    }

    /**
     * Removes the minimum node from the subtree rooted at the given node
     * @param node The root node of the subtree
     * @return The new root node
     */
    public BinaryTreeNode<dataType> removeMin(BinaryTreeNode<dataType> node)
    {
        if(node.left == null){ return node.right;}
        node.left = removeMin(node.left);
        return balance(node);
    }

    /**
     * Finds the node containing the given data in the tree.
     * @param data The data to be found
     * @return The node containing the data or null
     */
    public BinaryTreeNode<dataType> find ( Origin data)
    {
        if(root == null){return null;}
        else{ return find(data, root);}
    }

    /**
     * Finds the node containing the given data in the subtree rooted at a given node
     * @param data The data to be found
     * @param node The root node of the subtree
     * @return The node containing the data or null
     */
    public BinaryTreeNode<dataType> find ( Origin data, BinaryTreeNode<dataType> node)
    {
        if(data.getTerm().compareTo(node.getData().getTerm()) == 0){count++; return node;}
        else if(data.getTerm().compareTo(node.getData().getTerm()) <0)
        {
            count++;
            return(node.left == null) ? null : find(data, node.left);
        }
        else
        {
            count++;
            return(node.right == null) ? null : find(data, node.right);
        }

    }

}
