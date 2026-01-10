class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> path = new ArrayList<>();
        backtrack(candidates, target, 0, path);
        return res;
    }
    private void backtrack(int[] candidates, int remainingTarget, int start, List<Integer> path) {
        if (remainingTarget == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (remainingTarget - candidates[i] < 0) {
                break;
            }
            path.add(candidates[i]);
            backtrack(candidates, remainingTarget - candidates[i], i, path);
            path.remove(path.size() - 1);
        }
    }
}