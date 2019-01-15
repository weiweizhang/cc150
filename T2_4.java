public class T2_4 {
    /**
     * time:O(n)
     * space:O(n)
     *
     * @param head
     * @param x
     * @return
     */
    public Node sort(Node head, int x) {
        // check
        if (head == null) return null;

        // 创建两个链表，分别存储小node和大node
        Node leftBegin = null;
        Node leftEnd = null;
        Node rightBegin = null;
        Node rightEnd = null;

        // 遍历原链表，插入两个链表
        Node n = head;
        while (n != null) {
            if (n.data < x) {
                if (leftBegin == null) {
                    leftBegin = n;
                    leftEnd = n;
                } else {
                    leftEnd.next = n;
                    leftEnd = n;
                }
            } else {
                if (rightBegin == null) {
                    rightBegin = n;
                    rightEnd = n;
                } else {
                    rightEnd.next = n;
                    rightEnd = n;
                }
            }
            Node last = n;
            n = n.next;
            last.next = null;
        }

        // 拼接链表
        if (leftBegin == null) {
            return rightBegin;
        }
        leftEnd.next = rightBegin;
        return leftBegin;
    }


    public static void main(String[] args) {
        T2_4 t = new T2_4();
        Node head = new Node(5);
        head.next = new Node(7);
        head.next.next = new Node(1);
        head.next.next.next = new Node(3);
        head.next.next.next.next = new Node(5);


        Node n = t.sort(head, 6);
        while (n != null) {
            System.out.println(n.data);
            n = n.next;
        }
    }
}
