import java.util.*;
/**
 * 2.2 实现一个算法，找出单向链表中倒数第k个结点。
 */
public class T2_2 {
    public static void main(String[] args) {
        T2_2 t = new T2_2();

        // test cases
        int[][] testCases = {{1}, {1, 2, 3}, {2, 2, 2}, {1, 2, 3, 4, 5, 5, 6}};
        for (int[] a : testCases) {
            // create linklist
            LinkList ll = new LinkList(a[0]);
            for (int i = 1; i < a.length; i++) {
                ll.appendToTail(a[i]);
            }
            LinkList result = t.findReverseKNode(ll, 3);
            if (result != null) {
                System.out.printf("input:%s,node:%d\n", Arrays.toString(a), result.data);
            } else {
                System.out.printf("input:%s,node:null\n", Arrays.toString(a));
            }
        }
    }

    /**
     * 思路：使用快慢两个指针，两个指针相距k个结点，开始遍历链表，当快指针遍历完成为null时，这时慢指针就是倒数第k个结点。
     *
     * @param head
     * @param k
     * @return
     */
    public LinkList findReverseKNode(LinkList head, int k) {
        // check input
        if (head == null) return null;
        if (k <= 0) return null;

        LinkList s = null;
        LinkList f = head;
        int i = 1;
        // 特殊处理
        if (k == 1) {
            s = head;
        }
        while (f.next != null) { // 保证·最后f落在尾结点
            f = f.next;
            if (s != null) {
                s = s.next;
            }
            i++;

            // 先i++后判断
            if (i == k) {
                s = head;
            }
        }
        return s;
    }
}