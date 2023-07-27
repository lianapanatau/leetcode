package p0852;

class Solution {
    private int searchPeak(int[] arr, int left, int right) {
        var middle = left + (right - left)/2;

        if (arr[middle - 1] < arr[middle] && arr[middle] > arr[middle + 1]) {
            return middle;
        }

        if (arr[middle - 1] < arr[middle] && arr[middle] < arr[middle + 1]) {
            return searchPeak(arr, middle + 1, right);
        } else {
            return searchPeak(arr, left, middle - 1);
        }
    }
    public int peakIndexInMountainArray(int[] arr) {
        return searchPeak(arr, 0, arr.length - 1);

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.peakIndexInMountainArray(new int[]{3,5,3,2,0}));
    }
}