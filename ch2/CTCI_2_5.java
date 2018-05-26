import java.util.*;

public class MyClass {
    public static void main(String args[]) {
      
      //add two linked lists 
      
      ListNode head = new ListNode(9); 
      head.next = new ListNode(9); 
      head.next.next = new ListNode(9); 
      
      ListNode head2 = new ListNode(1); 
      head2.next = new ListNode(9); 
      
      
       ListNode current = addLists(head, head2);  
      
      while(current.next != null) { 
        System.out.println(current.data);
        current = current.next;   
      }
      System.out.println(current.data); 
    }
    
    public static ListNode addLists(ListNode node1, ListNode node2) { 
        if(node1 == null && node2 == null) return null; 
        
        return helper(node1, node2, 0); 
    }
    
    public static ListNode helper(ListNode node1, ListNode node2, int carry) { 
        if(node1 == null && node2 == null && carry == 0) return null; 
        
        int value = carry; 
        
        if(node1 != null) { 
            value += node1.data;    
        }
        
        if(node2 != null) { 
            value += node2.data;
        }
        
        ListNode current = new ListNode(value % 10); 
        
        if(node1 != null || node2 != null) { 
            ListNode tail = helper(node1 == null ? null : node1.next, node2 == null ? null : node2.next, value > 9 ? 1 : value);
            
            current = append(tail, current); 
        }
        
        return current; 
    }
    
    public static ListNode append(ListNode tail, ListNode head) { 
        if(tail == null) return head;
        
        head.next = tail; 
        return head; 
    }
}

class ListNode {
    int data; 
    ListNode next; 
    
    public ListNode (int data) { 
        this.data = data;    
    }
}
