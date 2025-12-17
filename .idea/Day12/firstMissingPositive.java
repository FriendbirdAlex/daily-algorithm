class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // 1. 遍历并交换：把 nums[i] 放到下标 nums[i]-1 的位置上
        for (int i = 0; i < n; i++) {
            // 循环交换，直到满足条件或者无法交换
            // 条件1: 是正数
            // 条件2: 不越界 (比如 n=4, 那个 5 就不管它)
            // 条件3: 目标位置上的数和当前数不一样 (防止死循环，如 [1, 1])
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
        }

        // 2. 再次遍历：找第一个位置不对的数
        for (int i = 0; i < n; i++) {
            // 理想状态是 nums[i] == i + 1
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        // 3. 如果所有位置都对上了，说明是 [1, 2, ..., n]，缺的是 n + 1
        return n + 1;
    }

    // 辅助交换方法
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}