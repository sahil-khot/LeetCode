class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] arr = new int[nums1.length + nums2.length];
        int i = 0;
        int j = 0;
        int k = 0;

        while(i < nums1.length && j < nums2.length) {
            if(nums1[i] < nums2[j]) {
                arr[k] = nums1[i];
                i++;
                k++;
            }
            else {
                arr[k] = nums2[j];
                j++;
                k++;
            }
        }

        while(i < nums1.length) {
            arr[k] = nums1[i];
            i++;
            k++;
        }
        while(j < nums2.length) {
            arr[k] = nums2[j];
            j++;
            k++;
        }

        double median = 0.0;
        int l = arr.length;
        if(l % 2 == 0) {
            median = ((arr[(l / 2) - 1] + arr[l / 2])) / 2.0;
        }
        else {
            median = arr[l / 2];
        }
        return median;
    }
}