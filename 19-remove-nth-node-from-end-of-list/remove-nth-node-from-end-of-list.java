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
    public ListNode removeNthFromEnd(ListNode head, int n) {

        int len=length(head);
         if (len== n) {
            return head.next;
        }
        int l=length(head)-n;
        ListNode temp=head;
         for (int i = 1; i < l; i++) {
            temp = temp.next;
        }
       
       temp.next=temp.next.next;
       return head;
    }
    public int length(ListNode head){
        int l=0;
        while(head!=null){
            l++;
            head = head.next;
        }
        return l;
    }
}