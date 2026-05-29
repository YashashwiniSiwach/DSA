/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        int l=0;
        ListNode se=head;
        ListNode fi=head;
        while (se != null && se.next != null) {
    se = se.next.next;
    fi = fi.next;

    if (fi == se) {
        l = lengthCycle(fi);
        break;
    }
}
        if(l==0){
            return null;
        }
         ListNode s=head;
        ListNode f=head;
        while(l>0){
            s=s.next;
            l--;
        }
        while(f!=s){
           f= f.next;
            s=s.next;
        }
        return s;

    }
    public int lengthCycle(ListNode head) {
    ListNode fast = head;
    ListNode slow = head;

    while (fast != null && fast.next != null) {
        fast = fast.next.next;
        slow = slow.next;

        if (fast == slow) {
           
            ListNode temp = slow;
            int length = 0;

            do {
                temp = temp.next;
                length++;
            } while (temp != slow);

            return length;
        }
    }

    return 0;
}
}