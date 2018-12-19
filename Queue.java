/**
 * 队列。
 * 使用链表实现，往表尾部插入结点，表头删除结点。
 */
public class Queue {
    Node first = null;
    Node last = null;

    public void enqueue(int data) {
        Node n = new Node(data);
        if (last == null) {
            last = n;
            first = n;
        } else {
            last.next = n;
            last = n;
        }
    }

    public int dequeue() {
        // check
        if (first == null) {
            return -1;
        }
        int data = first.data;
        first = first.next;
        if (first == null) {
            last = null;
        }
        return data;
    }

    public void print() {
        Node n = first;
        while (n != null) {
            System.out.printf("%d ", n.data);
            n = n.next;
        }
    }

    public static void main(String[] args) {
        Queue obj = new Queue();
        obj.enqueue(1);
        obj.enqueue(2);
        obj.enqueue(3);
        obj.enqueue(4);
        obj.enqueue(5);
        obj.print();
    }
}
