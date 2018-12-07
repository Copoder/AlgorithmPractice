/**
 * #28
 * 实现 strStr() 函数。
 * <p>
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 */
public class Strstr {
    public static void main(String args[]) {
        System.out.println(strStr("mississippi", "ississi"));
    }

    public static int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        if (needle.length() > haystack.length()) return -1;
        char[] h = haystack.toCharArray();
        char[] n = needle.toCharArray();
        int idx = 0;
        while (idx < h.length) {
            if (h[idx] == n[0]) {
                for (int j = 0; j < n.length && idx + j < h.length; j++) {
                    if (h[idx + j] != n[j]) {
                        break;
                    }
                    if (j == n.length - 1) {
                        return idx;
                    }
                }
            }
            idx++;
        }
        return -1;
    }
}
