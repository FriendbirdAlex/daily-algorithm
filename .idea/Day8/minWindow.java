class Solution {
    public String minWindow(String s, String t) {
        // 1. 统计 t 中每个字符需要的数量
        int[] need = new int[128];
        for (char c : t.toCharArray()) {
            need[c]++;
        }

        // 2. 定义滑动窗口的变量
        int left = 0;
        int right = 0;
        int count = t.length(); // 还需要凑齐的字符总数

        // 记录最小覆盖子串的起始位置和长度
        int start = 0;
        int minLen = Integer.MAX_VALUE;

        // 3. 开始滑动
        while (right < s.length()) {
            // --- A. 进窗口 ---
            char c = s.charAt(right);

            // 如果当前字符是 t 需要的，那么 count 减 1
            if (need[c] > 0) {
                count--;
            }

            // 无论是不是需要的，need 都要减 1
            // need[c] > 0 表示还缺
            // need[c] <= 0 表示不缺了，或者是 s 里多出来的字符
            need[c]--;

            // --- B. 检查是否满足条件，并尝试收缩 ---
            // count == 0 说明 t 中的所有字符都凑齐了
            while (count == 0) {
                // 1. 更新最小子串记录
                int currentLen = right - left + 1;
                if (currentLen < minLen) {
                    minLen = currentLen;
                    start = left;
                }

                // 2. 准备把左边的字符移出窗口
                char d = s.charAt(left);

                // 恢复 need 计数
                // 如果 need[d] == 0，说明这个字符 d 正好是我们需要的那个
                // 移走它之后，我们就缺这个字符了，所以 count++
                // (如果 need[d] < 0，说明窗口里有富余的 d，移走一个也没事，count 不用变)
                if (need[d] == 0) {
                    count++;
                }
                need[d]++;

                // 左指针右移
                left++;
            }

            // 右指针继续右移扩大窗口
            right++;
        }

        // 如果 minLen 没变过，说明没找到
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}