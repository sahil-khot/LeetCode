class Solution {

    public int[] findPeakGrid(int[][] mat) {

        int n = mat.length;
        int m = mat[0].length;

        int low = 0;
        int high = m - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            // Find maximum element in middle column
            int maxRow = 0;

            for (int i = 1; i < n; i++) {
                if (mat[i][mid] > mat[maxRow][mid]) {
                    maxRow = i;
                }
            }

            int left = (mid > 0)
                    ? mat[maxRow][mid - 1]
                    : -1;

            int right = (mid < m - 1)
                    ? mat[maxRow][mid + 1]
                    : -1;

            int current = mat[maxRow][mid];

            // Peak found
            if (current > left && current > right) {
                return new int[]{maxRow, mid};
            }

            // Move towards larger neighbor
            if (left > current) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }

        return new int[]{-1, -1};
    }
}