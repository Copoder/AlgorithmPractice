import java.util.ArrayList;
import java.util.List;

/**
 * #3
 * 给定一个字符串，找出不含有重复字符的最长子串的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 无重复字符的最长子串是 "abc"，其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 无重复字符的最长子串是 "b"，其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 无重复字符的最长子串是 "wke"，其长度为 3。
 * 请注意，答案必须是一个子串，"pwke" 是一个子序列 而不是子串。
 */
public class NoRepeatString {
    public static void main(String args[]) {
        System.out.println(getNoRepeatString("bbbbb"));
    }


    //fixme 第一次
    /**
     * 思路： 逐个校验字符,对比与之前的字符有无重复,
     * 若有重复,设置截取的尾部为当前位置+1,新的头部
     * 为当前位置
     * 将所有截取到无重复的字符串都添加到列表里,遍历列表
     * 里length最大的元素返回
     *
     * @param str
     * @return
     */
    public static String getNoRepeatString(String str) {
        List<String> subStrings = new ArrayList<>();
        char[] chars = str.toCharArray();
        List<String> checkedChar = new ArrayList<>();
        int headIndex = 0;
        int endingIndex = 0;
        for (int i = 0; i < str.length(); i++) {
            for (String s : checkedChar) {
                if (s.equals(String.valueOf(chars[i]))) {
                    //有重复
                    endingIndex = i;
                    subStrings.add(str.substring(headIndex, endingIndex));
                    headIndex = i;
                }
            }
            checkedChar.add(String.valueOf(chars[i]));
        }
        int maxIndex = 0;
        for (int i = 0; i < subStrings.size(); i++) {
            if (subStrings.get(i).length() > subStrings.get(maxIndex).length()) {
                maxIndex = i;
            }
        }
        return subStrings.get(maxIndex);
    }

}
