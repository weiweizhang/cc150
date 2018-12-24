import java.util.HashSet;

/**
 * 2.1 移除未排序的链表中的重复节点。
 * 进阶：如果不得使用临时缓冲区，该怎么解决？
 */
public class Test2_1 {
    public static void main(String[] args) {
        Test2_1 t = new Test2_1();

        // test cases
        int[][] testCases = {{1}, {1,2,3}, {2,2,2}, {1,2,3,4,5,5,6}};
        for (int[] a: testCases) {
            // create linklist
            LinkList ll = new LinkList();
            for (int i = 0; i < a.length; i++) {
                ll.appendToTail(a[i]);
            }
            // delete duplicate
            //ll.traverse();
            //t.deleteDup(ll);
            //ll.traverse();

            ll.traverse();
            t.deleteDupV2(ll.head);
            ll.traverse();
        }
    }

    /**
     * 思路：使用HashSet作为临时缓冲区，存储出现过的结点。
     * 遍历链表，如果结点在HashSet中，则移除。
     * 时间：O(n)
     * 空间：O(n)
     */
    public void deleteDup(LinkList ll) {
        // check input
        if (ll.head == null) return;

        HashSet<Integer> set = new HashSet<>();
        Node n = ll.head;
        Node pre = null;
        while (n != null) {
            if (set.contains(n.data)) {
                pre.next = n.next;
            } else {
                set.add(n.data);
                pre = n;
            }
            n = n.next;
        }
    }


    /**
     * 思路：使用递归。
     * 从第二个结点开始遍历链表，如果与头结点相同，则移除。
     * 时间：O(n2)
     * 空间：O(n)
     */
    public void deleteDupV2(Node head) {
        // check input
        if (head == null) return;

        int headData = head.data;
        Node n = head;
        while (n.next != null) {
            if (n.next.data == headData) {
                n.next = n.next.next;
            } else {
                n = n.next;
            }
        }
        deleteDupV2(head.next);
    }
}
