/***
 * 链表实现。
 */
public class LinkList {
    public int data;
    public LinkList next = null;   // 初始化为null

    /**
     * 构造函数。
     * @param data
     */
    public LinkList(int data) {
        this.data = data;
    }

    public void appendToTail(int data) {
        LinkList obj = new LinkList(data);

        // 找到结尾
        LinkList n = this;
        while (n.next != null) {
            n = n.next;
        }

        // append
        n.next = obj;
    }

    public LinkList deleteNode(LinkList head, int data) {
        LinkList n = head;

        // 特殊处理，第一个就满足条件
        if (n.data == data) {
            return n.next;
        }
        while (n.next != null) {
            if (n.next.data == data) {
                n.next = n.next.next;
                break;
            }
            n = n.next;
        }
        return head;
    }

    public void traverse() {
        LinkList n = this;
        while (n != null) {
            System.out.printf("%d ", n.data);
            n = n.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkList n = new LinkList(1);
        n.appendToTail(2);
        n.appendToTail(3);
        n.appendToTail(4);
        n.appendToTail(5);
        n.traverse();
        LinkList a = n.deleteNode(n, 1);
        a.traverse();
    }

}
