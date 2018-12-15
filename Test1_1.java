import java.util.*;

/**
 * cc150习题。
 * 1.1 实现一个算法，确定一个字符串的所有字符是否全都不同。假设不允许使用额外的数据结构又该如何处理?
 * complexity: HasDuplicatedChar O(n) O(n)  HasDuplicatedCharV2 O(n2) 0(1)
 *
 * @author wil
 * @version 1.1
 */
public class Test1_1 {
    public static void main(String[] args) {
        Test1_1 obj = new Test1_1();
        // test cases
        String[] testCases = {
                null,
                "abc",
                "abc1213a",
                "哈罗",
                "哈哈",
        };
        for (String s: testCases) {
            //boolean result = obj.hasDuplicatedChar(s);
            boolean result = obj.hasDuplicatedCharV2(s);
            System.out.printf("input:%s, output:%s\n", s, result);
        }
    }

    /**
     * 使用hashset去重。
     * @param s
     * @return
     */
    public boolean hasDuplicatedChar(String s) {
        if (s == null) {
            return false;
        }
        HashSet<Character> hset = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (hset.contains(c)) {
                return true;
            }
            hset.add(c);
        }
        return false;
    }

    /**
     * 不借助额外数据结构，采用遍历比较方法。
     * @param s
     * @return
     */
    public boolean hasDuplicatedCharV2(String s) {
        if (s == null) {
            return false;
        }
        int len = s.length();
        for (int i = 0; i < len; i++) {
            for (int j = i+1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    return true;
                }
            }
        }
        return false;
    }
}
