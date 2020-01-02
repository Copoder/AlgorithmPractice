import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * #49
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * <p>
 * 示例:
 * <p>
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 */
public class GroupAnagrams {
    public static void main(String args[]) {
        List<List<String>> lists = groupAnagrams(new String[]{"aat", "taa", "tan", "ate", "nat", "bat"});
        for (List<String> list : lists) {
            System.out.println(list);
        }
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            String sort = sort(s);
            if (map.get(sort) == null) {
                map.put(sort, new ArrayList<>());
                result.add(map.get(sort));
            }
            map.get(sort).add(s);
        }

        return result;
    }

    public static String sort(String s) {
        char[] chars = s.toCharArray();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < chars.length; i++) {
            char minChar = chars[i];
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[j] < minChar) {
                    char temp = chars[i];
                    chars[i] = chars[j];
                    chars[j] = temp;
                    minChar = chars[i];
                }
            }
            sb.append(minChar);
        }
        return sb.toString();
    }
}
