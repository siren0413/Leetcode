package question;

/**
 * Created by siren0413 on 1/4/14.
 */
public class GasStation {
    public static int canCompleteCircuit(int[] gas, int[] cost) {

        /**
         * tank = all the gas - cast along the way.
         * current = current gas - cost.
         * if current < 0, means this point can not become the start, move to next point.
         * if tank < 0 at the end, no start point at all.
         */

        int start = 0, current = 0, tank = 0;
        for (int i = 0; i < gas.length; i++) {
            tank += gas[i] - cost[i];
            current += gas[i] - cost[i];
            if (current < 0){
                start = i + 1;
                current = 0;
            }
        }
        if (tank < 0)
            return -1;
        else
            return start;

    }

    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        System.out.println(canCompleteCircuit(gas, cost));
    }

}
