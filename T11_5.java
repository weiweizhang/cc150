/**
 * 11.5
 * 方法一：全部遍历，性能差，O（n)
 * 方法二：二分查找，如果找到空字符串，往后面继续找，直到非空为止。O(logn)
 * <p>
 * 考虑特殊情况，查找字符串为空字符串, 当作异常处理。
 */
public class T11_5 {
    public int search(String[] a, String x, int b, int e) {
        if (a == null) return -1;
        if (a.length == 0) return -1;

        // 特殊处理空字符串。
        if (x.equals("")) {
            for (int i = 0; i < a.length; i++) {
                if (a[i].equals("")) {
                    return i;
                }
            }
        }

        // 找到中间元素
        int mid = (b + e) / 2;
        while (a[mid].equals("") && mid <= e) {
            mid++;
        }
        if (mid > e) {
            return search(a, x, b, mid - 1);
        }

        if (a[mid].equals(x)) {
            return mid;
        } else if (a[mid].compareTo(x) > 0) {
            return search(a, x, b, mid - 1);
        } else {
            return search(a, x, mid + 1, e);
        }
    }

    public static void main(String[] args) {
        T11_5 t = new T11_5();
        String[] a = {"at", "","","","ball","","","car","","","dad","",""};
        int index = t.search(a, "ball", 0, a.length - 1);
        System.out.println(index);
    }
}
