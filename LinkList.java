/***
 * 链表实现。
 */
public class LinkList {
    public Node head = null;   // 初始化为null

    /**
     * 构造函数。
     */
    public LinkList() {
    }

    public void appendToTail(int data) {
        Node obj = new Node(data);

        // 空链表
        if (head == null) {
            head = obj;
            return;
        }

        // 找到结尾
        Node n = head;
        while (n.next != null) {
            n = n.next;
        }

        // append
        n.next = obj;
    }

    public void deleteNode(int data) {
        Node n = head;

        // 特殊处理，第一个就满足条件
        if (n.data == data) {
            head = n.next;
        }
        while (n.next != null) {
            if (n.next.data == data) {
                n.next = n.next.next;
                break;
            }
            n = n.next;
        }
    }

    public void traverse() {
        Node n = head;
        while (n != null) {
            System.out.printf("%d ", n.data);
            n = n.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkList n = new LinkList();
        n.appendToTail(1);
        n.appendToTail(2);
        n.appendToTail(3);
        n.appendToTail(4);
        n.appendToTail(5);
        n.traverse();
        n.deleteNode(1);
        n.traverse();
    }

}
