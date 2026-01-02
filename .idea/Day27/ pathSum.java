class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> prefixSumMap = new HashMap<>();
        prefixSumMap.put(0L, 1);
        return dfs(root, 0L, targetSum, prefixSumMap);
    }

    private int dfs(TreeNode node, long currSum, int targetSum, Map<Long, Integer> prefixSumMap) {
        if (node == null) {
            return 0;
        }
        currSum += node.val;
        int res = prefixSumMap.getOrDefault(currSum - targetSum, 0);
        prefixSumMap.put(currSum, prefixSumMap.getOrDefault(currSum, 0) + 1);
        res += dfs(node.left, currSum, targetSum, prefixSumMap);
        res += dfs(node.right, currSum, targetSum, prefixSumMap);
        prefixSumMap.put(currSum, prefixSumMap.get(currSum) - 1);
        return res;
    }
}