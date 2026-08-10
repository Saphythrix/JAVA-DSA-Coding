/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reverse(ListNode left,int size){
        ListNode curr=left;
        ListNode prev=null;
        while(size!=0){
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
            size--;

        }
        return ;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode left=head;
        ListNode prevleft=null;
        ListNode res=null;
        ListNode right;
        while(true){
            right=left;
            for(int i=0;i<(k-1);i++){
                if(right==null){
                    break;
                }
                right=right.next;
            }
            if(right!=null){
                ListNode nextleft=right.next;
                reverse(left,k);
                if(prevleft!=null){
                    prevleft.next=right;
                }
                prevleft=left;
                if(res==null){
                    res=right;
                }
                left=nextleft;
            }
            else{
                if(prevleft!=null){
                    prevleft.next=left;
                }
                if(res==null){
                    return left;
                }
                break;
            }
        }
        return res;
    }
}