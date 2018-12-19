import java.util.*;

/**
 * 3.3
 * 思路：使用ArrayList存栈的集合。递归实现栈左移补充。
 */
class SetOfStacks {
    int STACK_MAX_SIZE = 5;
    ArrayList<Stack> stacks = new ArrayList<>();

    public SetOfStacks() {
        // 创建一个stack。
        stacks.add(new Stack());
    }

    public void push(int d) {
        Stack s = getCurrentStack();
        if (s.size == STACK_MAX_SIZE) {
            Stack newStack = new Stack();
            stacks.add(newStack);
            s = newStack;
        }
        s.push(d);
    }

    public int pop() {
        Stack s = getCurrentStack();
        int d = s.pop();
        if (s.size == 0) {
            stacks.remove(s);
        }
        return d;
    }

    public Stack getCurrentStack() {
        return stacks.get(stacks.size() - 1);
    }

    public int popAt(int index) {
        // check input
        if (index < 0 || index >= stacks.size()) return -1;
        Stack s = stacks.get(index);
        int v = s.pop();
        shiftLeft(index);
        return v;
    }

    public void shiftLeft(int index) {
        // check input
        if (index < 0 || index >= stacks.size()) return;
        Stack s = stacks.get(index);
        if (s.size == STACK_MAX_SIZE) return;
        if (s.size == 0) {
            stacks.remove(s);
            return;
        }
        if (index >= stacks.size() - 1) return;

        Stack right = stacks.get(index + 1);
        int v = right.pop();
        s.pushToBottom(v);
        shiftLeft(index + 1);
    }

    public void print() {
        for (int i = 0; i < stacks.size(); i++) {
            System.out.printf("Stack%d\n", i);
            stacks.get(i).print();
        }
    }
}

public class T3_3 {
    public static void main(String[] args) {
        SetOfStacks s = new SetOfStacks();
        s.push(3);
        s.push(2);
        s.push(3);
        s.push(1);
        s.push(5);
        s.push(3);
        s.push(2);
        s.push(3);
        s.push(1);
        s.push(5);
        s.push(100);
        //s.pop();
        s.popAt(0);
        s.print();
    }

}