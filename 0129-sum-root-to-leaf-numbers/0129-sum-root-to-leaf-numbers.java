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
    int sum=0;
    public void helperFunc(TreeNode root,int digit){
        if(root==null){
            return ;
        }
        digit=digit*10+root.val;
        if(root.left==null && root.right==null){
            sum+=digit;
            return ;
        }
        helperFunc(root.left,digit);
        helperFunc(root.right,digit);
        return ;
    }
    public int sumNumbers(TreeNode root) {
        helperFunc(root,0);
        return sum;
    }
}