class Solution {
    public int smallestIndex(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            int digitSum = sum(nums, i);
            if(digitSum == i) {
                return i;
            }
        }
        return -1;
    }

    public static int sum(int[] nums, int i) {
        int num = nums[i];
        int digitSum = 0;
        while(num > 0) {
            int digit = num % 10;
            digitSum += digit;
            num /= 10;
        }
        return digitSum;
    }
}