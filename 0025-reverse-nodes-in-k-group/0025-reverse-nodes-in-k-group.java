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
    public ListNode reverseKGroup(ListNode head, int k) 
    {
        if(k==1 && head==null)
         return head;
         int length=getLength(head);

         if(length<k)
          return head;
        int count=0;
        ListNode prev=null;
        ListNode next=null;
        ListNode curr=head;

        while(curr!=null && count<k)
        {
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
            //length--;
           count++;
        }
       if(next!=null)
       {
        head.next=reverseKGroup(next,k);
       }

       return prev;
    }
     public static int getLength(ListNode head)
     {
      {
        int count=0;
        while(head!=null)
        {
            count++;
            head=head.next;
        }
        return count;
       }
     }
       
    
}