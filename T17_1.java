/**
 * 思路：不能用临时变量，那么只能操作参数本身，使用减法。
 */
public class T17_1 {
    public void swap(int a, int b) {
        a = b - a; // diff
        b = b - a;
        a = a + b;
        System.out.printf("a:%d,b:%d\n", a, b);
    }

    public static void main(String[] args) {
        T17_1 t = new T17_1();
        t.swap(10, 100);

    }
}
