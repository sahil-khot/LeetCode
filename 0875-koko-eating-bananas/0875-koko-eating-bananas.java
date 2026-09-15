class Solution {

    static boolean isValidAns(int[] piles, int h, long speed){
        long hourCount = 0;

        for(int i = 0; i < piles.length; i++){
            if(piles[i] % speed == 0){
                hourCount += piles[i] / speed;
            }
            else{
                hourCount += (piles[i] / speed) + 1;
            }
        }

        return hourCount <= h;
    }

    public int minEatingSpeed(int[] piles, int h) {
        long st = 1;

        long end = 0;
        for(int i = 0; i < piles.length; i++){
            end = Math.max(end, piles[i]);
        }

        int ans = 0;

        while(st <= end){
            long mid = st + (end - st) / 2;

            if(isValidAns(piles, h, mid)){
                ans = (int)mid;
                end = mid - 1;
            }
            else{
                st = mid + 1;
            }
        }

        return ans;
    }
}