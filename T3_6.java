import java.util.Stack;

public class T3_6 {
    /**
     * 插入排序思想
     * time: O(n2)
     * space: O(n)
     * @param s
     */
    public void sort(Stack<Integer> s) {
        Stack<Integer> tmp = new Stack<>();
        while (!s.isEmpty()) {
            int d = s.pop();
            while(!tmp.isEmpty()) {
                if (tmp.peek() < d) {
                    s.push(tmp.pop());
                } else {
                    break;
                }
            }
            tmp.push(d);
        }
        // tmp压入s
        while (!tmp.isEmpty()) {
            s.push(tmp.pop());
        }
    }

    public static void main(String[] args) {
        T3_6 t = new T3_6();
        Stack<Integer> s = new Stack<>();
        s.push(3);
        s.push(1);
        s.push(3);
        s.push(5);
        s.push(7);
        t.sort(s);
        System.out.println(s.toString());
    }

}
