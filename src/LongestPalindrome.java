import java.util.ArrayList;
import java.util.List;

/**
 * #5
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba"也是一个有效答案。
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 */
public class LongestPalindrome {
    public static void main(String args[]) {
        String testString = "abcabba";
        System.out.println(longestPalindrome(testString));
    }

    public static String longestPalindrome(String str) {
        List<String> palindromes = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            StringBuffer strings = new StringBuffer();
            strings.append(str.substring(i, i + 1));
            for (int j = i + 1; j < str.length(); j++) {
                strings.append(str.substring(j, j + 1));
                boolean isPalindromes = true;
                char[] chars = strings.toString().toCharArray();
                //判断是否为回文
                for (int x = 0; x < chars.length; x++) {
                    if (chars[x] != chars[chars.length - x - 1]) {
                        isPalindromes = false;
                        break;
                    }
                }
                if (isPalindromes && strings.length() > 0) palindromes.add(strings.toString());
            }
        }
        if (palindromes.size() > 0) {
            int maxIndex = 0;
            for (int i = 0; i < palindromes.size(); i++) {
                if (palindromes.get(i).length() > palindromes.get(maxIndex).length()) {
                    maxIndex = i;
                }
            }
            return palindromes.get(maxIndex);
        } else {
            return "";
        }
    }
}
