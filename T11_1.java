/**
 * 11.1
 * 方法一：插入排序，B插入A中，并排序，O(m*n)，性能较差；
 * 方法二：比较巧妙，归并排序，从后往前。O(m+n)，性能好。
 */
public class T11_1 {
    public void merge(int[] a, int[] b, int lastIndex) {
        int i = lastIndex;
        int j = b.length - 1;
        int index = lastIndex + b.length;
        while (j >= 0) {
            if (i < 0) {
                a[index--] = b[j--];
            } else if (a[i] >= b[j]) {
                a[index--] = a[i--];
            } else {
                a[index--] = b[j--];
            }
        }
    }

    public static void main(String[] args) {
        T11_1 t = new T11_1();
        int[] a = {1,2,3,4,6,0,0,0,0,0,0};
        int[] b = {2,3,4,5};
        t.merge(a, b, 4);
        for (int x: a) {
            System.out.printf("%d ", x);
        }
    }
}
