class Solution {
    public int findMin(int[] arr) {

        int low = 0;
        int high = arr.length - 1;

        while (low < high) {

            int mid = low + (high - low) / 2;

            if (arr[mid] > arr[high]) {
                // Minimum is on the right
                low = mid + 1;
            }
            else {
                // Minimum is at mid or on the left
                high = mid;
            }
        }

        return arr[low];
    }
}