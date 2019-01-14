public class T1_4 {
    public void replace(char[] arr, int e) {
        // check
        if (arr.length <= 0) return;

        // 扫描一遍，计算多少个空格，数组的末位坐标
        int spaceCount = 0;
        for (char x : arr) {
            if (x == ' ') {
                spaceCount++;
            }
        }
        int last = e + 2 * spaceCount;

        // 从后往前进行复制，如果是空格，复制为%20，否则直接复制字符。
        for (int i = e; i >= 0; i--) {
            if (arr[i] == ' ') {
                arr[last--] = '0';
                arr[last--] = '2';
                arr[last--] = '%';
            } else {
                arr[last--] = arr[i];
            }
        }
    }

    public static void main(String[] args) {
        T1_4 t = new T1_4();
        char[] arr = {'w', 'i', 'l', ' ', 'z', ' ', '\0', '\0', '\0', '\0', '\0'};
        t.replace(arr, 5);
        for (char x: arr) {
            System.out.printf("%c", x);
        }
    }
}
