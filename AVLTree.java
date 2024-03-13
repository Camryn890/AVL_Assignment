
public class AVLTree <dataType extends Comparable<String>>{

    BinaryTreeNode<dataType> root;

    AVLTree(){ root = null;}
    public int height(BinaryTreeNode<dataType> node)
    {
        if(node != null){ return node.height;}
        return -1;
    }

    public int balanceFactor( BinaryTreeNode<dataType> node){ return height(node.getRight()) - height(node.getLeft());}

    public void fixHeight(BinaryTreeNode<dataType> node){ node.height = Math.max(height(node.getLeft()),height(node.getRight()))+1;}

    public BinaryTreeNode<dataType> rotateRight(BinaryTreeNode<dataType> p)
    {
        BinaryTreeNode<dataType> q = p.left;
        p.left = q.right;
        q.right = p;
        fixHeight(p);
        fixHeight(q);
        return q;
    }

    public BinaryTreeNode<dataType> rotateLeft(BinaryTreeNode<dataType> q)
    {
        BinaryTreeNode<dataType> p = q.right;
        q.right = p.left;
        p.left = q;
        fixHeight(q);
        fixHeight(p);
        return p;
    }

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

    public void insert(Origin data)
    {
        root = insert(data,root);
    }
    public BinaryTreeNode<dataType> insert( Origin data, BinaryTreeNode<dataType> node)
    {
        if(node == null)
        {
            return new BinaryTreeNode<dataType>(data, null,null);
        }
        if(data.compareTo(node.getData().getTerm()) <= 0 )
        {
            node.left = insert(data, node.left);
        }
        else{ node.right = insert(data, node.right);}
        return balance(node);
    }

    public void delete(Origin data) {root = delete(data,root);}
    public BinaryTreeNode<dataType> delete(Origin data, BinaryTreeNode<dataType> node)
    {
        if(node == null){ return null;}
        if(data.compareTo(node.getData().getTerm()) < 0)
        {
            node.left = insert(data, node.getLeft());
        }
        else if(data.compareTo(node.getData().getTerm()) > 0)
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

    public BinaryTreeNode<dataType> findMin(BinaryTreeNode<dataType> node)
    {
        if(node.left != null){ return findMin(node.left);}
        else{return node;}

    }

    public BinaryTreeNode<dataType> removeMin(BinaryTreeNode<dataType> node)
    {
        if(node.left == null){ return node.right;}
        node.left = removeMin(node.left);
        return balance(node);
    }

    public BinaryTreeNode<dataType> find ( Origin data)
    {
        if(root == null){return null;}
        else{ return find(data, root);}
    }
    public BinaryTreeNode<dataType> find ( Origin data, BinaryTreeNode<dataType> node)
    {
        if(data.compareTo(node.getData().getTerm()) == 0){ return node;}
        else if(data.compareTo(node.getData().getTerm()) <0)
        {
            return(node.left == null) ? null : find(data, node.left);
        }
        else{return(node.right == null) ? null : find(data, node.right);}
    }

    public void treeOrder(BinaryTreeNode<dataType> node , int level)
    {
        if(node != null)
        {
            for(int i = 0 ; i < level; i++){ System.out.print(" ");}
            System.out.println(node.getData());
            treeOrder(node.left, level+1);
            treeOrder(node.right, level+1);
        }
    }
}
