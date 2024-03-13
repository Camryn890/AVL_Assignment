public class BinaryTreeNode<dataType>{

    dataType data;
    BinaryTreeNode<dataType> left;
    BinaryTreeNode<dataType> right;
    int height;

    public BinaryTreeNode(dataType data, BinaryTreeNode<dataType> left, BinaryTreeNode<dataType> right)
    {
        this.data = data;
        this.left = left;
        this.right = right;
        height = 0;
    }

    BinaryTreeNode<dataType> getLeft(){ return left;}
    BinaryTreeNode<dataType> getRight(){return right;}

}
