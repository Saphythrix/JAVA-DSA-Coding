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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null){
            return null;
        }
        int n=1;
        ListNode last=head;
        while(last.next!=null){
            n++;
            last=last.next;
        }
        k=k%n;
        if(k==0){
            return head;
        }
        int c=1;
        ListNode ptr=head;
        ListNode preptr=null;
        while(c<(n-k+1)){
            c++;
            preptr=ptr;
            ptr=ptr.next;
        }
        last.next=head;
        preptr.next=null;
        head=ptr;
        
        return head;
    }
    
}