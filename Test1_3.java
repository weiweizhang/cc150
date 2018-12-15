import java.util.*;

/**
 * 1.3 给定两个字符串，请编写程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
 */
public class Test1_3 {
    public static void main(String[] args) {
        Test1_3 t = new Test1_3();

        String s1 = "abc12";
        String s2 = "12abc";
        //boolean result = t.canBeSame(s1, s2);
        boolean result = t.canBeSameV2(s1, s2);
        System.out.printf("input:s1:%s,s2:%s,output:%b", s1, s2, result);
    }

    /**
     * 思路：统计每个字符出现个数，完全相等则是。 * O(n) O(n)
     * @param s1
     * @param s2
     * @return
     */
    public boolean canBeSame(String s1, String s2) {
        // check input
        if (s1 == null || s2 == null) {
            return false;
        }
        if (s1.equals(s2)) {
            return true;
        }
        if (s1.length() != s2.length()) {
            return false;
        }
        // 统计字符次数
        HashMap<Character, Integer> s1Map = countChar(s1);
        HashMap<Character, Integer> s2Map = countChar(s2);
        // 比较两个字符串的字符次数是否全部相等
        if (s1Map.size() != s2Map.size()) {
            return false;
        }
        for (char c: s1Map.keySet()) {
            if (s1Map.get(c) != s2Map.get(c)) {
                return false;
            }
        }
        return true;
    }

    public HashMap<Character, Integer> countChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                int count = map.get(c);
                map.put(c, count + 1);
            } else {
                map.put(c, 1);
            }
        }
        return map;
    }

    /**
     * 思路：先排序，然后判断是否相等。
     * O(logn) O(1)
     */
    public boolean canBeSameV2(String s1, String s2) {
        // check input
        // the same as above
        char[] s1array = s1.toCharArray();
        char[] s2array = s2.toCharArray();
        Arrays.sort(s1array);
        Arrays.sort(s2array);
        return new String(s1array).equals(new String(s2array));
    }
}
