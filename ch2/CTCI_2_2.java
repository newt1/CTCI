import java.util.*;

public class MyClass {
    public static void main(String args[]) {
      
      //return the kth to last element of a singly linked list 
      
      //note: you won't know which is kth to last element, unless you scope the size of the list first 
      //will have to be 2 * O(n) --> O(n) solution 
      
      ListNode head = new ListNode(1); 
      head.next = new ListNode(3); 
      head.next.next = new ListNode(2); 
      head.next.next.next = new ListNode(1); 
      head.next.next.next.next = new ListNode(2); 
      head.next.next.next.next.next = new ListNode(3); 
      
       System.out.println(kthToLast(head, 2));
    }
    
    public static int kthToLast(ListNode head, int kth) { 
        if(head == null) return -1; 
        
        int size = 0; 
        ListNode current = head;
        while(current.next != null) { 
            size++; 
            current = current.next;    
        }
        
        size++; //guaranteed size of at least one 
        
        
        current = head; 
        while(current.next != null && size != kth) {
            size--; 
            current = current.next;   
        }
        
        return (size != kth) ? -1 : current.data; 
    }
}

class ListNode {
    int data; 
    ListNode next; 
    
    public ListNode (int data) { 
        this.data = data;    
    }
}
