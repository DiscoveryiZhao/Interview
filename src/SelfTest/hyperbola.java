package SelfTest;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定双曲线方程y = a* x * x + b * x + c和一个排好序的数组，求输出一个数组，包含所有y的排序后的值
 */
public class Hyperbola {

    public static void main(String[] args) {
    }

    // x is sorted array
    private static List<Integer> sorted(int a, int b, int c, int[] x) {
        List<Integer> result = new ArrayList<>();
        if (a == 0) {
            return result;
        }
        // the tredence is decresing first then increasing
        if (a > 0) {
            List<Integer> list1 = new ArrayList<>();
            list1.add(math(a, b, c, x[0]));
            int i;
            for (i = 1; i < x.length; i++) {
                int y = math(a, b, c, x[i]);
                if (y > list1.get(i - 1)) {
                    break;
                }
                list1.add(y);
            }
            //now the i is the index of first element is larger than previous
            List<Integer> list2 = new ArrayList<>();
            for (; i < x.length; i++) {
                int y = math(a, b, c, x[i]);
                list2.add(y);
            }
            //merge two arraylist
            result = mergeList(list1, list2);
        } else { //increasing first then decreasing
            List<Integer> list1 = new ArrayList<>();
            list1.add(math(a, b, c, x[0]));
            int i;
            for (i = 1; i < x.length; i++) {
                int y = math(a, b, c, x[i]);
                if (y < list1.get(i - 1)) {
                    break;
                }
                list1.add(y);
            }
            //now the i is the index of first element is larger than previous
            List<Integer> list2 = new ArrayList<>();
            for (; i < x.length; i++) {
                int y = math(a, b, c, x[i]);
                list2.add(y);
            }
            //merge two arraylist
            result = mergeList(list1, list2);
        }
        return result;
    }

    private static int math(int a, int b, int c, int num) {
        return (int) (a * Math.pow(num, 2) + b * num + c); // y = a * x * x + b * x + c
    }

    private static List<Integer> mergeList(List<Integer> list1, List<Integer> list2) {
        List<Integer> result = new ArrayList<>();
        if (list1 == null && list2 != null) {
            return list2;
        } else if (list1 != null && list2 == null) {
            return list1;
        }
        int i = 0;
        int j = 0;
        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i) < list2.get(j)) {
                result.add(list1.get(i));
                i++;
            } else {
                result.add(list2.get(j));
                j++;
            }
        }
        if (i != list1.size()) {
            for (; i < list1.size(); i++) {
                result.add(list1.get(i));
            }
        }
        if (j != list2.size()) {
            for (; j < list2.size(); j++) {
                result.add(list2.get(j));
            }
        }
        return result;
    }
}
