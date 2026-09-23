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
    int wrong=0;
    TreeNode prev=null;
    TreeNode fw1,sw1,fw2,sw2;
    public void func(TreeNode root){
         if(root==null){
            return ;
        }
        func(root.left);
        if(prev==null){
            prev=root;
        }else{
            if(root.val<prev.val){
                if(wrong==0){
                    fw1=prev;
                    sw1=root;
                }else{
                    fw2=prev;
                    sw2=root;  
                }
                wrong++;
            }
            prev=root;
        }
        func(root.right);
        return ;
    }
    public void swap(TreeNode node1,TreeNode node2){
        int temp=node1.val;
        node1.val=node2.val;
        node2.val=temp;
    }
    public void recoverTree(TreeNode root) {
       func(root);
       if(wrong==1){
            swap(fw1,sw1);
       }else if(wrong==2){
            swap(fw1,sw2);
       }
       return ;
    }
}