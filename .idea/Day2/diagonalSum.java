class Solution {
    public int diagonalSum(int [][] mat) {
        int n= mat.length;
        if(n == 0) return 0;
        int sum = 0;
        for (int i = 0; i < n; i++) sum += mat[i][i];
        for (int i = 0;i < n; i ++){
            if( (n - i - 1) != i) sum += mat[n-i-1][i];
        }
        return sum;
    }
}