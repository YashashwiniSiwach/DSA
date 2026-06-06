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
    public boolean isPalindrome(ListNode head) {
      ListNode s=head;
      ListNode m=mid(head);
      ListNode sh=reverse(m);
      ListNode temp=sh;
      while(temp!=null){
        if(temp.val!=s.val){
            return false;
        }
        temp=temp.next;
        s=s.next;
      }
      return true;
      
         
    }
    public ListNode mid(ListNode head){
        ListNode s=head;
        ListNode f=head;
        while(f!=null && f.next!=null){
            s=s.next;
            f=f.next.next;
            
        }
        return s;
    }
    public ListNode reverse(ListNode head){
        ListNode prev=null;
        ListNode curr=head;
        while(curr!=null){
        ListNode next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
        }
        return prev;
    }

}