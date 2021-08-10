package algorithm;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author OMaster
 * @date 2021/7/21
 */
public class g {
    public static void main(String[] args) {
        Integer i = 10;
        System.out.println(i.compareTo(4));
        Set<Integer> set = new TreeSet<>();
        set.add(10);
        set.add(3);
        set.add(14);
        set.add(20);
        set.add(5);
        set.add(3);
        set.add(1);
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
        for (Integer s : set) {
            System.out.print(s + " ");
        }


        Set<Integer> set2 = new TreeSet<>(Comparator.reverseOrder());
        Set<Integer> set3 = new TreeSet<>(Integer::compareTo);
        Set<Integer> set4 = new TreeSet<>(Integer::compare);
        Set<Integer> set5 = new TreeSet<>(Comparator.naturalOrder());
        set2.add(10);
        set2.add(3);
        set2.add(14);
        set2.add(20);
        set2.add(5);
        set2.add(3);
        set2.add(1);
        Iterator<Integer> iterator2 = set2.iterator();
        System.out.println();
        System.out.println(set2);

        set3.add(10);
        set3.add(3);
        set3.add(14);
        System.out.println();
        for (Integer s : set3) {
            System.out.print(s + " ");
        }

        set4.add(10);
        set4.add(3);
        set4.add(14);
        System.out.println();
        for (Integer s : set4) {
            System.out.print(s + " ");
        }
    }
}
