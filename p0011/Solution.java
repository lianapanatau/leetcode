package p0011;

class Solution {
    public int maxArea(int[] height) {
        var start = 0;
        var end = height.length - 1;

        var max = (end - start) * Math.min(height[start], height[end]);
        while (start < end) {
            var moveRightVol = (end - (start + 1)) * Math.min(height[start + 1], height[end]);
            var moveLeftVol = ((end - 1) - start) * Math.min(height[start], height[end - 1]);

            if (moveRightVol > max && moveRightVol >   moveLeftVol) {
                max = moveRightVol;
                start++;
            } else if (moveLeftVol > max) {
                max = moveLeftVol;
                end--;
            } else {
                start++;
                end--;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxArea(new int[]{1, 3, 2, 5, 25, 24, 5})); // 24
//        System.out.println(solution.maxArea(new int[]{1,8,6,2,5,4,8,3,7})); //49
//        System.out.println(solution.maxArea(new int[]{5,2,12,1,5,3,4,11,9,4})); //55
    }
}