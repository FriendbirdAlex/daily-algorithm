class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int[] rel = new int[n];
             for(int i = 0; i < n; i++) {
                rel[(i + k) % n] = nums[i];
        }

        for(int i = 0; i < n; i++) {
            nums[i] = rel[i];
        }
    }
}

class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;

        // ⚠️ 关键点：如果 k 超过数组长度，取余数
        // 比如长度 5，轮转 7 次，其实等于轮转 2 次
        k = k % n;

        // 1. 翻转全部 [0, n-1]
        reverse(nums, 0, n - 1);

        // 2. 翻转前半部分 [0, k-1]
        reverse(nums, 0, k - 1);

        // 3. 翻转后半部分 [k, n-1]
        reverse(nums, k, n - 1);
    }

    // 双指针翻转数组工具方法
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}