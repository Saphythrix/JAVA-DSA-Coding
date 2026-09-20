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
    Stack<TreeNode> des=new Stack<>();
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
    public TreeNode getBig(){
        if(des.isEmpty()){
            return null;
        }
        TreeNode big=des.pop();
        TreeNode leftchild=big.left;
        while(leftchild!=null){
            des.push(leftchild);
            leftchild=leftchild.right;
        }
        return big;
    }
    public boolean findTarget(TreeNode root, int k) {
        if(root==null){
            return false;
        }
        TreeNode t=root;
        while(t!=null){
            asc.push(t);
            t=t.left;
        }
        t=root;
        while(t!=null){
            des.push(t);
            t=t.right;
        }
        TreeNode i=getSmall();
        TreeNode j=getBig();
        while((i!=null && j!=null) && (i.val<j.val) && (i!=j)){
            int sum=i.val+j.val;
            if(sum==k){
                return true;
            }
            else if(sum>k){
                j=getBig();
            }
            else{
                i=getSmall();
            }
        }
        return false;
    }
}