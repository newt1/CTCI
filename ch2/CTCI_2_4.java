import java.util.*;

public class MyClass {
    public static void main(String args[]) {
      
      //partition a linked list 
      
      ListNode head = new ListNode(3); 
      head.next = new ListNode(5); 
      head.next.next = new ListNode(8);
      head.next.next.next = new ListNode(5);
      head.next.next.next.next = new ListNode(10); 
      head.next.next.next.next.next = new ListNode(2); 
      head.next.next.next.next.next.next = new ListNode(1); 
       
       ListNode current = partition(head, 5); 
      
      while(current.next != null) { 
        System.out.println(current.data);
        current = current.next;   
      }
      System.out.println(current.data); 
    }
    
    public static ListNode partition(ListNode node, int partition) { 
        if(node == null) return null; 
        
        ListNode current = node;
        ListNode ans = node; 
        
        while(current.next != null) { 
            
            if(current.next.data < partition) { 
                ListNode temp = new ListNode(current.next.data); 
                temp.next = ans; 
                ans = temp; 
                
                current.next = current.next.next; 
                continue;   //stay at same index to check for next
            }
            current = current.next;    
        }
        
        return ans; 
    }
}

class ListNode {
    int data; 
    ListNode next; 
    
    public ListNode (int data) { 
        this.data = data;    
    }
}
