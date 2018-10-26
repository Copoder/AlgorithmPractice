import java.util.ArrayList;
import java.util.List;

/**
 * #4
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2 。
 * <p>
 * 请找出这两个有序数组的中位数。要求算法的时间复杂度为 O(log (m+n)) 。
 * <p>
 * 你可以假设 nums1 和 nums2 不同时为空。
 * <p>
 * 示例 1:
 * <p>
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * 中位数是 2.0
 * 示例 2:
 * <p>
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * 中位数是 (2 + 3)/2 = 2.5
 */
public class FindMedian {
    public static void main(String args[]) {
        int[] a = {1, 2};
        int[] b = {3, 4};
        System.out.println(findMedianSortedArrays(a, b));
    }

    //fixme 时间复杂度优化

    /**
     * 思路： 将两个数组合并成一个,通过排序算法后再取中位数
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < nums1.length + nums2.length; i++) {
            if (i < nums1.length) {
                integers.add(nums1[i]);
            } else {
                integers.add(nums2[i - nums1.length]);
            }
        }
        Object[] a = integers.toArray();
        //shell sort
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if ((int) a[j] < (int) a[i]) {
                    int swap = (int) a[j];
                    a[j] = a[i];
                    a[i] = swap;
                }
            }
        }
        if (a.length % 2 == 0) {
            return (double) ((int) a[a.length / 2 - 1] + (int) a[a.length / 2]) / 2;
        } else {
            return (double) (int) a[(a.length / 2)];
        }
    }
}
