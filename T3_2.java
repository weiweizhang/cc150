/**
 * 3.2 设计一个栈，除了pop与push方法，还支持min方法，可返回栈里的最小值。三个方法的时间复杂度必须为O(1)。
 *
 * 思路：使用一个额外的栈记录当前最小值，pop的时候也同时检查并pop这个额外栈。
 * 时间：O(1)
 * 空间：最好情况是O(1)，最差情况是O(n)，平均是O((n+1)/2)，近似是O(n)。
 */
class StackV2 {
    Node top = null;
    Stack minValue = null;

    public StackV2() {
        minValue = new Stack();
    }

    public void push(int data) {
        Node n = new Node(data);
        if (top == null) {
            top = n;
        } else {
            n.next = top;
            top = n;
        }
        // push min
        if (minValue.top == null) {
            minValue.push(data);
        } else {
            if (data <= minValue.top.data) { // 注意是<=
                minValue.push(data);
            }
        }
    }
    public int pop() {
        if (top == null) {
            return Integer.MIN_VALUE;
        }
        int data = top.data;
        top = top.next;

        // pop min
        if (minValue.top != null && data == minValue.top.data) {
            minValue.pop();
        }
        return data;
    }
    public int min() {
        if (minValue.top == null) {
            return Integer.MIN_VALUE;
        }
        return minValue.top.data;
    }
}

public class T3_2 {
    public static void main(String[] args) {
        StackV2 s = new StackV2();
        s.push(3);
        s.push(2);
        s.push(3);
        s.push(1);
        s.push(5);
        s.pop();
        s.pop();
        int result = s.min();
        System.out.printf("%d", result);
    }


}
