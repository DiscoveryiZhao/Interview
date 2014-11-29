package ThinkingInRecurion;

public class DFS_00_Straight_Way {
    public static void main(String[] args) {
        System.out.println(F_straight_way(2000)); // true
        System.out.println(F_straight_way(2001)); // false
    }

    /*
    * isEven
    * */
    public static boolean F_straight_way(int n) {
        return dfs(n);
    }

    public static boolean dfs(int n) {
        if (n == 0) {
            return true;
        } else if (n < 1) {
            return false;
        } else {
            return straightWay(n);
        }
    }

    public static boolean straightWay(int n) {
        return dfs(n - 2) == true ? true : false;
    }
}
