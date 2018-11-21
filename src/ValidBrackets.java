import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "()"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 * <p>
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 * <p>
 * 输入: "{[]}"
 * 输出: true
 */
public class ValidBrackets {
    public static void main(String args[]) {
        System.out.println(String.valueOf(isValid("")));
    }

    public static boolean isValid(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.put("(", 1);
        map.put(")", 2);
        map.put("[", 4);
        map.put("]", 5);
        map.put("{", 7);
        map.put("}", 8);
        map.put(" ", 0);
        boolean valid = false;
        char[] chars = s.toCharArray();
        if(chars.length == 0) return true;
        if (chars.length < 2 || (chars.length > 2 && chars.length % 2 != 0)) return false;
        for (int i = 0; i < chars.length / 2; i++) {
            Integer l = map.get(String.valueOf(chars[i]));
            Integer r = map.get(String.valueOf(chars[chars.length - i - 1]));
            valid = (l != null && r != null && r - l == 1) || (l == 0 && r == 0);
            if (!valid) {
                break;
            }
        }
        if (!valid) {
            for (int i = 0; i < chars.length - 1; i += 2) {
                Integer l = map.get(String.valueOf(chars[i]));
                Integer r = map.get(String.valueOf(chars[i + 1]));
                if (r - l != 1) return false;
            }
        }
        return true;
    }
}
