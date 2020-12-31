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
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode prev = new ListNode(-1, null);
        prev.next = head;
        ListNode newHead = prev;
        
        while(prev.next != null && prev.next.next != null){
            ListNode first = prev.next;
            ListNode second = first.next;
            ListNode next = second.next;
            
            second.next = first;
            first.next = next;
            prev.next = second;
            
            prev = first;
        }
        
        return newHead.next;
    }
}
