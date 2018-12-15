/**
 * 用C实现void reverse(char* str)函数，反转一个null结尾的字符串。
 * 思路：首先得到str长度，然后首尾交换字符，直到中间相遇。
 * complexity: O(n) O(1)
 */
public class Test1_2 {
    public static void main(String[] args) {
        Test1_2 c = new Test1_2();
        String[] testCases = {"abc", "a", ""};
        for (String s: testCases) {
            String result = c.reverse(s);
            System.out.printf("input:%s, output:%s\n", s, result);
        }
    }

    /**
     *
     * @param s
     */
    public String reverse(String s) {
        StringBuffer news = new StringBuffer();
        for (int i = s.length() - 1; i >= 0; i--) {
            news.append(s.charAt(i));
        }
        return news.toString();
    }
}
