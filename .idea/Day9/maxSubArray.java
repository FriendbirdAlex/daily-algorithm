class Solution {
    public int maxSubArray(int[] nums) {
        int presum=0;
        int maxANS=nums[0];
        for(int num:nums){
            presum=Math.max(num+presum,num);
            maxANS=Math.max(maxANS,presum);
        }
        return maxANS;
    }
}