import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;

public class Sum {
    /*
        2. **Two Sum**: given `int[] nums = {2, 7, 11, 15}` and `int target = 9`, 
        find and print the two indices that add up to the target. Use a HashMap for O(n).
     */

    public static void main (String[] args){
        int[] nums = {2, 7, 11, 15};

        int[][] sums = new int[nums.length][nums.length];

        int target = 9;

        // for (int i = 0; i < nums.length; i++) {
        //     for (int j = 1; j < nums.length; j++) {
        //         sums[i][j] = nums[i] + nums[j];

        //         if (sums[i][j] == target) {
        //             System.out.printf("Indicies are: %d %d %n", i, j);
        //         }
        //     }
        // }

        Map<Integer, Integer> seenMap = new HashMap(); 

        int firstIndex = Integer.MIN_VALUE;
        int secondIndex = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (seenMap.containsKey(complement)) {
                firstIndex = seenMap.get(complement);
                secondIndex = i;
            }
            else {
                seenMap.put(nums[i], i);
            }
        }
        
        System.out.printf("Indices are %d %d%n", firstIndex, secondIndex);
    }
}
