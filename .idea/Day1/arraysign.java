class Solution {
    public static int arraySign(int[] nums) {
        int a = 1;
        for (int x : nums) {
            if (x == 0) {
                return 0;
            }
            if (x < 0) {
                a=-a;
            }
        }
        return a;
    }
}