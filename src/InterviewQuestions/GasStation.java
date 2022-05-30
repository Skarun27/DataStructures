package InterviewQuestions;
public class GasStation {
    public static int canCompleteCircuit(int[] gas, int[] cost) {

        int totalGas = 0;
        int remainingGas = 0;
        int startingPoint = 0;
        for(int i=0; i<gas.length; i++) {
            totalGas += gas[i] - cost[i];
            remainingGas += gas[i] - cost[i];
            if(remainingGas < 0) {
                remainingGas = 0;
                startingPoint = i+1;
            }
        }
        return totalGas >= 0 ? startingPoint : -1;
    }

    public static void main(String[] args) {
        int[] gas = new int[]{1,2,3,4,5};
        int[] cost = new int[]{3,4,5,1,2};
        System.out.println(canCompleteCircuit(gas, cost));
    }
}
