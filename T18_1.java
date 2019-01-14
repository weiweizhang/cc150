/**
 * 思路：不使用运算符，那么只能用位运算。把每位相加。
 * 方法一：int整数32位，每位相加，如果有进位，那么继续相加。
 * 方法二：相加和进位分开算，递归实现，比较巧妙。
 */
public class T18_1 {
    public int add(int a, int b) {
        if (b==0) return a; // 递归退出条件

        int sum = a^b; // 相加不进位
        int carry = (a&b)<<1; // 进位
        return add(sum, carry);
    }

    public static void main(String[] args) {
        T18_1 t = new T18_1();
        int result = t.add(5,-70);
        System.out.println(result);
    }
}
