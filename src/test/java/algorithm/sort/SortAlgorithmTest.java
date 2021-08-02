package algorithm.sort;

import org.junit.jupiter.api.Test;

import static algorithm.sort.SortAlgorithm.*;

class SortAlgorithmTest {

    private int[] a = {1, 9, 4, 7, 3, 5, 2};

    @Test
    void maoPaoSortTest() {
        //maoPaoSort(a);
        Sort2.maoPao(a);
        printArray(a);
    }

    @Test
    void simpleSelectSortTest() {
        //SimpleSelectSort(a);
        Sort2.xuanZe(a);
        printArray(a);
    }

    @Test
    void insertSortTest() {
        //insertSort(a);
        Sort2.chaRu(a);
        printArray(a);
    }

    @Test
    void mergeSorttest() {
        mergeSort(a);
        //Sort2.guiBing(a);
        printArray(a);
    }

    @Test
    void quickSortTest() {
        //quickSort(a);
        Sort2.quickSort(a);
        printArray(a);
    }

    void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}