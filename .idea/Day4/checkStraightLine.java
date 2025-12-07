class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        int n=coordinates.length;
        for(int i=0;i<n-2;i++) {
            int[]a=coordinates[i];
            int[]b=coordinates[i+1];
            int[]c=coordinates[i+2];
            int dx1=b[0]-a[0];
            int dy1=b[1]-a[1];
            int dx2=c[0]-b[0];
            int dy2=c[1]-b[1];
            if(dy1*dx2!=dy2*dx1)return false;
        }
        return true;
    }
}