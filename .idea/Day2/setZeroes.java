class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        // 1. 检查第一行和第一列是否本来就有 0
        // 这两个变量是最后处理首行首列的依据
        boolean firstRowHasZero = false;
        boolean firstColHasZero = false;

        // 检查第一列
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                firstColHasZero = true;
                break;
            }
        }

        // 检查第一行
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                firstRowHasZero = true;
                break;
            }
        }

        // 2. 使用第一行和第一列作为标记位
        // 从 (1,1) 开始遍历
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0; // 标记该行
                    matrix[0][j] = 0; // 标记该列
                }
            }
        }

        // 3. 根据标记，将内部元素置零
        // 注意：这里也是从 (1,1) 开始，不要碰第一行和第一列
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // 4. 最后处理第一行和第一列
        if (firstRowHasZero) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }

        if (firstColHasZero) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}