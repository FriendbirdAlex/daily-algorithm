class Solution {
    public int countOdds(int low, int high) {
        // 1. 先计算基础的一半数量
        int count = (high - low) / 2;

        // 2. 检查边界条件
        // 如果 low 是奇数 或者 high 是奇数，说明还得再加 1 个
        // 使用位运算 (x & 1) == 1 判断奇数比 x % 2 != 0 稍快，但逻辑一样
        if (low % 2 != 0 || high % 2 != 0) {
            count++;
        }

        return count;
    }
}