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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left==right){
            return head;
        }
        ListNode ptr=head;
        ListNode preptr=null;
        int pos=1;
        while(pos<left){
            preptr=ptr;
            ptr=ptr.next;
            pos++;
        }
        ListNode curr=ptr;
        ListNode prev=null;
        int times=right-left+1;
        while(times!=0){
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
            times--;
        }
        ptr.next=curr;
        if(preptr!=null){
            preptr.next=prev;
            
            return head;
        }
        return prev;
        
    }
}