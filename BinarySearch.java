/**
 * 二分查找。
 */
public class BinarySearch {
    /**
     * 时间复杂度：O(logn)
     * 空间复杂度：O(logn)
     *
     * @param arr
     * @param b
     * @param e
     * @param x
     * @return
     */
    public int binarySearch(int[] arr, int x, int b, int e) {
        //System.out.printf("x:%d, b:%d, e:%d\n", x, b, e);
        if (arr == null) return -1;
        if (b > e) return -1;
        if (x > arr[e]) return -1;
        if (x < arr[b]) return -1;

        int midIndex = (b + e) / 2;
        int midItem = arr[midIndex];
        if (x == midItem) {
            return midIndex;
        } else if (x < midItem) {
            return binarySearch(arr, x, b, midIndex - 1);
        } else {
            return binarySearch(arr, x, midIndex + 1, e);
        }
    }

    /**
     * 时间复杂度：O(logn)
     * 空间复杂度：O(1)
     *
     * @param arr
     * @param x
     * @return
     */
    public int binarySearchNonRecur(int[] arr, int x) {
        if (arr == null) return -1;
        int len = arr.length;
        if (len == 0) return -1;
        if (x > arr[len - 1]) return -1;
        if (x < arr[0]) return -1;

        int b = 0;
        int e = len - 1;
        int midIndex = 0;
        while (b <= e) {
            midIndex = (b + e) / 2;

            int midItem = arr[midIndex];
            if (x == midItem) {
                return midIndex;
            } else if (x < midItem) {
                e = midIndex - 1;
            } else {
                b = midIndex + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearch t = new BinarySearch();
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        //int index = t.binarySearch(arr, 2, 0, arr.length - 1);
        int index = t.binarySearchNonRecur(arr, 0);
        System.out.println(index);

    }
}
