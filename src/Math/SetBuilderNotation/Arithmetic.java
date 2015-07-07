package Math.SetBuilderNotation;

/**
 * Created by yizhao on 6/30/15.
 */
public class Arithmetic {
    public static void main(String[] args) {
        int[] a = {-1, 1, 3};
        int[] b = {-1, 1, 3, 3, 3};
        int[] c = {-1, 1, 3, 3, 3, 2, 1};
        int[] d = {-1, 1, 3, 3, 3, 2, 1, 0};
        int[] e = {-1, 1, 3, 3, 3, 2, 1, 0, 0, 0};
        int[] f = {-1, 1, 3, 3, 3, 2, 1, 0, 0, 0, 0};

        System.out.println(solution(a)); // 1
        System.out.println(solution(b)); // 2
        System.out.println(solution(c)); // 3
        System.out.println(solution(d)); // 5
        System.out.println(solution(e)); // 6
        System.out.println(solution(f)); // 8
    }

    public static int solution(int[] A) {
        int n = A.length;
        if (n < 2) {
            return 0;
        }
        int res = 0;
        int i = 0;
        while (i < n - 1) {
            long diff = A[i + 1] - A[i];
            int count = 1;
            int j = i + 1;
            while (j < n && A[j] - A[j - 1] == diff) {
                if (count == 2) {
                    res++;
                } else if (count > 2) {
                    res += count - 1;
                }
                count++;
                j++;
            }
            i = j - 1;
        }
        return res;
    }
}
