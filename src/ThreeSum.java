import java.util.*;

/**
 * #15
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */
public class ThreeSum {
    public static void main(String args[]) {
        System.out.println(threeSum(new int[]{-7, 2, 1, 10, 9, -10, -5, 4, 13, -9, -4, 6, 11, -12, -6, -9, -6, -9, -11, -4, 10, 10, -3, -1, -4, -7, -12, -15, 11, 5, 14, 11, -7, -8, 6, 9, -2, 9, -10, -12, -15, 2, 10, 4, 5, 11, 10, 6, -13, 6, -13, 12, -7, -9, -12, 4, -9, 13, -4, 10, 4, -12, 6, 4, -5, -10, -2, 0, 14, 4, 4, 6, 13, -9, -5, -5, -13, 12, -14, 11, 3, 10, 8, 11, -13, 4, -8, -7, 2, 4, 10, 13, 7, 2, 2, 9, -1, 8, -5, -10, -3, 6, 3, -5, 12, 6, -3, 6, 3, -2, 2, 14, -7, -13, 10, -13, -2, -12, -4, 8, -1, 13, 6, -9, 0, -14, -15, 6, 9}));
    }

    // 第一次 超时
    public static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> inner = new ArrayList<>();
            inner.add(nums[i]);
            int sum = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                inner.add(nums[j]);
                sum += nums[j];
                for (int k = j + 1; k < nums.length; k++) {
                    sum += nums[k];
                    if (sum == 0) {
                        inner.add(nums[k]);
                        List<Integer> innerCopy = new ArrayList<>();
                        for (int integer : inner) {
                            innerCopy.add(integer);
                        }
                        Collections.sort(innerCopy);
                        set.add(innerCopy);
                        inner.remove(inner.size() - 1);
                    }
                    sum -= nums[k];
                }
                inner.remove(inner.size() - 1);
                sum -= nums[j];
            }
        }
        ArrayList list = new ArrayList();
        list.addAll(set);
        return list;
    }
}
