package Interviews.Alation;

/**
 * Created by YZ on 8/27/15.
 */
public class NumberofPathsInaMatrix {
    public static void main(String[] args) {

    }

    static int numberOfPaths(int[][] a, int M, int N) {
        if (a == null || M == 0 || N == 0) {
            return 0;
        }

        int[][] f = new int[M][N];

        for (int i = 0; i < M; i++) {
            if (a[i][0] != 0) {
                f[i][0] = 1;
            } else {
                break;
            }
        }

        for (int i = 0; i < N; i++) {
            if (a[0][i] != 0) {
                f[0][i] = 1;
            } else {
                break;
            }
        }

        for (int i = 1; i < M; i++) {
            for (int j = 1; j < N; j++) {
                if (a[i][j] != 0) {
                    f[i][j] = f[i - 1][j] + f[i][j - 1];
                } else {
                    f[i][j] = 0;
                }
            }
        }

        return f[M - 1][N - 1];


    }
}
