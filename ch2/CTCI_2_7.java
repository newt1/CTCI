import java.util.*;

public class MyClass {
    public static void main(String args[]) {
      
      //find intersection of linked 2 linked lists 
      
      ListNode head = new ListNode(3); 
      head.next = new ListNode(5); 
      head.next.next = new ListNode(8);
      head.next.next.next = new ListNode(5);
      head.next.next.next.next = new ListNode(4); 
      head.next.next.next.next.next = new ListNode(10); 
     
      ListNode head2 = new ListNode(2);
      head2.next = new ListNode(1); 
      head2.next.next = head.next.next.next;  //intersect 
       
      System.out.println(findIntersection(head, head2).data);  //if no intersection then return null
    }
    
    public static ListNode findIntersection(ListNode node, ListNode node2) { 
        if(node == null || node2 == null) return null; 
        
        ListNode current1 = node; 
        ListNode current2 = node2; 
        HashSet<ListNode> set = new HashSet<ListNode>(); 
        
        set.add(current1); 
        
        while(current1.next != null) { 
            set.add(current1.next); 
            current1 = current1.next;    
        }
        
        if(set.contains(current2)) { 
            return current2; 
        }
        
        while(current2.next != null) { 
            
            if(set.contains(current2.next)) { 
                return current2.next;   
            }
            
            current2 = current2.next; 
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
