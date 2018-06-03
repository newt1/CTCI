public class MyClass {
    public static void main(String args[]) {
        Queue q = new Queue();  //we assume user only inputs D or C 
        q.enq('D'); 			//the constraints are that the size can only get up to Integer.MAX_LENGTH
        q.enq('D'); 			//using a global index will allows for O(1) dequeue on any circumstance 
        q.enq('C'); 			//enqueue is O(N), we focus on having O(1), but it comes with tradeoffs to consider
        q.enq('C');
        q.enq('D'); 
        
        q.deqAny(); 
        q.deqAny(); 
        q.deqAny(); 
        q.deqAny(); 
        q.deqAny(); 
        q.deqAny(); 
        
        System.out.println();
    }
}

class Queue { 
    int size; 
    Node dogQ;
    Node catQ; 
    int globalIndex; 
    
    public void enq(char animal) { 
        if(animal == 'D') { 
           dogQ = pushHelper(dogQ, globalIndex, animal); 
        } else { 
            catQ = pushHelper(catQ, globalIndex, animal); 
        }
    }
    
    public Node pushHelper(Node head, int index, char animal) { 
        if(head == null) { 
            head = new Node(index, animal); 
        } else { 
            Node temp = head; 
            while(temp.next != null) { 
                temp = temp.next;    
            }
            
            temp.next = new Node(index, animal); 
        }
        
        this.globalIndex++; 
        this.size++; 
        return head; 
    }
    
    public Node deqAny() { 
        if(dogQ == null && catQ == null) return null; 
        if(dogQ == null) { 
        		catQ = catQ.next; 
            return deqHelper(catQ);
        }
        if(catQ == null) { 
        		dogQ = dogQ.next; 
            return deqHelper(dogQ);
        }
        
        if(catQ.index < dogQ.index) {
        		catQ = catQ.next;
            return deqHelper(catQ);
        } else { 
        		dogQ = dogQ.next; 
            return deqHelper(dogQ);
        }
    }
    
    public Node deqHelper(Node head) { 
        Node temp = head; 
        this.size--; 
        return temp; 
    }
    
    public Node deqDog() { 
        if(dogQ == null) return null; 
        dogQ = dogQ.next; 
        return deqHelper(dogQ);
    }
    
    public Node deqCat() { 
        if(catQ == null) return null; 
        catQ = catQ.next; 
        return deqHelper(catQ);
    }
}

class Node { 
    Node next;
    int index; 
    char animal; 
    
    public Node(int index, char animal) { 
        this.index = index; 
        this.animal = animal; 
    }
}
