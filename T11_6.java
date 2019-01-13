import java.util.ArrayList;

/**
 * 11.6
 * <p>
 * 1 遍历每行，找出范围满足条件的行。
 * 2 对每行，二分查找
 * <p>
 * O(m+m*logn)  m行数，n列数。
 */
class Coodinate {
    public int i;
    public int j;

    public Coodinate(int i, int j) {
        this.i = i;
        this.j = j;
    }
}

public class T11_6 {
    public Coodinate search(int[][] arr, int x) {
        if (arr.length == 0) return new Coodinate(-1, -1);

        // 扫描行
        ArrayList<Integer> rowlist = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (x >= arr[i][0] && x <= arr[i][arr[i].length - 1]) {
                rowlist.add(i);
            }
        }
        //System.out.println(rowlist.toString());

        // 二分查找
        BinarySearch bs = new BinarySearch();
        for (int i : rowlist) {
            //System.out.printf("arr:%s, x:%d, b:%d, e:%d\n", printArray(arr[i]), x, 0, arr[i].length - 1);
            int j = bs.binarySearch(arr[i], x, 0, arr[i].length - 1);
            if (j != -1) {
                return new Coodinate(i, j);
            }
        }
        return new Coodinate(-1, -1);
    }

    public String printArray(int[] a) {
        String result = "";
        for (int x: a) {
            result += x + " ";
        }
        return result;
    }

    public static void main(String[] args) {
        T11_6 t = new T11_6();
        int[][] a = {
                {1, 2, 2, 13},
                {2, 2, 3, 16},
                {5, 6, 7, 17},
        };
        Coodinate result = t.search(a, 7);
        System.out.printf("%d,%d", result.i, result.j);
    }
}
