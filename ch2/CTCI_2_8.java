import java.util.*;

public class MyClass {
    public static void main(String args[]) {
      
      //find node that is the beginning of a linked list loop 
      
      ListNode head = new ListNode(3); 
      head.next = new ListNode(5); 
      head.next.next = new ListNode(8);
      head.next.next.next = new ListNode(5);
      head.next.next.next.next = new ListNode(4); 
      head.next.next.next.next.next = new ListNode(10); 
      
      head.next.next.next.next.next.next = head.next.next; //loop starts at 8 
       
      System.out.println(findLoop(head).data);  //if no loop then return null
    }
    
    public static ListNode findLoop(ListNode node) { 
        if(node == null) return null; 
        
        ListNode walker = node; 
        ListNode runner = node; 
        
        while(runner.next != null && runner.next.next != null) { 
            walker = walker.next;
            runner = runner.next.next; 
            
            if(walker == runner) { 
                walker = node; 
                
                while(runner != walker) { 
                    runner = runner.next; 
                    walker = walker.next; 
                }
                return walker; 
            }
        }
        
        return null; 
    }
}

class ListNode {
    int data; 
    ListNode next; 
    
    public ListNode (int data) { 
        this.data = data;    
    }
}
