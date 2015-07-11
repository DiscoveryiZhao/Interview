package GeedyAlgorithm;

/**
 * Created by yizhao on 7/11/15.
 */
public class ActivitySelectionProblem {
    public static void main(String[] args) {
        int s[] = {1, 3, 0, 5, 3, 5, 6, 8, 8, 2, 12};
        int f[] = {4, 5, 6, 7, 9, 9, 10, 11, 12, 14, 16};

        printMaxActivities(s, f); // 输出：0,3,7,10
    }

    // Prints a maximum set of activities that can be done by a single
    // person, one at a time.
    // n --> Total number of activities
    // s[] --> An array that contains start time of all activities
    // f[] --> An array that contains finish time of all activities
    public static void printMaxActivities(int s[], int f[]) {
        int n = s.length;
        int k;

        System.out.println("Following activities are selected");

        // The first activity always gets selected
        k = 0;
        System.out.print(k + ",");

        // Consider rest of the activities
        for (int m = 1; m < n; m++) {
            // If this activity has start time greater than or equal to the
            // finish
            // time of previously selected activity, then select it
            if (s[m] >= f[k]) {
                System.out.print(m + ",");
                k = m;
            }
        }
    }
}
