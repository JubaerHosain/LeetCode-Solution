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
    public ListNode addTwoNumbers(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(0);
        ListNode result = head;
        int carry = 0;
        
        while(list1 != null || list2 != null){
            int x = (list1 != null)? list1.val : 0;
            int y = (list2 != null)? list2.val : 0;
            
            int sum = x+y+carry;
            carry = sum/10;
            result.next = new ListNode(sum%10);
            result = result.next;
            
            if(list1 != null){
                list1 = list1.next;
            }
            if(list2 != null){
                list2 = list2.next;
            }
        }
        
        if(carry > 0){
            result.next = new ListNode(carry);
        }
        
        return head.next;
    }
    
}
