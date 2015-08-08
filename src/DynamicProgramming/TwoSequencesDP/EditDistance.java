package DynamicProgramming.TwoSequencesDP;

/**
 * Created by yizhao on 5/18/15.
 */
public class EditDistance {
    public static void main(String[] args) {
        System.out.println(minDistance("Saturday", "Sturday")); // 1
        System.out.println(minDistance("ab", "abcd")); // 2
        System.out.println(minDistance("Saturday", "Sunday")); // 3
        System.out.println(minDistance("abc", "abcd")); // 1
        System.out.println(minDistance("", "a")); // 1
        System.out.println(minDistance("", "aa")); // 2
        System.out.println(minDistance("", "ab")); // 2
    }

    public static int minDistance(String S, String T) {
        int m = S.length(), n = T.length();
        // state: f[i][i] 表示word1的前i个字符，需要多少次编辑，能够变成word2的前j个字符
        int f[][] = new int[m + 1][n + 1];
        // intialize for worst case:
        // S[i]的前i个字符，需要多少次编辑，能够变成null，所以就是需要删掉i个字符就能null，故dp[i][0] = i
        for (int i = 0; i < m + 1; i++) {
            f[i][0] = i;
        }
        // intialize for worst case:
        // T[i]的前i个字符，需要多少次编辑，能够变成null，所以就是需要删掉i个字符就能null，故dp[0][i] = i
        for (int i = 0; i < n + 1; i++) {
            f[0][i] = i;
        }

        // function:
        // f[i][j] = MIN(f[i-1][j-1], f[i-1][j]+1,f[i][j-1]+1) when a[i] == b
        //         = MIN(f[i-1][j-1], f[i-1][j],f[i][j-1])+1 when a[i] != b
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (S.charAt(i - 1) == T.charAt(j - 1)) {
                    f[i][j] = f[i - 1][j - 1]; // No edit operations are necessary
                } else {
                    // 把S[i-1]字符删除了，变换成T[j]字符
                    int delete = f[i - 1][j] + 1;
                    // 将S[i]的后面添加上T[j-1]字符
                    int insert = f[i][j - 1] + 1;
                    // 将S[i-1]替换成T[j-1]字符
                    int replace = f[i - 1][j - 1] + 1;
                    f[i][j] = Math.min(replace, Math.min(delete, insert));
                }
            }
        }
        return f[m][n];
    }
}
