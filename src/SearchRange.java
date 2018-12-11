import java.util.Arrays;

/**
 * #34
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 如果数组中不存在目标值，返回 [-1, -1]。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 */
public class SearchRange {
    public static void main(String args[]) {
        int[] arr = new int[]{2};
        System.out.println(Arrays.toString(searchRange3(arr, 2)));
    }

    public static int[] searchRange3(int[] arr, int tgt) {
        int l = -1, r = -1, hd = 0, ft = arr.length - 1, mid = (hd + ft) / 2, hit = -1;
        while (hd <= ft) {
            if (arr[mid] == tgt) {
                hit = mid;
                l = mid;
                r = mid;
                break;
            } else if (arr[mid] < tgt) {
                hd = mid + 1;
            } else {
                ft = mid - 1;
            }
            mid = (hd + ft) / 2;
        }
        int step = 0;
        if (hit != -1) {
            while (mid - step >= 0) {
                if (arr[mid - step] == tgt) {
                    l = mid - step;
                } else {
                    break;
                }
                step++;
            }
            step = 0;
            while (mid + step < arr.length) {
                if (arr[mid + step] == tgt) {
                    r = mid + step;
                } else {
                    break;
                }
                step++;
            }
        }
        return new int[]{l, r};
    }
}
