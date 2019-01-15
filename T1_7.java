import java.util.HashSet;

public class T1_7 {
    /**
     * time: O(m*n)
     * space: O(x) x为含0的行数+列数。
     * @param matrix
     */
    public void clear(int[][] matrix) {
        // check
        if (matrix == null) return;
        if (matrix.length == 0) return;

        // 第一次遍历，记录哪些行和列 含有0。
        HashSet<Integer> rowHs = new HashSet<>();
        HashSet<Integer> colHs = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    rowHs.add(i);
                    colHs.add(j);
                }
            }
        }

        // 第二次遍历，清零行和列
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (rowHs.contains(i) || colHs.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }

    }

    public static void main(String[] args) {
        T1_7 t = new T1_7();
        int[][] m = {{1,2,4},{3,5,0},{4,5,6}};
        t.clear(m);
        // print
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                System.out.printf("%d ", m[i][j]);
            }
            System.out.println();
        }
    }

}
