public class T3_4 {
    /**
     * 简单构造法，递归。
     * 重点是如何分治问题。自顶向下。
     *
     * time:O(2N) 2的N次方
     * space:O(n)
     */
    public void moveDisks(int n, Stack from, Stack to, Stack buffer) {
        //System.out.printf("n:%d\n", n);
        if (n <= 0) return;  // 递归退出条件

        // 把n-1歌圆盘移动到buffer塔
        moveDisks(n - 1, from, buffer, to);
        // 把最后一个圆盘移动到to塔
        moveTop(from, to);
        // 把n-1歌圆盘移动到to塔
        moveDisks(n - 1, buffer, to, from);
    }

    public void moveTop(Stack from, Stack to) {
        int d = from.pop();
        to.push(d);
    }

    public static void main(String[] args) {
        T3_4 t = new T3_4();
        int n = 5;
        Stack from = new Stack();
        for (int i = n; i > 0; i--)
            from.push(i);
        //from.print();
        Stack to = new Stack();
        Stack buffer = new Stack();
        t.moveDisks(n, from, to, buffer);
        // print
        to.print();
    }
}
