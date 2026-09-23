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
    List<Integer> dairy=new ArrayList<>();
    List<List<Integer>> ans=new ArrayList<>();
    public void findSum(TreeNode root,List<Integer> dairy,int targetSum,List<List<Integer>> ans,int sum){
        if(root==null){
            return ;
        }
        sum=sum+root.val;
        dairy.add(root.val);
        if(root.left==null && root.right==null){
            if(sum==targetSum){
                ans.add(new ArrayList<>(dairy));
                dairy.remove(dairy.size()-1);
                return ;
            }
        }
        findSum(root.left,dairy,targetSum,ans,sum);
        findSum(root.right,dairy,targetSum,ans,sum);
        dairy.remove(dairy.size()-1);
        return ;
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        findSum(root,dairy,targetSum,ans,0);
        return ans;

    }
}