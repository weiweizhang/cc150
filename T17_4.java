public class T17_4 {
    public int max(int a, int b) {
        int i = calcSign(a - b);   // 计算a-b的正负号，正返回1，负返回0
        int j = oppo(i);   // 取反， 1=>0 0=>1
        return i * a + j * b;  // i和j中有一个是1，另一个是0
    }

    int calcSign(int n) {
        int r = (n >> 31 & 1);
        return oppo(r);
    }

    int oppo(int n) {
        return 1 ^ n;
    }

    public static void main(String[] args) {
        T17_4 t = new T17_4();
        int r = t.max(10, 100);
        System.out.println(r);
    }
}
