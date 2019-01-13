import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

/**
 * 11.2
 * 方法一：重写compare函数，把每个字符串先排序，然后比较，然后快速排序。
 * 方法二：比较巧妙，利用hash，把同样的字符串映射到一个桶里面。 O(n).
 */
public class T11_2 {
    public void sortWords(String[] arr) {
        // 把每个字符串映射到hashmap中。
        HashMap<String, ArrayList<String>> hm = new HashMap<>();
        for (String x : arr) {
            String s = sortString(x);
            if (!hm.containsKey(s)) {
                hm.put(s, new ArrayList<String>());
            }
            hm.get(s).add(x);
        }
        // 输出hashmap中的所以字符串
        int index = 0;
        for (String x : hm.keySet()) {
            for (String y : hm.get(x)) {
                arr[index++] = y;
            }
        }
    }

    public String sortString(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }

    public static void main(String[] args) {
        T11_2 t = new T11_2();
        String[] a = {"a", "abc", "bac", "a", "cba", "acb", "bba", "abb", "adfasfdsfsa"};
        t.sortWords(a);
        for (String x : a) {
            System.out.printf("%s ", x);
        }
    }
}
