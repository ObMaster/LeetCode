package algorithm.search;

import java.util.Arrays;

/**
 * @author OMaster
 * @date 2021/7/29
 */
public class SearchAlgorithm {

    /**
     * 01——二分查找算法
     * @param a
     * @param target
     */
    public static int erFenSearch(int[] a, int target) {
        if (a == null)  return -1;
        Arrays.sort(a);
        return search(a, target, 0, a.length - 1);
    }

    /**
     * 递归查找
     * @param a
     * @param target
     * @param left
     * @param right
     * @return
     */
    private static int recursionSearch(int[]a, int target, int left, int right) {
        if (left > right)  return -1;
        int mid = left +  (right - left) / 2;
        if (a[mid] == target)   return mid;
        if (a[mid] > target)
            return recursionSearch(a, target, left, mid - 1);
        else
            return recursionSearch(a, target, mid + 1, right);
    }

    /**
     * 非递归查找
     * @param a
     * @param target
     * @param left
     * @param right
     * @return
     */
    private static int search(int[] a, int target, int left, int right) {
        while (left <= right){
            int mid = left +  (right - left) / 2;
            if (a[mid] == target)   return mid;
            if (a[mid] > target) right = mid - 1;
            else left = mid + 1;
        }
        return -1;
    }
}
