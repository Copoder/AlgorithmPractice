import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * #39
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的数字可以无限制重复被选取。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1:
 * <p>
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 * [7],
 * [2,2,3]
 * ]
 * 示例 2:
 * <p>
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [
 * [2,2,2,2],
 * [2,3,3],
 * [3,5]
 * ]
 */
public class CombinationSum {
    public static void main(String args[]) {
        int[] a = {2, 3, 5, 4};
        System.out.println(combinationSum2(a, 7));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List list = new ArrayList();
        for (int i = 0; i < candidates.length; i++) {
            for (int j = i + 1; j < candidates.length; j++) {
                if (candidates[j] < candidates[i]) {
                    int swap = candidates[j];
                    candidates[j] = candidates[i];
                    candidates[i] = swap;
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < candidates.length; i++) {
            if (candidates[i] > target) break;
            List<Integer> il = new ArrayList();
            for (int j = i; j < candidates.length; j++) {
                il.clear();
                il.add(candidates[i]);
                sum = candidates[i];
                while (sum < target) {
                    sum += candidates[j];
                    if (sum < target) il.add(candidates[j]);
                    if (sum == target) list.add(il);
                }
            }
        }
        return list;
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        findanswer(0, new ArrayList<Integer>(), candidates, target, result);
        return result;

    }

    public static void findanswer(int index, List<Integer> ans, int[] candidates, int target, List<List<Integer>> result) {
        while (index < candidates.length && candidates[index] <= target) {
            //添加该数，并更新target
            if (candidates[index] <= target / 2) {
                List<Integer> l1 = new ArrayList<Integer>(ans);
                l1.add(candidates[index]);
                findanswer(index, l1, candidates, target - candidates[index], result);
            }
            //找到满足条件的，更新list，并添加到result中
            if (candidates[index] == target) {
                List<Integer> l1 = new ArrayList<Integer>(ans);
                l1.add(candidates[index]);
                result.add(l1);
            }
            index++;
        }
    }

}
