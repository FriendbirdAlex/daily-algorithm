class Solution {
    private Map<Integer, Integer> inorderMap = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    private TreeNode build(int[] preorder, int preStart, int preEnd,
                           int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = inorderMap.get(rootVal);

        int leftSubtreeSize = rootIndex - inStart;
        root.left = build(preorder, preStart + 1, preStart + leftSubtreeSize,
                inorder, inStart, rootIndex - 1);
        root.right = build(preorder, preStart + leftSubtreeSize + 1, preEnd,
                inorder, rootIndex + 1, inEnd);

        return root;
    }
}