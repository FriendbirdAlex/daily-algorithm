class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> merged = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        for(int i=0;i<intervals.length;i++){
            int L=intervals[i][0];
            int R=intervals[i][1];
            if(merged.size() == 0||merged.get(merged.size() - 1)[1] < L){
                merged.add(new int[]{L, R});
            } else {
                merged.get(merged.size() - 1)[1]= Math.max(merged.get(merged.size() - 1)[1], R);

            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
