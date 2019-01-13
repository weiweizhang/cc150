import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

/**
 * 10大经典排序算法。
 */
public class Sort {
    /**
     * 冒泡排序。
     * 最笨的方法，基本不会用到。
     * 思路：两两比较，如果左边大则交换两元素，这样最后一个元素是最大值。总共n-1趟排序。
     * <p>
     * 平均 最好 最坏
     * O(n2) O(n2) O(n2)
     * 空间复杂度 O(1)
     * 稳定
     *
     * @param arr
     */
    public void bubbleSort(int[] arr) {
        // check input
        if (arr == null) return;
        int len = arr.length;
        if (len == 1) return;

        // n-1趟排序
        for (int i = 1; i <= len - 1; i++) {
            for (int j = 0; j <= len - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // swap
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }

    /**
     * 选择排序。
     * 这是最容易想到的一种排序方法了。
     * 思路：扫描一遍数组，找到最大值，并与最后一元素交换，这样最后一个元素是最大值。总共n-1趟排序。
     * <p>
     * 平均 最好 最坏
     * O(n2) O(n2) O(n2)
     * 空间复杂度 O(1)
     * 不稳定: 交换是跳跃式的，会打乱原有顺序
     *
     * @param arr
     */
    public void selectionSort(int[] arr) {
        // check input
        if (arr == null) return;
        int len = arr.length;
        if (len == 1) return;

        // n-1趟排序
        for (int i = 1; i <= len - 1; i++) {
            int maxIndex = 0;
            for (int j = 0; j <= len - i; j++) {
                if (arr[j] > arr[maxIndex]) {
                    maxIndex = j;
                }
            }
            // 最大元素与最后一个元素交换位置
            int lastIndex = len - i;
            if (maxIndex != lastIndex) {
                // swap
                int tmp = arr[lastIndex];
                arr[lastIndex] = arr[maxIndex];
                arr[maxIndex] = tmp;
            }
        }
    }

    /**
     * 插入排序。
     * （适合基本有序序列场景，可以达到O(n)）
     * 思路：从第二个元素开始，插入到前面的有序序列中。总共n-1趟排序。
     * <p>
     * 平均 最好 最坏
     * O(n2) O(n) O(n2)
     * 空间复杂度 O(1)
     * 稳定
     *
     * @param arr
     */
    public void insertionSort(int[] arr) {
        // check input
        if (arr == null) return;
        int len = arr.length;
        if (len == 1) return;

        // n-1趟排序
        for (int i = 1; i <= len - 1; i++) {
            int targetIndex = i; // 要插入的元素下标
            for (int j = i - 1; j >= 0; j--) { // 前面i个元素一一比较。
                if (arr[targetIndex] < arr[j]) {
                    // swap
                    int tmp = arr[targetIndex];
                    arr[targetIndex] = arr[j];
                    arr[j] = tmp;
                    targetIndex = j; // 插入元素的下标发生了变化！！
                } else {
                    break; // 跳出循环
                }
            }
        }
    }


    /**
     * 希尔排序。
     * （别名缩小增量排序，是插入排序的优化版）
     * 思路：初始增量len/2，之后每次除以2，最后为1，相当于插入排序。
     * <p>
     * 平均 最好 最坏
     * O(n1.3) O(n) O(n2)
     * 空间复杂度 O(1)
     * 不稳定（因为会跳跃的交换）
     *
     * @param arr
     */
    public void shellSort(int[] arr) {
        // check input
        if (arr == null) return;
        int len = arr.length;
        if (len == 1) return;

        //
        int gap = len / 2;
        while (gap >= 1) {  // 每次缩小增量
            for (int i = 0; i < gap; i++) {   // 每个分组
                // 对每个分组，执行插入排序。
                for (int ii = i + gap; ii < len; ii += gap) {  // 每趟排序
                    int curIndex = ii; // 要插入的元素下标
                    for (int jj = ii - gap; jj >= 0; jj -= gap) { // 前面i个元素一一比较。
                        if (arr[curIndex] < arr[jj]) {
                            // swap
                            int tmp = arr[curIndex];
                            arr[curIndex] = arr[jj];
                            arr[jj] = tmp;
                            curIndex = jj; // 插入元素的下标发生了变化！！
                        } else {
                            break; // 跳出循环
                        }
                    }
                }
            }
            gap = gap / 2;   // 缩小增量
        }
    }


    /**
     * 归并排序。
     * （第一个达到nlogn的排序算法）
     * 思路：分治+递归。分成左右两个数组，分别排序，然后再进行二路归并。
     * <p>
     * 平均 最好 最坏
     * O(nlogn) O(nlogn) O(nlogn)
     * 空间复杂度 O(n) 最后一次merge时分配了result数组的长度为n。
     * 稳定
     *
     * @param arr
     */
    public int[] mergeSort(int[] arr) {
        // check input
        if (arr == null) return null;
        if (arr.length <= 1) return arr;

        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);
        int[] newleft = mergeSort(left);
        int[] newright = mergeSort(right);
        return merge(newleft, newright);
    }

    public int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        for (int i = 0, j = 0, index = 0; index < result.length; index++) {
            if (i >= left.length) {
                result[index] = right[j++];
            } else if (j >= right.length) {
                result[index] = left[i++];
            } else if (left[i] <= right[j]) {
                result[index] = left[i++];
            } else {
                result[index] = right[j++];
            }
        }
        return result;
    }


