class Solution {
    public void sortColors(int[] nums) {
        int Lindex=0;
        int Rindex=nums.length-1;
        int curr =0;
        while(curr<=Rindex){
            if(nums[curr]==0){
                swap(nums,curr,Lindex);
                Lindex++;
                curr++;
            }else if(nums[curr]==1){
                curr++;
            }else{
                swap(nums,curr,Rindex);
                Rindex--;
            }
        }
        return;
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}