import java.util.*;

public class MyClass {
    public static void main(String args[]) {
      
      //check if a linked list is a palindrome 
      
      ListNode head = new ListNode(9); 
      head.next = new ListNode(1); 
      head.next.next = new ListNode(2);
      head.next.next.next = new ListNode(3);
      head.next.next.next.next = new ListNode(2); 
      head.next.next.next.next.next = new ListNode(1); 
      head.next.next.next.next.next.next = new ListNode(9); 
       
       System.out.println(isPalindrome(head));
       
       ListNode current = head; 
      
      while(current.next != null) { 
        System.out.println(current.data);
        current = current.next;   
      }
      System.out.println(current.data); 
    }
    
    public static boolean isPalindrome(ListNode node) { 
        if(node == null) return true; 
        
        int size = 0; 
        int i = 0; 
        
        ListNode current = node; 
        while(current.next != null) {
            size++; 
            current = current.next; 
        }
        size++; //guaranteed size of at least 1 
        
        int[] arr = new int[size]; 
        current = node; 
        
        while(current.next != null) { 
            arr[i] = current.data; 
            current = current.next; 
            i++; 
        }
            arr[i] = current.data; 
        
        for(int j=0; j<arr.length/2; j++) { 
            if(arr[j] != arr[arr.length-1-j]) return false; 
        }
        return true; 
    }
}

class ListNode {
    int data; 
    ListNode next; 
    
    public ListNode (int data) { 
        this.data = data;    
    }
}
