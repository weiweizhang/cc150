/**
 * 树结点的实现。
 */
public class TreeNode {
    public int data;  // 自动初始化0
    TreeNode left = null;  // 自动初始化null
    TreeNode right = null;  // 自动初始化null

    public TreeNode(int d) {
        data = d;
    }
    public String toString() {
        String lefts = "";
        if (left != null) {
            lefts = "[TreeNode]";
        } else {
            lefts = "null";
        }
        String rights = "";
        if (right != null) {
            rights = "[TreeNode]";
        } else {
            rights = "null";
        }
        return String.format("data:%d, left:%s, right:%s", data, lefts, rights);
    }
}
