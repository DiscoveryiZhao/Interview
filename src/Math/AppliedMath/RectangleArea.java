package Math.AppliedMath;

/**********************************************************************************
 *
 * Find the total area covered by two rectilinear rectangles in a 2D plane.
 * Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.
 *
 *                      Y
 *                      ^
 *                      |
 *                      |
 *                      |
 *                      |
 *                      |     (C,D):(3,4)
 *            +------------------+
 *            |         |        |
 *            |         |        |
 *            |         |        |               (G,H):(9,2)
 *            |         +----------------------------+
 *            |         |        |                   |
 *            |         |        |                   |
 *            |         |        |                   |
 *            +---------|--------+-------------------|---------> X
 *      (A,B):(-3,0)    |                            |
 *                      +----------------------------+
 *                  (E,F):(0,-1)
 *
 *
 *
 * Assume that the total area is never beyond the maximum possible value of int.
 *
 * Credits:Special thanks to @mithmatt for adding this problem, creating the above image and all test cases.
 *
 **********************************************************************************/
public class RectangleArea {

    /*
        http://www.programcreek.com/2014/06/leetcode-rectangle-area-java/
        This problem can be converted as a overlap internal problem.
        On the x-axis, there are (A,C) and (E,G);
        on the y-axis, there are (F,H) and (B,D).
        If they do not have overlap, the total area is the sum of 2 rectangle areas.
        If they have overlap, the total area should minus the overlap area.
    */
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        if (C < E || G < A || D < F || H < B) {
            return (G - E) * (H - F) + (C - A) * (D - B);
        }

        int right = Math.min(C, G);
        int left = Math.max(A, E);
        int top = Math.min(H, D);
        int bottom = Math.max(F, B);

        return (G - E) * (H - F) + (C - A) * (D - B) - (right - left) * (top - bottom);
    }
}
