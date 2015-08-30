package Interviews.Google;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定双曲线方程y = a * x * x + b * x + c和一个排好序的数组，求输出一个数组，包含所有y的排序后的值
 */
public class Hyperbola {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(sorted(1, 2, 3, a)); // [6, 11, 18, 27, 38, 51, 66, 83, 102]
        System.out.println(sorted(-1, 2, 3, a)); // [3, 0, -5, -12, -21, -32, -45, -60, 4]
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
            int i = 1;
            while (i < x.length) {
                int y = math(a, b, c, x[i]);
                if (y > list1.get(i - 1)) {
                    break;
                }
                list1.add(y);
                i++;
            }
            //now the i is the index of first element is larger than previous
            List<Integer> list2 = new ArrayList<>();
            while (i < x.length) {
                int y = math(a, b, c, x[i]);
                list2.add(y);
                i++;
            }
            //merge two arraylist
            result = mergeList(list1, list2);
        } else { //increasing first then decreasing
            List<Integer> list1 = new ArrayList<>();
            list1.add(math(a, b, c, x[0]));
            int i = 1;
            while (i < x.length) {
                int y = math(a, b, c, x[i]);
                if (y < list1.get(i - 1)) {
                    break;
                }
                list1.add(y);
                i++;
            }
            //now the i is the index of first element is larger than previous
            List<Integer> list2 = new ArrayList<>();
            while (i < x.length) {
                int y = math(a, b, c, x[i]);
                list2.add(y);
                i++;
            }
            //merge two arraylist
            result = mergeList(list1, list2);
        }
        return result;
    }

    private static int math(int a, int b, int c, int x) {
        return (int) (a * Math.pow(x, 2) + b * x + c); // y = a * x * x + b * x + c
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
            while (i < list1.size()) {
                result.add(list1.get(i++));
            }
        }
        if (j != list2.size()) {
            while (j < list2.size()) {
                result.add(list2.get(j++));
            }
        }
        return result;
    }
}
