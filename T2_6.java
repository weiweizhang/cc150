public class T2_6 {
    /**
     * 思路：快慢指针+公式推导
     * A：起点，C：环入口，B：相遇点, R:环长度
     * 2(AC+CB)=AC+k*R+CB   k>=1
     * AC = k*R - CB
     * AC = (k-1)*R +BC
     *
     * time: O(n)
     * space: O(1)
     * @param head
     * @return
     */
    public Node FindLoopBeginning(Node head) {
        // check
        if (head == null || head.next == null)
            return null;

        // 快慢指针，相遇
        Node slow = head;
        Node fast = head;
        Node meet = null;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                meet = fast;
                break;
            }
        }
        // 没有环，那么退出
        if (meet == null) {
            return null;
        }

        // fast向入口移动，slow也向入口移动，最终相遇在入口点。
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;

    }
}
