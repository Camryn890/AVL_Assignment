public class BTQueueNode<dataType>
{
    BinaryTreeNode<dataType> node;
    BTQueueNode<dataType> next;

    public BTQueueNode(BinaryTreeNode<dataType> node, BTQueueNode<dataType> next)
    {
        this.node = node;
        this.next = next;
    }
}
