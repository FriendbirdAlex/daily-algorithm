class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();

        // 1. 初始化双指针，指向两个字符串的末尾
        int i = a.length() - 1;
        int j = b.length() - 1;

        // 2. 初始化进位
        int carry = 0;

        // 3. 循环条件：只要没遍历完，或者还有进位没处理，就继续
        // 这里的 carry != 0 是关键，处理最后可能多出来的一个 1
        while (i >= 0 || j >= 0 || carry != 0) {

            // 先把上一轮的进位拿过来
            int sum = carry;

            // 如果 a 还没遍历完，把 a 当前位的数字加到 sum 里
            if (i >= 0) {
                // char 转 int 的小技巧：减去 '0'
                // '1' - '0' = 1
                // '0' - '0' = 0
                sum += a.charAt(i) - '0';
                i--; // 指针前移
            }

            // 如果 b 还没遍历完，把 b 当前位的数字加到 sum 里
            if (j >= 0) {
                sum += b.charAt(j) - '0';
                j--; // 指针前移
            }

            // 4. 计算本位结果和新进位
            // sum 可能的值：0, 1, 2(1+1), 3(1+1+1)
            // append 进去的是余数 (0或1)
            sb.append(sum % 2);

            // 计算新的进位 (0或1)
            carry = sum / 2;
        }

        // 5. 因为我们是倒着追加的（从低位到高位），所以最后要反转一次
        return sb.reverse().toString();
    }
}