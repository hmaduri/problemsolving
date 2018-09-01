import java.util.*;

/**
 * leetcode problem 403
 */
public class FrogJump {

    //The following is a dp bottom up approach. This is calculating the validity of all the stones.
    //The following approach also is exceeding the time limit.
    public boolean canCross(int[] stones) {
        Map<Integer, Set<Integer>> stepsMap = new HashMap<Integer, Set<Integer>>();

        Set<Integer> zeroSet = new HashSet<Integer>();
        zeroSet.add(0);
        stepsMap.put(0, zeroSet);

        for (int i=1; i< stones.length; i++) {
            stepsMap.put(i, new HashSet<Integer>());
            for (int j=i-1; j >= 0; j--) {
                int jump = stones[i] - stones[j];
                Set<Integer> canComeFrom = new HashSet<Integer>(Arrays.asList(jump-1, jump, jump+1));
                canComeFrom.retainAll(stepsMap.get(j));
                Set<Integer> singleton = new HashSet<Integer>();
                singleton.add(jump);
                stepsMap.get(i).addAll(canComeFrom.isEmpty() ? canComeFrom : singleton);
            }
        }

        Set<Integer> lastStoneReachable = stepsMap.get(stones.length - 1);
        return lastStoneReachable != null && !lastStoneReachable.isEmpty();
    }


    public boolean canCrossTopDown(int[] stones) {
        
    }
}
