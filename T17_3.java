/**
 * 1 有多少对2和5，就有多少个0
 * 2 2比5多，所以取决于有多少个5
 * 3 25算作两个5， 125算3个5
 * 4 总数=5倍的个数+5X5的个数+5X5X5的个数+。。。。
 */
public class T17_3 {
    public int count(int n) {
        // check
        if (n < 0) return 0;

        int count = 0;
        for (int base = 5; n / base > 0; base *= 5) {
            count += n / base;

        }
        return count;
    }

    public static void main(String[] args) {
        T17_3 t = new T17_3();
        int result = t.count(25);
        System.out.println(result);
    }
}
