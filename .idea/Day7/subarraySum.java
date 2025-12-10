class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int num = 0,sum = 0;
        map.put(sum,1);
        for(int i = 0;i < nums.length;i++){
            sum = sum + nums[i];
            System.out.print(nums[i] + " ");
            if(map.get(sum - k) != null){
                System.out.print(i + "-");
                num = num + map.get(sum - k);
            }
            if(map.get(sum) == null){
                map.put(sum,1);
            }else{
                int temp = map.get(sum);
                map.put(sum,(temp + 1));
            }
        }
        return num;
    }
}