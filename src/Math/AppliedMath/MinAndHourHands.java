package Math.AppliedMath;

/**
 * Created by yizhao on 6/30/15.
 */
public class MinAndHourHands {
    public static void main(String[] args) {
        System.out.println(diffAngle(2, 20)); // 50
    }

    // h = 1..12, m = 0..59
    public static double diffAngle(int h, int m) {
        // 时针共走度数 = h * 时针每小时走的度数 + m * 时针每分钟走的度数
        double hAngle = h * 30 + m * 0.5;
        // 分针共走度数 = m * 分针每分钟走的度数
        double mAngle = m * 6;
        double diffAngle = Math.abs(hAngle - mAngle);
        // 当时针和分针的度差大于180度时， 要取 360 - diffAngle
        diffAngle = Math.min(diffAngle, 360 - diffAngle);
        return diffAngle;
    }
}
