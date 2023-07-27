package p0042;

class Solution {
    public int trap(int[] height) {
        var start = 0;
        var end = 0;

        var counter = 0;
        while (end < height.length - 1) {
            if (height[start] == 0) {
                start++;
            } else {
                var elevation = height[start];
                end = start + 1;
                while (height[end] < height[start]) {
                    counter += elevation - height[end];
                    end++;
                    start++;
                }
            }
        }

        return counter;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
        System.out.println(solution.trap(new int[]{4,2,0,3,2,5}));
    }
}