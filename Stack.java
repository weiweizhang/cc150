/**
 * 栈。
 * 使用链表实现，往表头插入结点，表头删除结点。
 */
public class Stack {
    Node top = null;
    int size = 0;

    public void push(int data) {
        Node n = new Node(data);
        n.next = top;
        top = n;
        size++;
    }

    public int pop() {
        // check
        if (top == null) {
            return -1;
        }
        int data = top.data;
        top = top.next;
        size--;
        return data;
    }

    public void print() {
        Node n = top;
        while (n != null) {
            System.out.printf("%d\n", n.data);
            n = n.next;
        }
    }

    public void pushToBottom(int data) {
        Node n = new Node(data);
        // to the bottom
        if (top == null) {
            top = n;
        } else {
            Node b = top;
            while (b.next != null)
                b = b.next;
            b.next = n;
        }
        size++;
    }

    public static void main(String[] args) {
        Stack obj = new Stack();
        obj.push(1);
        obj.push(2);
        obj.push(3);
        obj.push(4);
        obj.push(5);
        obj.print();
    }
}
