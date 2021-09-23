package AlgoExpert.hard;
import java.util.*;

/**
        Four Number Sum
        Write a function that takes in a non-empty array of distinct integers and an integer representing a target sum. The function should find all quadruplets in the array that sum up to the target sum and return a two-dimensional array of all these quadruplets in no particular order.

        If no four numbers sum up to the target sum, the function should return an empty array.

        Sample Input
        array = [7, 6, 4, -1, 1, 2]
        targetSum = 16

        Sample Output
        [[7, 6, 4, -1], [7, 6, 1, 2]]
 */


public class FourNumberSum {
    public static List<Integer[]> fourNumberSum(int[] array, int targetSum) {
        List<Integer[]> quadruplets = new ArrayList<>();
        Map<Integer, List<Integer[]>> allPairSums = new HashMap<>();
        for (int i = 1; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                int currentSum = array[i] + array[j];
                int diff = targetSum - currentSum;
                if (allPairSums.containsKey(diff)) {
                    for (Integer[] pair: allPairSums.get(diff)) {
                        Integer[] newQuadruplet = {pair[0], pair[1], array[i], array[j]};
                        quadruplets.add(newQuadruplet);
                    }
                }
            }
            for (int k = 0; k < i; k++) {
                int currSum = array[k] + array[i];
                Integer[] currPair = {array[k], array[i]};

                List<Integer[]> fromMap = allPairSums.getOrDefault(currSum,
                        new ArrayList<Integer[]>());
                fromMap.add(currPair);
                allPairSums.put(currSum, fromMap);
            }
        }
        return quadruplets;
    }
}