    /**
     * 快速排序。
     * (对比归并排序，快速排序需要的空间少一些。)
     * 思路：分治+递归。选一个基准元素，然后比它小的排左边，大的排右边，再分别对左右递归。
     * <p>
     * 平均 最好 最坏
     * O(nlogn) O(nlogn) O(n2)
     * 空间复杂度 O(logn) 递归栈的最大深度
     * 不稳定
     *
     * @param arr
     */
    public void quickSort(int[] arr, int b, int e) {
        // check input
        if (arr == null) return;
        if (e - b <= 1) return;

        int target = partition(arr, b, e);
        quickSort(arr, b, target);
        quickSort(arr, target + 1, e);
    }

    public int partition(int[] arr, int b, int e) {
        e--; // 指向最后一个元素
        int target = arr[b]; // 使用第一个元素作为基准。
        while (b < e) {
            // from right to left
            while (b < e && arr[e] >= target) e--;

            if (b < e) {
                swap(arr, b, e);
            }

            // from left to right
            while (b < e && arr[b] <= target) b++;

            if (b < e) {
                swap(arr, b, e);
            }
        }
        return b;
    }

    public void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    /**
     * 堆排序。
     * (注意：adjustHeap函数可以复用；adjustHeap不调整已经排好序的元素）
     * 思路：初始化堆，首尾交换，调整堆。
     * <p>
     * 平均 最好 最坏
     * O(nlogn) O(nlogn) O(nlogn)
     * 空间复杂度 O(1)
     * 不稳定
     *
     * @param arr
     */
    public void heapSort(int[] arr) {
        // check input
        if (arr == null) return;
        int len = arr.length;
        if (len <= 1) return;

        // 初始化堆
        initHeap(arr);

        // 首尾交换，调整堆
        for (int i = 0; i < len - 1; i++) {
            // swap
            swap(arr, 0, len - 1 - i);
            // adjust
            adjustHeap(arr, len - i - 1, 0);
        }
    }

