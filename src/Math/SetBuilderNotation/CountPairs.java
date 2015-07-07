package Math.SetBuilderNotation;

/**
 * Created by yizhao on 6/30/15.
 */
public class CountPairs {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6};
        System.out.println(countPairs(a, 20)); // 4
    }

    public static int countPairs(int[] a, int N) {
        int n = a.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((a[i] * a[i] + a[j] * a[j]) < N) {
                    // (1*1+2*2)<20
                    // (1*1+3*3)<20
                    // (1*1+4*4)<20
                    // (2*2+3*3)<20
                    System.out.println("(" + a[i] + "*" + a[i] + "+" + a[j] + "*" + a[j] + ")" + "<" + N);
                    count++;
                }
            }
        }
        return count;
    }
}
