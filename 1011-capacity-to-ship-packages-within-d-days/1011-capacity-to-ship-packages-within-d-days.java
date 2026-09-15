class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = 1;
        int high = 0;
        for(int num : weights) {
            high += num;
        }

        int ans = high;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(isValidAns(weights, days, mid)) {
                ans = mid; 
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public boolean isValidAns(int[] weights, int days, int mid) {
        int sum = 0;
        int day = 1;
        for(int weight : weights) {
            if(weight > mid) {
                return false;
            }
            sum += weight;
            if(sum > mid) {
                day++;
                sum = weight;
            }
        }
        return day <= days;
    }
}