package GoogleInterviewPrepare;

import java.util.Arrays;

/**
 * Given an unsorted array of positive integers. Find the number of triangles that can be formed with three different array elements as three sides of triangles. For a triangle to be possible from 3 values, the sum of any two values (or sides) must be greater than the third value (or third side).
 For example, if the input array is {4, 6, 3, 7}, the output should be 3. There are three triangles possible {3, 4, 6}, {4, 6, 7} and {3, 6, 7}. Note that {3, 4, 7} is not a possible triangle.
 As another example, consider the array {10, 21, 22, 100, 101, 200, 300}. There can be 6 possible triangles: {10, 21, 22}, {21, 100, 101}, {22, 100, 101}, {10, 100, 101}, {100, 101, 200} and {101, 200, 300}
 */
public class CountTheNumberOfPossibleTriangles {
    public static void main(String[] args) {
        int[] a = { 4, 6, 3, 7 };
        int[] b = { 10, 21, 22, 100, 101, 200, 300 };
        // a:3 ,b:4 ,c:6
        // a:3 ,b:6 ,c:7
        // a:4 ,b:6 ,c:7
        System. out.println(findNumberOfTriangles(a)); // 3
        // a:10 ,b:21 ,c:22
        // a:10 ,b:100 ,c:100
        // a:10 ,b:100 ,c:101
        // a:10 ,b:200 ,c:200
        // a:21 ,b:100 ,c:100
        // a:21 ,b:100 ,c:101
        // a:21 ,b:200 ,c:200
        // a:22 ,b:100 ,c:101
        // a:22 ,b:200 ,c:200
        // a:100 ,b:101 ,c:200
        // a:101 ,b:200 ,c:300
        System. out.println(findNumberOfTriangles(b)); // 6
    }


    // O(n^2) solution
    public static int findNumberOfTriangles(int[] a ) {
        int n = a. length;
        Arrays. sort(a );
        int count = 0;
        for (int i = 0; i < n - 2; i++) {
            int k = i + 2;
            for (int j = i + 1; j < n; j++) {
                while (k < n && a[i] + a[j] > a [k]) {
                    System. out.println("a:" + a[i] + "  ,b:" + a[j] + "  ,c:" + a [k]);
                    k++;
                }
                count += k - j - 1;
            }
        }
        return count;
    }

    // O(n^3) solution
    public static int findNumberOfTriangles2(int[] a) {
        int n = a.length ;
        Arrays.sort(a);
        int count = 0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (a[i] + a[j] > a[k]) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
