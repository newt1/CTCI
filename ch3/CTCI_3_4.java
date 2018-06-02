public class MyClass {
    public static void main(String args[]) {
        Queue q = new Queue(); 
        q.enq(1);
        q.enq(2);
        q.enq(3); 
        
        q.deq(); 
        q.deq();
        q.deq(); 
        q.deq();
        
        System.out.println(q.getFirst() == null ? "Empty" : q.deq().data); 
    }
}


class Queue { 
    int size; 
    Stack stack1;
    Stack stack2; 
    
    public Queue() { 
        this.stack1 = new Stack();
        this.stack2 = new Stack(); 
    }
    
    public void enq(int data) { 
        this.stack1.push(data); 
        this.size++; 
    }
    
    public Node deq() {  
        if(this.stack1.size == 0 && this.stack2.size == 0) return null; 
        else if(this.stack2.size == 0) { 
            while(this.stack1.size > 0) { 
                this.stack2.push( this.stack1.pop().data );   
            }
            this.size--; 
            return this.stack2.pop(); 
        } else { 
            this.size--; 
            return this.stack2.pop();    
        }
    }
    
    public int getSize() { 
        return this.size;    
    }
    
    public Node getFirst() { 
        return this.stack2.top;
    }
}


class Stack { 
    int size; 
    Node top; 
    
    public Stack() { 
        this.size = 0; 
        this.top = null; 
    }
    
    public void push(int data) { 
        if(this.top == null) { 
            this.top = new Node(data);     
        } else { 
           Node temp = new Node(data); 
           temp.next = this.top; 
           this.top = temp; 
        }
        
        this.size++; 
    }
    
    public Node pop() {
        if(this.top == null) { 
            return null; 
        } else { 
            Node popped = this.top; 
            this.top = this.top.next;
            this.size--; 
            return popped; 
        }
    }
}

class Node { 
    int data; 
    Node next; 
    
    public Node(int data) { 
        this.data = data;    
    }
}
