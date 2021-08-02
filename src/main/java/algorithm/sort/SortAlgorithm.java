package algorithm.sort;

/**
 * @author OMaster
 * @date 2021/7/21
 */
public class SortAlgorithm {

    /**
     * 01——冒泡排序（稳定）
     *  时间复杂度：O(n2)
     *  空间复杂度：O(1)
     * @param arr
     */
    public static void maoPaoSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    swap(arr, i, j);
                }
            }
        }
    }

    /**
     * 02——简单选择排序（不稳定）
     *  时间复杂度：O(n2)
     *  空间复杂度：O(1)
     * @param arr
     */
    public static void SimpleSelectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            if (min != i)   swap(arr, i, min);
        }
    }

    /**
     * 03——插入排序（稳定）
     *  时间复杂度：O(n2)
     *  空间复杂度：O(1)
     * @param arr
     */
    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int cur = arr[i];
            int j = i;
            while (j > 0 && cur < arr[j - 1]) {
                //arr[j] = arr[j - 1];
                //j--;
                arr[j] = arr[--j];
            }
            arr[j] = cur;
        }
    }

    /**
     * 04——归并排序（稳定）
     *  时间复杂度：O(nlogn)
     *  空间复杂度：O(n)
     * @param arr
     */
    public static void mergeSort(int[] arr) {
        int[] temp = new int[arr.length];
        mSort(arr, temp, 0, arr.length - 1);
    }

    private static void mSort(int[] arr, int[] temp, int begin, int end) {
        if (begin >= end)   return;
        int mid = (begin + end) / 2;
        mSort(arr, temp, begin, mid);
        mSort(arr, temp,mid + 1, end);
        mergeSortedArray(arr, temp, begin, mid, end);
    }

    private static void mergeSortedArray(int[] arr, int[] temp, int begin, int middle, int end) {
        int i = begin;
        int j = middle + 1;
        int x = 0;
        while (i <= middle && j <= end) {
            temp[x++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }
        while (i <= middle) {
            temp[x++] = arr[i++];
        }
        while (j <= end) {
            temp[x++] = arr[j++];
        }

        for (i = 0; i < x; ++i) {
            arr[begin + i] = temp[i];
        }
    }


    /**
     * 05——快速排序（不稳定）
     *  时间复杂度：O(nlogn)
     *  空间复杂度：O(1)
     * @param arr
     */
    public static void quickSort(int[] arr) {
        qSort(arr, 0, arr.length - 1);
    }

    private static void qSort(int[] arr, int begin, int end) {
        if (begin >= end)   return;
        int cur = arr[begin];
        int i = begin;
        int j = end;
        while (i < j) {
            while (j > i && arr[j] > cur)    j--;
            if (j > i)  arr[i++] = arr[j];
            while (i < j && arr[i] < cur)   i++;
            if (i < j)  arr[j--] = arr[i];
        }
        arr[i] = cur;
        qSort(arr, begin, i - 1);
        qSort(arr, i + 1, end);
    }


    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
