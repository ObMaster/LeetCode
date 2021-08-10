package algorithm;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author OMaster
 * @date 2021/7/23
 */
public class f {
    public static void main(String[] args) {
        //========================升序排列==========================
        // 1、不指定Comparator，默认升序
        Set<Integer> set1 = new TreeSet<>();

        // 2、匿名内部类
        Set<Integer> set2 = new TreeSet<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer a, Integer b) {
                return a.compareTo(b);
            }
        });

        // 3、lambda表达式
        Set<Integer> set3 = new TreeSet<>((a, b) -> a.compareTo(b));
        // 方法引用一：类名::静态方法
        Set<Integer> set4 = new TreeSet<>(Integer::compare);
        /**
         * 方法引用二：类名::成员方法
         * 其中，方法的第一个参数表示方法调用者，后面的参数才是方法的参数
         *  eg：
         *  Integer的compareTo方法只需要一个参数，但是Comparator的compare方法是两个参数(a, b)
         *  a为调用者，b为compareTo方法的参数，故等价于a.compareTo(b)
         */
        Set<Integer> set5 = new TreeSet<>(Integer::compareTo);

        // 4、jdk提供的api方法
        Set<Integer> set6 = new TreeSet<>(Comparator.naturalOrder());
        //========================降序排列==========================
        // 1、匿名内部类
        Set<Integer> set7 = new TreeSet<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer a, Integer b) {
                return b.compareTo(a);
            }
        });

        // 2、lambda表达式
        Set<Integer> set8 = new TreeSet<>((a, b) -> b.compareTo(a));

        // 3、jdk提供的api方法
        Set<Integer> set9 = new TreeSet<>(Comparator.reverseOrder());
    }
}
