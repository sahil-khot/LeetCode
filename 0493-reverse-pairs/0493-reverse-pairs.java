class Solution {

    public int merge(int[] nums, int l, int mid, int r) {
        int leftLen = mid - l + 1;
        int rightLen = r - mid;

        int[] leftArr = new int[leftLen];
        int[] rightArr = new int[rightLen];

        for(int i = 0; i < leftLen; i++) {
            leftArr[i] = nums[l + i];
        }
        for(int i = 0; i < rightLen; i++) {
            rightArr[i] = nums[mid + i + 1];
        }

        int j = 0;
        int count = 0;

        for (int i = 0; i < leftLen; i++) {
            while (j < rightLen &&
                leftArr[i] > 2L * rightArr[j]) {
                j++;
            }
            count += j;
        }

        int i = 0;
        j = 0;
        int k = l;

        while(i < leftLen && j < rightLen) {
            if(leftArr[i] < rightArr[j]) {
                nums[k] = leftArr[i];
                i++;
            }
            else {
                nums[k] = rightArr[j];
                j++;
            }
            k++;
        }

        while(i < leftLen) {
            nums[k] = leftArr[i];
            i++;
            k++;
        }
        while(j < rightLen) {
            nums[k] = rightArr[j];
            j++;
            k++;
        }
        return count;
    }

    public int mergeSort(int[] nums, int l, int r) {
        if(l >= r) {
            return 0;
        }
        int count = 0;
        int mid = l + (r - l) / 2;
        count += mergeSort(nums, l, mid);
        count += mergeSort(nums, mid + 1, r);
        count += merge(nums, l, mid, r);

        return count;
    }

    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }
}