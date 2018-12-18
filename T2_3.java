import java.util.Arrays;

/**
 * 2.3 实现一个算法，删除单向链表中间的某个结点，假定你只能访问该结点，不能访问链表头。
 */
public class T2_3 {
    public static void main(String[] args) {
        T2_3 t = new T2_3();

        // test cases
        int[] a = {1, 2, 3, 4, 5, 5, 6};
        // create linklist
        LinkList ll = new LinkList(a[0]);
        for (int i = 1; i < a.length; i++) {
            ll.appendToTail(a[i]);
        }
        LinkList n = ll;
        int i = 0;
        while (n != null) {
            n = n.next;
            i++;
            if (i == 3) break;
        }
        ll.traverse();
        t.deleteNode(n);
        ll.traverse();
    }

    public void deleteNode(LinkList n) {
        if (n == null) return;
        if (n.next == null) return;

        n.data = n.next.data;
        n.next = n.next.next;
    }
}