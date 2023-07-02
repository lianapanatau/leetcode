package p1;

import java.util.*;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(solution.twoSum(new int[]{3, 2, 4}, 6)));
        System.out.println(Arrays.toString(solution.twoSum(new int[]{3, 3}, 6)));
    }

    public int[] twoSum(int[] nums, int target) {
        var numsMap = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int neededNum = target - num;

            if (numsMap.containsKey(neededNum)) {
                return new int[]{numsMap.get(neededNum), i};
            } else {
                numsMap.put(num, i);
            }
        }

        return new int[]{0, 0};
    }

}