    public void initHeap(int[] arr) {
        int len = arr.length;
        for (int i = len / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, len, i);
        }
    }

    public void adjustHeap(int[] arr, int len, int i) {
        // len为数组长度，已经排好序的不再进行调整
        //int len = arr.length;
        while (i <= len / 2 - 1) {
            // max child index
            int maxIndex = 2 * i + 1;
            if (2 * i + 2 < len) {
                if (arr[2 * i + 2] > arr[2 * i + 1]) {
                    maxIndex = 2 * i + 2;
                }
            }
            // compare max child with parent
            if (arr[i] >= arr[maxIndex]) {
                break; // 终止
            }
            // swap
            swap(arr, i, maxIndex);
            i = maxIndex;
        }
    }


    /**
     * 计数排序。
     * (全新思路，可以快到O(n)，本质是空间换时间。不支持小数和负数排序.
     * 主要缺点就是范围大时，浪费的存储空间太多了，遍历的次数太多了。
     * 适合场景：0～100的整数排序，范围有限，很快。）
     * 思路：分配一个大数组，把元素映射到数组下标。
     * <p>
     * 平均 最好 最坏
     * O(n+k) O(n) O(n+k)  k是最大值和最小值之间的范围
     * 空间复杂度 O(n+x)
     * 稳定
     *
     * @param arr
     */
    public int[] countingSort(int[] arr) {
        // check input
        if (arr == null) return arr;
        int len = arr.length;
        if (len <= 1) return arr;

        // max, min
        int max = arr[0];
        int min = arr[0];
        for (int x : arr) {
            if (x > max) max = x;
            if (x < min) min = x;
        }

        // 分配大数组, 并初始化为0
        int[] countArray = new int[max - min + 1];
        for (int i = 0; i < countArray.length; i++)
            countArray[i] = 0;

        // 映射
        for (int x : arr) {
            int index = x - min;
            countArray[index]++;
        }

        // 输出
        int[] newArr = new int[len];
        for (int i = 0, index = 0; i < countArray.length; i++) {
            for (int j = 0; j < countArray[i]; j++) {
                newArr[index++] = i + min;
            }
        }
        return newArr;
    }


    /**
     * 桶排序。
     * (计数排序的升级版，计数排序就是桶排序的特例，当每个桶的范围只有1时，就是计数排序。
     * 可以支持负数和小数排序，可以快到O(n)，本质是空间换时间。空间上优于计数排序，时间上略差。）
     * 应用场景：外部排序。
     * 假如我们有 10 GB 的订单数据需要按照金额进行排序，但内存只有几百 MB ，这时候该怎么办呢？
     * <p>
     * 思路：根据范围划分为M个桶，把元素映射到各个桶内，并排好序。
     * <p>
     * 平均 最好 最坏
     * O(n+nlog(n/m)) O(n) O(n+nlog(n/m)) m太小时，达不到线性，m很大时，可以达到线性O(n)
     * 空间复杂度 O(n+m)  m是桶的个数
     * 稳定
     *
     * @param arr
     */
    public int[] bucketSort(int[] arr, int bucketSize) {
        // check input
        if (arr == null) return arr;
        int len = arr.length;
        if (len <= 1) return arr;

        // max, min
        int max = arr[0];
        int min = arr[0];
        for (int x : arr) {
            if (x > max) max = x;
            if (x < min) min = x;
        }

        // 创建桶并初始化
        int bucketCount = (max - min) / bucketSize + 1;
        ArrayList<ArrayList<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i < bucketCount; i++) {
            buckets.add(new ArrayList<Integer>());
        }

        // 映射
        for (int x : arr) {
            int index = (x - min) / bucketSize;
            buckets.get(index).add(x);
        }

        // 排序桶内元素，并输出
        int[] result = new int[len];
        int index = 0;
        for (ArrayList<Integer> x : buckets) {
            if (x.size() > 0) {
                Collections.sort(x);  // 调用库排序，偷懒了
                for (Integer y : x) {
                    result[index++] = y;
                }
            }
        }
        return result;
    }

    /**
     * 基数排序。
     * （场景：10w个手机号码排序，不适合计数和桶排序。当k不大时，就可以接近线性O(n)）
     * 思路：从低位到高位+计数排序，固定10个桶
     * <p>
     * 平均 最好 最坏
     * O(n*k) O(n*k) O(n*k)  k是最大的位数
     * 空间复杂度。O(n+10)
     * 稳定。
     *
     * @param arr
     */
    public int[] radixSort(int[] arr) {
        // check input
        if (arr == null) return arr;
        int len = arr.length;
        if (len <= 1) return arr;

        // 找到最大位数
        int max = arr[0];
        for (int x : arr) {
            if (x > max) max = x;
        }
        int maxBits = 0;
        while (max > 0) {
            max /= 10;
            maxBits++;
        }

        // 从低位开始，排maxBits趟序。
        int[] result = Arrays.copyOf(arr, len);
        for (int i = 0; i < maxBits; i++) {
            // 创建10个桶并初始化
            ArrayList<ArrayList<Integer>> buckets = new ArrayList<>();
            for (int j = 0; j < 10; j++) {
                buckets.add(new ArrayList<Integer>());
            }
            for (int x : result) {
                // 取第i位
                int v = getBitValue(x, i);
                buckets.get(v).add(x);
            }
            // 输出
            int index = 0;
            for (ArrayList<Integer> x : buckets) {
                for (int y : x) {
                    result[index++] = y;
                }
            }
        }
        return result;
    }

    public int getBitValue(int x, int i) {
        while (i > 0) {
            x /= 10;
            i--;
        }
        return x % 10;
    }

    public void printArray(int[] arr) {
        for (int x : arr) {
            System.out.printf("%d ", x);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Sort t = new Sort();

        int[] arr = {5, 7, 1, 3, 4, 6, 5};
        //t.bubbleSort(arr);
        //t.selectionSort(arr);
        //t.insertionSort(arr);
        //t.shellSort(arr);
        //arr = t.mergeSort(arr);
        //t.quickSort(arr, 0, arr.length);
        //t.heapSort(arr);
        //arr = t.countingSort(arr);
        //arr = t.bucketSort(arr, 3);
        arr = t.radixSort(arr);
        t.printArray(arr);
    }
}
