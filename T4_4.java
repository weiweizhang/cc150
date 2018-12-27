import java.util.*;
/**
 * 4.4 给定一棵二叉树，设计一个算法，创建含有某一深度上所有结点的链表（比如，一棵树的深度为D，则创建D个链表。
 *
 */
public class T4_4 {
    /**
     * 使用广度优先遍历，将生成的链表保存到ArrayList中并返回。
     * O(n) O(n)
     * @param root
     * @return
     */
    public ArrayList<LinkedList<TreeNode>> createbroLinkedList(TreeNode root) {
        // check
        if (root == null) return null;

        ArrayList<LinkedList<TreeNode>> result = new ArrayList<>();
        LinkedList<TreeNode> ll = new LinkedList<>();
        ll.add(root);
        while (!ll.isEmpty()) {
            result.add(ll);

            LinkedList<TreeNode> newll = new LinkedList<>();
            for (TreeNode n: ll) {
                if (n.left != null) {
                    newll.add(n.left);
                }
                if (n.right != null) {
                    newll.add(n.right);
                }
            }
            ll = newll;
        }
        return result;
    }

    public static void main(String[] args) {
        T4_4 t = new T4_4();
        BinaryTree bt = new BinaryTree();
        bt.insertByOrder(1);
        bt.insertByOrder(5);
        bt.insertByOrder(3);
        bt.insertByOrder(4);
        bt.insertByOrder(2);
        ArrayList<LinkedList<TreeNode>> result = t.createbroLinkedList(bt.root);
        for (LinkedList<TreeNode> ll : result) {
            System.out.println(ll);
        }
    }
}
