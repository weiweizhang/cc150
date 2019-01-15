public class T1_8 {
    /**
     * time: O(1)
     */
    public boolean canRotate(String s1, String s2) {
        // check
        if (s1 == null || s2 == null) return false;
        if (s1.length() == 0 || s2.length() == 0) return false;
        if (s1.length() != s2.length()) return false;
        if (s1.equals(s2)) return true;

        String s1s1 = s1 + s1;
        return s1s1.contains(s2);
    }

    public static void main(String[] args) {
        T1_8 t = new T1_8();
        String s1 = "waterbottle";
        String s2 = "terbottlewa";
        boolean result = t.canRotate(s1, s2);
        System.out.println(result);
    }

}
