import java.util.HashSet;

public class T1_6 {
    /**
     * 思路；一层一层旋转，交换元素。
     * time: O(n2)  每个元素都要移动一次
     * space: O(1)
     *
     * @param matrix
     */
    public void rotate(int[][] matrix, int n) {
        // check
        if (matrix == null) return;
        if (matrix.length <= 1) return;

        for (int i = 0; i < n / 2; i++) {  // 每层
            for (int j = i; j < n - 1 - i; j++) { // 每列
                // top
                int top = matrix[i][j];
                // left=>top
                matrix[i][j] = matrix[n - j - 1][i];
                // bottom=>left
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                // right=>bottom
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                // top=>right
                matrix[j][n - i - 1] = top;
            }

        }
    }

    void printMatrix(int[][] m) {
        // print
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                System.out.printf("%d ", m[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        T1_6 t = new T1_6();
        int[][] m = {{1, 2, 3, 4}, {4, 5, 6, 7}, {8, 9, 1, 3}, {5, 6, 7, 8}};
        t.printMatrix(m);
        System.out.println();
        t.rotate(m, 4);
        t.printMatrix(m);
    }

}
