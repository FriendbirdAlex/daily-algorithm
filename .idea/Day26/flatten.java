
class Solution {
    public void flatten(TreeNode root) {
        TreeNode curr=root;
        while(curr!=null){
            if(curr.left!=null){
                TreeNode next =curr.left;
                TreeNode lastRight=next;
                while(lastRight.right!=null){
                    lastRight=lastRight.right;
                }
                lastRight.right=curr.right;
                curr.right=next;
                curr.left=null;

            }
            curr=curr.right;

        }
    }
}