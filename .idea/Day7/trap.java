class Solution {
    public int trap(int[] height) {
        int left =0;
        int right=height.length-1;
        int leftmax=0;
        int rightmax=0;
        int total=0;
        while(left<right){
            leftmax=Math.max(leftmax,height[left]);
            rightmax=Math.max(rightmax,height[right]);
            if(leftmax<rightmax){
                total+=leftmax-height[left];
                left++;
            } else{
                total+=rightmax-height[right];
                right--;
            }
        }   return total;
    }
}