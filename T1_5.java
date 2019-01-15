import java.util.HashSet;

public class T1_5 {
    /**
     * time: O(n)  n为字符串的长度
     * space: O(m) m为压缩字符串的长度
     */
    public String compress(String s) {
        // check
        if (s == null) return s;
        if (s.length() <= 2) return s;

        char lastChar = s.charAt(0);
        int count = 1;
        StringBuffer sb = new StringBuffer();
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == lastChar) {
                count++;
            } else {
                sb.append(lastChar);
                sb.append(count);
                count = 1;
                lastChar = c;
            }
        }
        // 加上结尾元素
        sb.append(lastChar);
        sb.append(count);

        String newStr = sb.toString();
        if (newStr.length() < s.length())
            return newStr;
        else
            return s;

    }

    public static void main(String[] args) {
        T1_5 t = new T1_5();
        String s = "aabcccccaaa";
        String newStr = t.compress(s);
        System.out.println(newStr);
    }

}
