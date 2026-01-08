class Solution {
    List<List<Integer>> res =new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> path =new ArrayList<>();
        backtrace(nums,0,path);
        return res;
    }
    public void backtrace(int[] nums,int startat,List<Integer> path){

        res.add(new ArrayList<>(path));
        for(int i=startat;i<nums.length;i++){
            path.add(nums[i]);
            backtrace(nums,i+1,path);
            path.remove(path.size()-1);
        }
    }
}