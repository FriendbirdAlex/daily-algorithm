public class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();

        // 1. 尝试所有可能的子串长度 i
        // 子串长度最大只能是 n 的一半 (i * 2 <= n)
        for (int i = 1; i * 2 <= n; i++) {

            // 2. 只有当总长度能被 i 整除时，才可能是重复构成的
            // 比如长度 12，子串长度可能是 1, 2, 3, 4, 6，但不可能是 5
            if (n % i == 0) {

                // 3. 取出这个长度的子串作为“种子”
                String sub = s.substring(0, i);

                // 4. 开始构造：看看种子重复 n/i 次后长什么样
                StringBuilder sb = new StringBuilder();

                // 计算需要重复多少次
                int repeatCount = n / i;

                for (int j = 0; j < repeatCount; j++) {
                    sb.append(sub);
                }

                // 5. 比较构造出来的字符串和原字符串
                if (sb.toString().equals(s)) {
                    return true;
                }
            }
        }

        // 6. 跑完都没成功
        return false;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.repeatedSubstringPattern("abab")); // true
        System.out.println(sol.repeatedSubstringPattern("aba")); // false
        System.out.println(sol.repeatedSubstringPattern("abcabcabcabc")); // true
    }
}