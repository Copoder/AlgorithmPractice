import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * #56 给出一个区间的集合，请合并所有重叠的区间。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 * <p>
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 */
public class MergeIntercals {
    public static void main(String args[]) {
        int[][] arr = new int[][]{{1, 3}, {2, 6}, {100, 150}, {0, 8}};
        System.out.println(Arrays.deepToString(merge(arr)));
    }

    //fixme 第一次
    public static int[][] merge(int[][] intervals) {
        int step;
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            for (int j = i + 1; j < intervals.length; j++) {
                if(intervals[i][0]>intervals[j][0]){
                    int[] temp = intervals[i];
                    intervals[i] = intervals[j];
                    intervals[j] = temp;
                }
            }
        }
        for (int i = 0; i < intervals.length; i += step) {
            step = 1;
            int[] cur = intervals[i];
            for (int j = i + 1; j < intervals.length; j++) {
                int[] target = intervals[j];
                if ((cur[1] >= target[0] && cur[1] <= target[1]) ||
                        (target[1] >= cur[0] && target[1] <= cur[1])) {
                    cur = new int[]{Math.min(cur[0], target[0]),
                            Math.max(cur[1], target[1])};
                    step++;
                } else {
                    break;
                }
            }
            list.add(cur);
        }
        int[][] result = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
