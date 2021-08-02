package algorithm.search;

import org.junit.jupiter.api.Test;

import static algorithm.search.SearchAlgorithm.*;

class SearchAlgorithmTest {

    @Test
    public void test() {
        int[] a = {4, 1, 6, 9, 3, 5, 8, 2};
        int i = erFenSearch(a, 5);
        System.out.println(i);
    }
}