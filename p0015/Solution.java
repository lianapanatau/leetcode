package p0015;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(solution.threeSum(new int[]{0, 0, 0, 0}));
        System.out.println(solution.threeSum(new int[]{0, 1, 1}));
        System.out.println(solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4}));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> rez = new ArrayList<>();

        var size = nums.length;
        Arrays.sort(nums);

        int previous = nums[0];

        if (size == 3) {
            if (nums[0] + nums[1] + nums[2] == 0) {
                return List.of(List.of(nums[0], nums[1], nums[2]));
            }
        }

        var lists = new HashSet<List<Integer>>();
        for (int i = 0; i < nums.length - 1; i++) {
            var pivot = nums[i];
            if (pivot == previous && i >= 1) {
                continue;
            } else {
                previous = pivot;
            }

            if (pivot > 0) {
                break;
            }

            var start = i + 1;
            var end = size - 1;

            var target = -pivot;

            while (start < end) {
                var second = nums[start];
                var third = nums[end];

                if (second + third == target) {
                    var l = List.of(pivot, second, third);
                    if (!lists.contains(l)) {
                        lists.add(l);
                        rez.add(l);
                    }

                    end--;
                    start++;
                } else {
                    if (second + third > target) {
                        end--;
                    } else {
                        start++;
                    }
                }
            }
        }

        return rez;
    }
}