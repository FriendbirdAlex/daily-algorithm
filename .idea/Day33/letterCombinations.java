class Solution {
    private String[] mapping = {
            "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };
    private List<String> res = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        backtrack(digits, 0, new StringBuilder());
        return res;
    }

    private void backtrack(String digits, int index, StringBuilder path) {
        if (index == digits.length()) {
            res.add(path.toString());
            return;
        }
        char digit = digits.charAt(index);
        String letters = mapping[digit - '0'];
        for (int i = 0; i < letters.length(); i++) {
            path.append(letters.charAt(i));
            backtrack(digits, index + 1, path);
            path.deleteCharAt(path.length() - 1);
        }
    }
}