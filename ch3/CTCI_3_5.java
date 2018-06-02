public class MyClass {
    public static void main(String args[]) {
        
        MinStack s = new MinStack(); 	//note that we can call public methods from other classes
        s.push(1); 						//stack1.push is different from minStack.push
        s.push(0); 
        s.push(-2);
        s.push(-1);
        
        s.pop(); 
        s.pop(); 
        s.pop();

        System.out.println(s.peek().data);
    }
}


class MinStack { 
    int size; 
    Stack stack1;
    Stack stack2; 
    
    public MinStack() { 
        this.stack1 = new Stack(); 
        this.stack2 = new Stack();
    }
    
    public void push(int data) { 
        while(!stack1.isEmpty() && stack1.getTop().data < data) { 
            stack2.push( stack1.pop().data );   
        }
        
        stack1.push(data); 
        
        while(!stack2.isEmpty()) { 
            stack1.push( stack2.pop().data );    
        }
        
        this.size++; 
    }
    
    public Node pop() { 
        if(stack1.size == 0) return null; 
        
        Node temp = stack1.getTop(); 
        stack1.pop(); 
        this.size--; 
        return temp; 
    }
    
    public Node peek() { 
        return stack1.getTop();    
    }
    
    public boolean isEmpty() { 
        return stack1.isEmpty();    
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
        if(this.top == null) return null; 
        else { 
            Node temp = this.top; 
            this.top = this.top.next;
            this.size--; 
            return temp; 
        }
    }
    
    public int getSize() { 
        return this.size;    
    }
    
    public boolean isEmpty() { 
        return this.size == 0 ? true : false;    
    }
    
    public Node getTop() { 
        return this.top;    
    }
}


class Node { 
    int data; 
    Node next; 
    
    public Node(int data) { 
        this.data = data;    
    }
}
