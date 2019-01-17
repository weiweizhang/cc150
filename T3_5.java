import java.util.Stack;

public class T3_5 {
    Stack<Integer> s1 = new Stack();
    Stack<Integer> s2 = new Stack();

    public void enqueue(int d) {
        s1.push(d);
    }

    /**
     * 一个栈放新元素，一个栈放旧元素，延时移动
     * time: O(1)
     * @return
     */
    public int dequeue() {
        // s2为空，把s1压入s2
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }

        // s2 pop最旧
        return s2.pop();
    }
}
