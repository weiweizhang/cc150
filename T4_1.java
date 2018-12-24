/**
 * 4.1 实现一个函数，检查二叉树是否平衡。平衡树定义：任意一个结点，两颗子树的高度差<=1。
 */
public class T4_1 {
    public static void main(String[] args) {
        T4_1 t = new T4_1();
        BinaryTree tr = new BinaryTree();
        tr.insertByOrder(3);
        tr.insertByOrder(2);
        tr.insertByOrder(1);
        tr.insertByOrder(5);
        tr.insertByOrder(4);
        tr.inOrder(tr.root);
        boolean result = t.isBalanced(tr.root);
        System.out.printf("%b\n", result);
    }

    public boolean isBalanced(TreeNode root) {
        // check
        if (root == null) {
            return false;
        }
        if (checkHeight(root) != -1) {
            return true;
        } else {
            return false;
        }
    }

    public int checkHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = checkHeight(root.left);
        if (leftHeight == -1) {
            return -1;
        }
        int rightHeight = checkHeight(root.right);
        if (rightHeight == -1) {
            return -1;
        }

        int diff = Math.abs(leftHeight - rightHeight);
        if (diff > 1) {
            return -1;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
}
