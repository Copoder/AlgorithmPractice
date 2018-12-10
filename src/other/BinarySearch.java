package other;

/**
 * 二分法
 */
public class BinarySearch {
    public static void main(String args[]) {
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(binarySearch(arr, 6));
    }

    public static int binarySearch(int[] arr, int target) {
        int l = 0, r = arr.length - 1;
        int mid = (l + r) / 2;
        while (l < r) {
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                l = mid;
            } else {
                r = mid;
            }
            mid = (l + r) / 2;
        }
        return -1;
    }
}
