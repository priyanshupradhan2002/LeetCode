//{ Driver Code Starts
// driver

import java.io.*;
import java.util.*;


// } Driver Code Ends
/* node for linked list

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

*/
class Solution {
    public static Node reverse(Node head)
    {
        Node curr = head;
        Node prev = null;
        Node next = null;
        
        while(curr != null)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev;
    }
    static Node addTwoLists(Node num1, Node num2) {
        // code here
             int carry = 0;
        
        Node rev1 = reverse(num1);
        Node rev2 = reverse(num2);
        
        Node head = null;
        Node tail = head;
        
        while(rev1 != null || rev2 != null || carry != 0)
        {
            int val1 = 0;
            int val2 = 0;
            if(rev1 != null) val1 = rev1.data;
            if(rev2 != null) val2 = rev2.data;
            
            int sum = val1 + val2 + carry;
           
            int digit = sum % 10;
            carry = sum / 10;
            Node temp = new Node(digit);
            
            if(head == null)
            {
                head = temp;
                tail = temp;
            }
            else
            {
                tail.next = temp;
                tail = temp;
            }
            
            if(rev1 != null) rev1 = rev1.next;
            if(rev2 != null) rev2 = rev2.next;
        }
        
        
        Node result = reverse(head);
        
        while(result != null)
        {
            if(result.data != 0)
            break;
            result = result.next;
        }
        
        return result;
    }
}

// class Solution {
//     static Node addTwoLists(Node num1, Node num2) {
//         // Reverse both linked lists to process them from the least significant digit
//         num1 = reverse(num1);
//         num2 = reverse(num2);

//       Node dummy = new Node(0);
//         Node current = dummy;
//         int carry = 0;
//         // Process both lists until all digits and carry are handled
//       while (num1 != null || num2 != null || carry != 0) {
//             int val1 = (num1 != null) ? num1.data : 0;
//             int val2 = (num2 != null) ? num2.data : 0;
//             int sum = val1 + val2 + carry;

//             carry = sum / 10;
//             current.next = new Node(sum % 10);
//             current = current.next;

//             // Move to the next nodes if available
//             if (num1 != null) num1 = num1.next;
//             if (num2 != null) num2 = num2.next;
//         }

//         // Reverse the result to get the correct order
//         return reverse(dummy.next);
//     }

//     // Function to reverse a linked list
//     public static Node reverse(Node head) {
//         Node prev = null;
//         Node current = head;

//         while (current != null) {
//             Node nextNode = current.next; // Save the next node
//             current.next = prev;         // Reverse the current node's pointer
//             prev = current;              // Move prev to current
//             current = nextNode;          // Move current to the next node
//         }

//         return prev; // Return the new head of the reversed list
//     }
// }


//{ Driver Code Starts.

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class GfG {

    static void printList(Node n) {
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(read.readLine());
        while (T-- > 0) {

            String str[] = read.readLine().trim().split(" ");
            int n = str.length;

            Node num1 = new Node(Integer.parseInt(str[0]));
            Node tail = num1;
            for (int i = 1; i < n; i++) {
                int val = Integer.parseInt(str[i]);
                tail.next = new Node(val);
                tail = tail.next;
            }

            String str2[] = read.readLine().trim().split(" ");
            int m = str2.length;

            Node num2 = new Node(Integer.parseInt(str2[0]));
            tail = num2;
            for (int i = 1; i < m; i++) {

                tail.next = new Node(Integer.parseInt(str2[i]));
                tail = tail.next;
            }

            Solution g = new Solution();
            Node res = g.addTwoLists(num1, num2);
            printList(res);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends