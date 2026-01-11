
class Solution {
    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        backtrack(n, 0, 0, "");
        return res;
    }

    private void backtrack(int n, int open, int close, String path) {
        if (open == n && close == n) {
            res.add(path);
            return;
        }
        if (open < n) {
            backtrack(n, open + 1, close, path + "(");
        }
        if (close < open) {
            backtrack(n, open, close + 1, path + ")");
        }
    }
}