class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int stRow = 0;
        int endRow = n-1;
        int stCol = 0;
        int endCol = n-1;

        int num = 1;
        while((stRow <= endRow) && (stCol <= endCol)){
            //First Row
            for(int i = stCol; i <= endCol; i++){
                matrix[stRow][i] = num;
                num++;
            }
            stRow++;

            for(int i = stRow; i <= endRow; i++){
                matrix[i][endCol] = num;
                num++;
            }
            endCol--;

            if(stRow <= endRow){
                for(int i = endCol; i >= stCol; i--){
                    matrix[endRow][i] = num;
                    num++;
                }
            }
            endRow--;

            if(stCol <= endCol){
                for(int i = endRow; i >= stRow; i--){
                    matrix[i][stCol] = num;
                    num++;
                }
            }
            stCol++;
        }
        return matrix;
    }
}