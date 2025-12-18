class Solution {
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        for(int i=0;i<n;i++){
            int L=0;
            int R=n-1;
            while(L<R){
                int temp = matrix[i][L];
                matrix[i][L] = matrix[i][R];
                matrix[i][R] = temp;
                L++;
                R--;
            }
        }
    }
}