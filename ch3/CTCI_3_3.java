public class MyClass {
    public static void main(String args[]) {
        
        Stack stack = new Stack(); 
        stack.push(5); 
        stack.push(1);
        stack.push(3);
        stack.push(2);
        stack.push(0);
        System.out.println(stack.getMin() != null ? stack.getMin().data : null);
        
        stack.pop(); 
        System.out.println(stack.getMin() != null ? stack.getMin().data : null);

        stack.pop();
        System.out.println(stack.getMin() != null ? stack.getMin().data : null);

        stack.pop();
        System.out.println(stack.getMin() != null ? stack.getMin().data : null);

        stack.pop(); 
        System.out.println(stack.getMin() != null ? stack.getMin().data : null);

        stack.pop(); 
        System.out.println(stack.getMin() != null ? stack.getMin().data : null);


        System.out.println(stack.top);
    }
    

}

class MinStack { 
	int size; 
	Node top; 
	
	public MinStack() { 
		this.size = 0; 
		this.top = null;
	}
}

class Stack { 
    int size; 
    Node top; 
    MinStack minStack = new MinStack(); 
    
    public Stack() { 
        this.size = 0; 
        this.top = null; 
    }
    
    public void push(int data) { 
        if(this.top == null) { 
            this.top = new Node(data); 
            this.minStack.top = new Node(data); 
            this.minStack.size++; 
            this.size++; 
            return; 
        } else { 
            Node newNode = new Node(data); 
            newNode.next = this.top; 
            this.top = newNode; 
            if(data < this.minStack.top.data) { 
                Node minNode = new Node(data); 
                minNode.next = this.minStack.top; 
                this.minStack.top = minNode; 
                this.minStack.size++; 
            }
            this.size++; 
            return; 
        }
    }
    
    public void pop() { 
        if(this.top == null) return; 
        
        if(this.top.data == this.minStack.top.data) { 
            this.minStack.top = this.minStack.top.next; 
            this.minStack.size--; 
        }
        this.top = this.top.next; 
        this.size--;
        return; 
    }
    
    public int size() { 
        return this.size;    
    }
    
    public Node getMin() { 
        if(this.minStack.top == null) return null; 
        return this.minStack.top; 
    }
}

class Node { 
    int data; 
    Node next; 
    
    public Node(int data) { 
        this.data = data;    
    }
}
