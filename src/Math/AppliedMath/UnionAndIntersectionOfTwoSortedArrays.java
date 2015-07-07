package Math.AppliedMath;

/**
 * Created by yizhao on 6/30/15.
 */
public class UnionAndIntersectionOfTwoSortedArrays {
    public static void main(String[] args) {

        int[] a = {1, 3, 4, 5, 7};

        int[] b = {2, 3, 5, 6};

        union(a, b); // 1, 2, 3, 3, 4, 5, 5, 6, 7

        intersection(a, b); // 3, 5

    }

    public static void union(int[] a, int[] b) {

        int m = a.length;

        int n = b.length;

        int i = 0;

        int j = 0;

        // 哪个小,则print哪个。 如果一样大，则两个都print.

        while (i < m && j < n) {

            if (a[i] < b[j]) { // a[i]小,则print a[i]

                System.out.print(a[i++] + ",");

            } else if (b[j] < a[i]) { // b[j]小,则print b[j]

                System.out.print(b[j++] + ",");

            } else { // a[i] == b[j] 如果两个一样大,则两个都print

                System.out.print(a[i++] + ",");

                System.out.print(b[j++] + ",");

            }

        }


        while (i < m) {

            System.out.print(a[i++] + ",");

        }


        while (j < n) {

            System.out.print(b[j++] + ",");

        }

    }


    public static void intersection(int[] a, int[] b) {

        int m = a.length;

        int n = b.length;

        int i = 0;

        int j = 0;

        // 哪个小,则skip哪个。 如果一样大，则print其中任意一个.

        while (i < m && j < n) {

            if (a[i] < b[j]) { // a[i]小,则skip a[i]

                i++;

            } else if (b[j] < a[i]) { // b[j]小,则skip b[j]

                j++;

            } else { // a[i] == b[j]  如果一样大，则为 intersection,print其中任意一个.

                System.out.print(a[i] + ",");

                i++;

                j++;

            }

        }

    }
}
