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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) 
    {
        int carry=0;
        ListNode dummy=new ListNode(0);
        ListNode res=dummy;

        while(l1!=null || l2!=null)
        {
            int sum=carry+0;

            if(l1!=null)
            {
                sum+=l1.val;
                l1=l1.next;
            }
            if(l2!=null)
            {
                sum+=l2.val;
                l2=l2.next;
            }

            carry=sum/10;
            sum=sum%10;
            res.next=new ListNode(sum);
            res=res.next;

        }
        if(carry==1)
         res.next=new ListNode(1);

         return dummy.next;
    }
    public static ListNode reverse(ListNode head)
    {
        ListNode next=null;
        ListNode prev=null;
        ListNode curr=head;

        while(curr!=null)
        {
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
}