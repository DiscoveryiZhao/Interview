package GeedyAlgorithm;

/**
 * Created by yizhao on 7/11/15.
 */
public class GasStation {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int previousTotalCost = 0;
        int globalTotalCost = 0;
        int startingStationIndex = -1;
        for (int i = 0; i < gas.length; i++) {
            int localDiff = gas[i] - cost[i];
            previousTotalCost += localDiff;
            globalTotalCost += localDiff;
            if (previousTotalCost < 0) {
                startingStationIndex = i;
                previousTotalCost = 0;
            }
        }
        return globalTotalCost >= 0 ? startingStationIndex + 1 : -1;
    }
}
