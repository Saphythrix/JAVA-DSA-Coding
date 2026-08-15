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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        List<List<Integer>> res=new ArrayList<>();
        if(root==null){
            return res;
        }
        q.add(root);
        int lr=0;
        while(!q.isEmpty()){
            int lvlsize=q.size();
           List<Integer> temp=new ArrayList<>();
            while(lvlsize!=0){
                TreeNode t=q.remove();
                temp.add(t.val);
                
                if(t.left!=null){
                    q.add(t.left);
                }
                if(t.right!=null){
                    q.add(t.right);
                }
                lvlsize--;
            }
            if(lr==1){
                    Collections.reverse(temp);
            }
            res.add(temp);
            lr=1-lr;
        }
        return res;
    }
}