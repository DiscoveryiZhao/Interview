package Interviews.Alation;

/**
 * Created by YZ on 8/27/15.
 */
public class FriendCircles {
    static int friendCircles(String[] friends) {
        if (friends == null) {
            return 0;
        }
        int n = friends.length;
        if (n == 0) {
            return 0;
        }

        int count = 0;
        boolean[] hash = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (hash[i] == false) {
                hash[i] = true;
                count++;
                dfs(friends, hash, i);
            }
        }
        return count;
    }

    private static void dfs(String[] friends, boolean[] hash, int j) {
        int n = friends[0].length();
        for (int i = j + 1; i < n; i++) {
            if (hash[i] == false && friends[j].charAt(i) == 'Y') {
                hash[i] = true;
                dfs(friends, hash, i);
            }
        }
    }

}
