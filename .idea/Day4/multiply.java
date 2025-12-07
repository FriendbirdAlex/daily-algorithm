class Solution {
    public String multiply(String num1, String num2) {
        // 1. 处理特殊情况：如果有任意一个是 "0"，结果就是 "0"
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int m = num1.length();
        int n = num2.length();

        // 2. 结果数组，最大长度为 m + n
        // int 数组默认初始化全是 0
        int[] res = new int[m + n];

        // 3. 从右往左遍历两个字符串 (模拟竖式乘法)
        for (int i = m - 1; i >= 0; i--) {
            int n1 = num1.charAt(i) - '0'; // 获取 num1 当前位的数字

            for (int j = n - 1; j >= 0; j--) {
                int n2 = num2.charAt(j) - '0'; // 获取 num2 当前位的数字

                // 计算乘积
                int mul = n1 * n2;

                // 对应的索引位置
                // p1 是高位 (进位位)，p2 是低位 (当前位)
                int p1 = i + j;
                int p2 = i + j + 1;

                // 叠加到 res 数组
                // 注意：必须加上 res[p2] 原有的值，因为可能有上一轮的进位或者累加
                int sum = mul + res[p2];

                // 更新低位 (取余)
                res[p2] = sum % 10;

                // 累加进位到高位
                res[p1] += sum / 10;
            }
        }

        // 4. 将数组转换为字符串
        StringBuilder sb = new StringBuilder();
        for (int num : res) {
            // 跳过前导零
            // 如果 sb 还是空的，且当前数字是 0，说明这是前导零，跳过
            if (sb.length() == 0 && num == 0) {
                continue;
            }
            sb.append(num);
        }

        return sb.toString();
    }
}