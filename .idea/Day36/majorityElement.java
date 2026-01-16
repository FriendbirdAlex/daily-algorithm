class Solution {
    public int majorityElement(int[] nums) {
        int candidate = 0; // 当前的候选人
        int count = 0;     // 候选人的票数

        for (int num : nums) {
            // 1. 如果当前的票归零了，重新设立新的候选人
            if (count == 0) {
                candidate = num;
            }

            // 2. 根据是否是队友，决定加票还是减票
            if (num == candidate) {
                count++;
            } else {
                count--; // 遇到异类，同归于尽
            }
        }

        // 因为题目保证一定存在多数元素，所以剩下的 candidate 就是答案
        return candidate;
    }
}