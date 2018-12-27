/**
 * 4.3 给定一个有序整数数组，元素各不相同且按升序排列，编写一个算法，创建一颗高度最小的二叉查找树BST。
 *
 * 思路：数组中间的元素作为跟结点，这样树的高度最小。
 */
public class T4_3 {
    /**
     * O(N) O(logn)
     * @param arr
     * @return
     */
    public TreeNode createMinBST(int[] arr) {
        return createMinBSTRec(arr, 0, arr.length - 1);
    }

    public TreeNode createMinBSTRec(int[] arr, int b, int e) {
        // 退出条件
        if (b > e) return null;

        int mid = (b + e) / 2;
        TreeNode r = new TreeNode(arr[mid]);
        r.left = createMinBSTRec(arr, b, mid - 1);
        r.right = createMinBSTRec(arr, mid + 1, e);
        return r;
    }

    public static void main(String[] args) {
        T4_3 t = new T4_3();
        int[] arr = {1, 2, 3, 4, 5, 6};
        TreeNode root = t.createMinBST(arr);
        BinaryTree bt = new BinaryTree();
        bt.inOrder(root);
        System.out.println();
        int height = bt.height(root);
        System.out.printf("height:%d\n", height);
    }
}
