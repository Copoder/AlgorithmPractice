/**
 * #14 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 * <p>
 * 所有输入只包含小写字母 a-z 。
 */
public class LongestCommonPrefix {
    public static void main(String args[]) {
        System.out.println(longestCommonPrefix(new String[]{}));
    }

    //第一次
    public static String longestCommonPrefix(String[] args) {
        StringBuilder sb = new StringBuilder("");
        if(args.length <= 0) return "";
        int ml = args[0].length();
        for (int i = 0; i < args.length; i++) {
            if (args[i].length() < ml) {
                ml = args[i].length();
            }
        }

        for (int i = 0; i < ml; i++) {
            char cur = args[0].charAt(i);
            boolean isBreak = false;
            for (int j = 1; j < args.length; j++) {
                if (args[j].charAt(i) == cur) continue;
                isBreak = true;
            }
            if (isBreak) break;
            sb.append(cur);
        }
        return sb.toString();
    }
}
