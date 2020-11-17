package arrays;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[]{};
        Map<Integer, Integer> map =  new HashMap<>();

        for (int i=0; i < nums.length; i++) {
            int difference = target - nums[i];
            if (map.containsKey(difference) && i != map.get(difference))
                return new int[]{map.get(difference), i};
            map.put(nums[i], i);
        }
        return null;
    }
}
