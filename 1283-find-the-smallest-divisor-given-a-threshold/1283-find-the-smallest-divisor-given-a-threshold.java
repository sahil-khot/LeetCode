class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = 0;
        int max = Integer.MIN_VALUE;
        for(int num : nums) {
            if(num > max) {
                max = num;
            }
        }
        high = max;
        int ans = high;

        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(isValidAns(nums, mid, threshold)) {
                ans = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public boolean isValidAns(int[] nums, int mid, int threshold) {
        int sum = 0;
        for(int num : nums) {
            sum += Math.ceil((double)num / mid);

            if(sum > threshold) {
                return false;
            }
        }
        return true;
    }
}