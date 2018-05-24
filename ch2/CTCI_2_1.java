import java.util.*;

public class MyClass {
    public static void main(String args[]) {
      
      //remove duplicates from an unsorted linked list
      
      ListNode head = new ListNode(1); 
      head.next = new ListNode(3); 
      head.next.next = new ListNode(2); 
      head.next.next.next = new ListNode(1); 
      head.next.next.next.next = new ListNode(2); 
      head.next.next.next.next.next = new ListNode(3); 
      
       removeDups(head); 
      
      ListNode current = head; 
      while(current.next != null) { 
        System.out.println(current.data);
        current = current.next;   
      }
      System.out.println(current.data); 
    }
    
    public static void removeDups(ListNode head) { 
        if(head == null) return; 
        
        ListNode current = head;
        ListNode temp = head; 
        HashSet<Integer> set = new HashSet<Integer>();
        set.add(current.data); 
        
        while(current != null && current.next != null) { 
            if(!set.contains(current.next.data)) { 
                set.add(current.next.data); 
            } else { 
                while(temp.next != null && set.contains(temp.next.data)) { 
                    temp = temp.next; 
                }
                
                if(set.contains(temp.data)) { 
                    temp = temp.next;    
                }
                
                current.next = temp; 
            }
        
            if(current == null || temp == null) return; 
            current = current.next; 
            temp = temp.next; 
        }
        
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
