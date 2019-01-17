public class T2_5 {
    /**
     * time: O(n)
     * space: O(n)
     * @param a
     * @param b
     * @return
     */
    public Node add(Node a, Node b) {
        // check
        if (a == null) return b;
        if (b == null) return a;

        int carry = 0;
        Node result = null;
        Node cur = null;
        while (a != null || b != null) {
            // 计算和
            int sum = 0;
            if (a != null) sum += a.data;
            if (b != null) sum += b.data;
            sum += carry;

            // 保存结果结点
            Node n = new Node(sum % 10);
            if (result == null) {
                result = n;
                cur = result;
            } else {
                cur.next = n;
                cur = cur.next;
            }

            // 重算carry
            carry = sum / 10;
            if (a != null) a = a.next;
            if (b != null) b = b.next;
        }
        // 判断最后有可能进位
        if (carry == 1) {
            Node n = new Node(1);
            cur.next = n;
        }
        return result;
    }

    public static void main(String[] args) {
        T2_5 t = new T2_5();
        Node a = new Node(7);
        a.next = new Node(1);
        a.next.next = new Node(6);
        Node b = new Node(5);
        b.next = new Node(9);
        b.next.next = new Node(2);
        Node result = t.add(a, b);
        // print linklist
        Node n = result;
        while (n != null) {
            System.out.println(n.data);
            n = n.next;
        }
    }

}
