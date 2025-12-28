class Solution {
    int maxdiameter=0;
    public int diameterOfBinaryTree(TreeNode root) {
        maxdeepth(root);
        return maxdiameter;
    }
    private int maxdeepth(TreeNode node){
        if(node==null){
            return 0;
        }
        int leftmax=maxdeepth(node.left);
        int rightmax=maxdeepth(node.right);
        maxdiameter=Math.max(maxdiameter,leftmax+rightmax);
        return Math.max(leftmax,rightmax)+1;
    }
}