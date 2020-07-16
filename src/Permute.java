import java.util.ArrayList;
import java.util.List;

/**
 * #46
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 */
public class Permute {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int[] numsCopy = nums.clone();

        for(int i = 0;i<nums.length;i++){
            nums = numsCopy;
            result.add(new ArrayList<>());
            for(int j = 0;j<nums.length;j++){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                result.get(i).add(nums[j]);
            }
        }
        return result;
    }
}
