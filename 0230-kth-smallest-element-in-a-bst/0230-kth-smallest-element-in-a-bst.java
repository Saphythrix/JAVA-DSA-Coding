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
    Stack<TreeNode> asc=new Stack<>();
    public TreeNode getSmall(){
        if(asc.isEmpty()){
            return null;
        }
        TreeNode small=asc.pop();
        TreeNode rightchild=small.right;
        while(rightchild!=null){
            asc.push(rightchild);
            rightchild=rightchild.left;
        }
        return small;
    }
    public int kthSmallest(TreeNode root, int k) {
        TreeNode t=root;
        while(t!=null){
            asc.push(t);
            t=t.left;
        }
        TreeNode top=getSmall();
        int c=1;
        while(c!=k){
            top=getSmall();
            c++;
        }
        return top.val;

    }
}