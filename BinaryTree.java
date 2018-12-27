import java.util.LinkedList;
import java.util.Stack;

/**
 * 二叉查找树。
 * 手撸7种遍历大法。
 * 递归遍历时间复杂度O(n),空间复杂度O(logn),因为如果是平衡树最大递归的层数为logn，需要logn的栈空间。
 */
public class BinaryTree {
    TreeNode root = null;

    public void insertByOrder(int d) {
        TreeNode n = new TreeNode(d);

        // 特殊检查
        if (root == null) {
            root = n;
            return;
        }

        // 查找，小放左边，大放右边
        TreeNode cursor = root;
        while (true) {
            if (d <= cursor.data) {
                if (cursor.left == null) {
                    cursor.left = n;
                    break;
                } else {
                    cursor = cursor.left;
                }
            } else {
                if (cursor.right == null) {
                    cursor.right = n;
                    break;
                } else {
                    cursor = cursor.right;
                }
            }
        }
    }

    public TreeNode binarySearch(TreeNode n, int d) {
        // check
        if (n == null) {
            return null;
        }

        // 递归
        if (n.data == d) {
            return n;
        } else if (d < n.data) {
            return binarySearch(n.left, d);
        } else {
            return binarySearch(n.right, d);
        }
    }

    public int height(TreeNode n) {
        if (n == null)
            return 0;
        // 深度 = 左子树和右子树的最大值 + 1
        // 递归
        return Math.max(height(n.left), height(n.right)) + 1;
    }

    /**
     * 前序遍历
     * O(n)
     */
    public void preOrder(TreeNode n) {
        if (n == null) {
            return;
        }
        System.out.printf("%d ", n.data);
        preOrder(n.left);
        preOrder(n.right);

    }

    /**
     * 中序遍历
     * O(n)
     */
    public void inOrder(TreeNode n) {
        if (n == null) {
            return;
        }
        inOrder(n.left);
        System.out.printf("%d ", n.data);
        inOrder(n.right);
    }

    /**
     * 后序遍历
     */
    public void postOrder(TreeNode n) {
        if (n == null) {
            return;
        }
        postOrder(n.left);
        postOrder(n.right);
        System.out.printf("%d ", n.data);
    }


    /**
     * 前序遍历，迭代非递归。
     */
    public void preOrderNonRec(TreeNode root) {
        // check
        if (root == null) {
            return;
        }

        // 使用栈存储访问过的结点。
        // visit结点时机：入栈前
        TreeNode n = root;
        Stack<TreeNode> s = new Stack<>();
        while (!s.empty() || n != null) {
            if (n != null) {
                System.out.printf("%d ", n.data);
                s.push(n);
                n = n.left;
            } else {
                n = s.pop();
                n = n.right;
            }
        }

    }

    /**
     * 中序遍历，迭代非递归。
     */
    public void inOrderNonRec(TreeNode root) {
        // check
        if (root == null) {
            return;
        }

        // 使用栈存储访问过的结点。
        // visit结点时机：出栈时
        TreeNode n = root;
        Stack<TreeNode> s = new Stack<>();
        while (!s.empty() || n != null) {
            if (n != null) {
                s.push(n);
                n = n.left;
            } else {
                n = s.pop();
                System.out.printf("%d ", n.data);
                n = n.right;
            }
        }

    }

    /**
     * 后序遍历，迭代非递归。
     */
    public void postOrderNonRec(TreeNode root) {
        // check
        if (root == null) {
            return;
        }

        // 使用栈存储访问过的结点，使用pre记录上一次访问的结点。
        // visit结点时机：第二次回溯时出栈时
        TreeNode n = root;
        TreeNode pre = null;
        Stack<TreeNode> s = new Stack<>();
        while (!s.empty() || n != null) {
            if (n != null) {
                s.push(n);
                n = n.left;
            } else {
                n = s.peek();
                // 栈顶的右孩子是pre或者为空的时候，那么可以visit了。
                if (n.right == pre || n.right == null) {
                    n = s.pop();
                    System.out.printf("%d ", n.data);
                    pre = n;
                    n = null;
                } else {
                    n = n.right;
                }
            }
        }

    }


    /**
     * 层次遍历
     */
    public void levelOrder(TreeNode root) {
        // check
        if (root == null) {
            return;
        }

        // 使用队列。
        LinkedList<TreeNode> ll = new LinkedList<TreeNode>();
        ll.offer(root);

        while (!ll.isEmpty()) {
            TreeNode n = ll.poll();
            System.out.printf("%d ", n.data);
            // 把左孩子和右孩子加入队列
            if (n.left != null)
                ll.offer(n.left);
            if (n.right != null)
                ll.offer(n.right);
        }
    }

    public static void main(String[] args) {
        BinaryTree t = new BinaryTree();
        t.insertByOrder(1);
        t.insertByOrder(5);
        t.insertByOrder(3);
        t.insertByOrder(4);
        t.insertByOrder(2);
        System.out.printf("inOrder:");
        t.inOrder(t.root);
        System.out.printf("\n");
        System.out.printf("inOrderNonRec:");
        t.inOrderNonRec(t.root);
        System.out.printf("\n");
        System.out.printf("preOrder:");
        t.preOrder(t.root);
        System.out.printf("\n");
        System.out.printf("preOrderNonRec:");
        t.preOrderNonRec(t.root);
        System.out.printf("\n");
        System.out.printf("postOrder:");
        t.postOrder(t.root);
        System.out.printf("\n");
        System.out.printf("postOrderNonRec:");
        t.postOrderNonRec(t.root);
        System.out.printf("\n");
        System.out.printf("levelOrder:");
        t.levelOrder(t.root);
        System.out.printf("\n");
        int d = 30;
        TreeNode result = t.binarySearch(t.root, d);
        System.out.printf("binarySearch:%d,%s\n", d, result);
        int height = t.height(t.root);
        System.out.printf("height:%d\n", height);
    }
}
