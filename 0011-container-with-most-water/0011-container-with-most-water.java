class Solution {
    public int maxArea(int[] height) {
        
        int st = 0;
        int end = height.length - 1;
        int maxArea = -1;

        while(st < end) {
            int l = end - st;
            int h = Math.min(height[st], height[end]);
            int area = l*h;
            maxArea = Math.max(maxArea, area);

            if(height[st] < height[end]) {
                st++;
            }
            else {
                end--;
            }
        }
        return maxArea;
    }
}