/**
 * 11.3
 * 思路：二分查找，必定有一边是排好序的，通过判断首尾元素，在排好序的一边查找。
 * O(logn)
 */
public class T11_3 {
    public int search(int[] arr, int x, int b, int e) {
        if (arr == null) return -1;
        if (b > e) return -1;

        // 找到中间元素
        int mid = (b + e) / 2;
        if (arr[mid] == x) {
            return mid;
        }
        if (arr[b] < arr[mid]) {
            // 左边排好序了。
            if (x >= arr[b] && x <= arr[mid]) {
                // 在左边找
                return search(arr, x, b, mid - 1);
            } else {
                // 在右边找
                return search(arr, x, mid + 1, e);
            }
        } else if (arr[b] > arr[mid]) {
            // 右边排好序了。
            if (x >= arr[mid] && x <= arr[e]) {
                // 在右边找
                return search(arr, x, mid + 1, e);
            } else {
                // 在左边找
                return search(arr, x, b, mid - 1);
            }
        } else {
            // 无法判断，两边都找。
            int index = search(arr, x, b, mid - 1);
            if (index != -1) {
                return index;
            } else {
                return search(arr, x, mid + 1, e);
            }

        }
    }

    public static void main(String[] args) {
        T11_3 t = new T11_3();
        int[] a = {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14};
        int index = t.search(a, 5, 0, a.length - 1);
        System.out.println(index);
    }
}
