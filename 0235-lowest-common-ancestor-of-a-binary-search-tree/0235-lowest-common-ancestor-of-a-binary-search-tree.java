/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lcaBST(TreeNode root, TreeNode p, TreeNode q){
         if(root==null){
            return null;
        }
        if(root==p||root==q){
            return root;
        }
        if(root.val<p.val){
            return lcaBST(root.right,p,q);
        }
        else if(root.val>q.val){
            return lcaBST(root.left,p,q);
        }
        else{
            return root;
        }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
       if(p.val<q.val){
            return lcaBST(root,p,q);
       }else{
            return lcaBST(root,q,p);
       }
    }
}