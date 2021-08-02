package algorithm.sort;

/**
 * 降序排序
 * @author OMaster
 * @date 2021/8/1
 */
public class Sort2 {

    public static void maoPao(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] < a[j])
                    SortAlgorithm.swap(a, i, j);
            }
        }
    }

    public static void xuanZe(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int max = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[max] < a[j])
                    max = j;
            }
            if (max != i)  SortAlgorithm.swap(a, i, max);
        }
    }

    public static void chaRu(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int tem = a[i];
            int j = i;
            while (j > 0 && tem > a[j - 1]) {
                a[j] = a[--j];
            }
            a[j] = tem;
        }
    }

    public static void guiBing(int[] a) {
        int[] temp = new int[a.length];
        erLu(a, temp, 0, a.length - 1);
    }

    public static void erLu(int[] a, int[] temp, int left, int right) {
        if (left >= right)   return;
        int mid = left + (right - left) / 2;
        erLu(a, temp, left, mid);
        erLu(a, temp, mid + 1, right);
        heBing(a, temp, left, mid, right);
    }

    public static void heBing(int[] a, int[] temp, int left, int mid, int right) {
        int i = left, j = mid + 1;
        int x = 0;
        while (i <= mid && j <= right) {
            temp[x++] = a[i] >= a[j] ? a[i++] : a[j++];
        }
        while (i <= mid) {
            temp[x++] = a[i++];
        }
        while (j <= right) {
            temp[x++] = a[j++];
        }

        for (int k = 0; k < x; k++) {
            a[left + k] = temp[k];
        }
    }

    public static void quickSort(int[] a) {
        quick(a, 0, a.length - 1);
    }

    public static void quick(int[] a, int left, int right) {
        if (left >= right)   return;
        int tag = a[left];
        int i = left, j = right;
        while (i < j) {
            while (i < j && a[j] < tag) j--;
            if (i < j)  a[i++] = a[j];
            while (i < j && a[i] > tag) i++;
            if (i < j)  a[j--] = a[i];
        }
        a[i] = tag;
        quick(a, left, i - 1);
        quick(a, i + 1, right);
    }

}
