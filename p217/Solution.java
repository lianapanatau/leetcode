package p217;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.containsDuplicate(new int[]{1,2,3,1}));
        System.out.println(solution.containsDuplicate(new int[]{1,2,3,4}));
        System.out.println(solution.containsDuplicate(new int[]{1,1,1,3,3,4,3,2,4,2}));
    }
    public boolean containsDuplicate(int[] numbers) {
        var set = new HashSet<Integer>();

        for (int num : numbers) {
            if (!set.add(num)) {
                return true;
            }
        }

        return false;
    }
}