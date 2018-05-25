import java.util.*;

public class MyClass {
    public static void main(String args[]) {
      
      //remove a node from linked list, given access to that node -- assume we never are asked to delete start or end node
      //so must be of at least size 3  
      
      ListNode head = new ListNode(1); 
      head.next = new ListNode(2); 
      head.next.next = new ListNode(3); 
      head.next.next.next = new ListNode(4); 
      head.next.next.next.next = new ListNode(5); 
      head.next.next.next.next.next = new ListNode(6); 
      
       deleteMidNode(head.next.next.next);  //access to 4, delete 4 
      
      ListNode current = head; 
      while(current.next != null) { 
        System.out.println(current.data);
        current = current.next;   
      }
      System.out.println(current.data); 
    }
    
    public static void deleteMidNode(ListNode node) { 
        if(node == null) return; 
        
        ListNode current = node; 
        while(current.next.next != null) { 
            current.data = current.next.data; 
            current = current.next;    
        }
        
        current.data = current.next.data;
        current.next = current.next.next; 
        
        return; 
    }
}

class ListNode {
    int data; 
    ListNode next; 
    
    public ListNode (int data) { 
        this.data = data;    
    }
}
