class Solution {
    public int maxArea(int[] height) {
        int a =0;//指针一
        int b =height.length-1;//指针二
        int maxS=0;
        while(a<b){
            if(maxS<(b-a)*Math.min(height[a],height[b])){
                maxS=(b-a)*Math.min(height[a],height[b]);
            }
            if(height[a]<=height[b]){
                a++;
            }else{
                b--;
            }

        }
        return maxS;
    }
}