
/**
 * #1
 * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
 * <p>
 * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
 * <p>
 * 示例:
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class TwoSum {
    public static void main(String args[]) {
        test();
    }

    private static int[] twoSum(int[] arr, int target) {
        int[] result = new int[2];
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target) {
                    result[0] = arr[i];
                    result[1] = arr[j];
                }
            }
        }
        return result;
    }

    private static void test() {
        int[] a = {1, 2, 3, 4, 5};
        int[] ints = twoSum(a, 8);
        if (ints.length == 2) {
            System.out.println("success!");
            for (int i : ints) {
                System.out.println(i);
            }
        } else {
            System.out.println("failed");
        }
    }
}
