/**
 * 5.1 给定两个32位整数n和m，以及表示比特位置的i和j。编写一个方法，将m插入n，使得从n的第j位开始，到第i位结束。假定从
 * j位到i位足以容纳m，也即若m=10011，那么j和i之间至少可容纳5个位。
 *
 * 思路：
 * 1 清除n中从i到j的位
 * 2 m左移i位，与n对齐
 * 3 m与你做或运算。
 *
 * 犯错：
 * 清除位的时候使用循环，效率低下，应该使用mask掩码。
 * (1 << i) - 1 注意加上括号，位运算符优先级很低。
 */
public class T5_1 {
    public int insertMToN(int m, int n, int i, int j) {
        if (i>=j) return n;

        // mask
        int allOne = ~0;
        int pre_mask = allOne << (j+1);
        System.out.println(Integer.toBinaryString(pre_mask));
        int suffix_mask = (1 << i) - 1;
        System.out.println(Integer.toBinaryString(suffix_mask));
        int mask = pre_mask | suffix_mask;
        System.out.println(Integer.toBinaryString(mask));

        // clear n
        int newn = n & mask;
        System.out.println("newn:"+Integer.toBinaryString(newn));

        // shift m
        int newm = m << i;
        System.out.println("newm:"+Integer.toBinaryString(newm));

        int result = newn | newm;
        return result;
    }

    public static void main(String[] args) {
        T5_1 t = new T5_1();
        int result = t.insertMToN(19,1 << 10, 2, 6);
        System.out.println(result);
        System.out.println(Integer.toBinaryString(result));
    }
}
