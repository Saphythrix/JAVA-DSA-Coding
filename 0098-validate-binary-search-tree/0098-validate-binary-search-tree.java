/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    TreeNode prev=null;
    boolean isValid=true;
    public void validateBST(TreeNode root){
        if(root==null){
            return ;
        }
        validateBST(root.left);
        if(prev==null){
            prev=root;
        }
        else{
            if(root.val<=prev.val){
                isValid=false;
            }
            prev=root;
        }
        validateBST(root.right);
        return ;
    }
    public boolean isValidBST(TreeNode root) {
        validateBST(root);
        return isValid;
    }
}