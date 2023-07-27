package p0128;

import java.util.HashSet;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    }

    public int longestConsecutive(int[] nums) {
        // No numbers in the array
        if (nums.length == 0) {
            return 0;
        }

        // Only one number in the array
        if (nums.length == 1) {
            return 1;
        }

        var numbers = new HashSet<Integer>();
        for (var num : nums) {
            numbers.add(num);
        }

        // All numbers are equal
        if (numbers.size() == 1) {
            return 1;
        }

        int max = -1;
        for (int num : nums) {
            if (!numbers.contains(num + 1) && numbers.contains(num - 1)) {
                var nr = num - 1;
                var counter = 0;
                while (numbers.contains(nr)) {
                    counter++;
                    nr--;
                }

                if (max < counter + 1) {
                    max = counter + 1;
                }
            }
        }


        if (max == -1) {
            // All numbers are different
            return 1;
        }

        return max;
    }
}