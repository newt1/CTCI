public class MyClass {
    public static void main(String args[]) {
    		SetOfStacks set = new SetOfStacks(); 
    		//we assume the stacks are limited to size of 10, the set of stacks is represented as a linked list 
    		//of stacks, so popAt will be a O(N) operation
    		
    		for(int i=1; i<25; i++) { 
    			set.push(i);
    		}
    		
    		for(int i=0; i<9; i++) { 
    			set.popAt(1);
    		}
    		
    		set.popAt(1);
    		
    		for(int i=0; i<9; i++) { 
    			set.popAt(1);
    		}
    		
    		set.popAt(1);
    		
    		System.out.println(set.getTop());
    }
    
}

class SetOfStacks { 
    int numberOfStacks; 
    Stack head; 
    
    public SetOfStacks() { 
        this.numberOfStacks = 0; 
    }
    
    public void push(int data) { 
        if(head == null) { 
            head = new Stack(); 
            
            pushHelper(head, data);
            this.numberOfStacks++;
            
        } else if (head.size == 10) { 
            Stack temp = new Stack(); 
            temp.next = head; 
            head = temp; 
            
            pushHelper(head, data);
            this.numberOfStacks++;
            
        } else { 
            pushHelper(head, data);
        }
    }
    
    public static void pushHelper(Stack head, int data) { 
        head.contents[ head.contents.length-1 - head.size ] = data; 
        head.size++; 
    }
    
    
    public int getTop() { 
        return head.contents[head.contents.length - head.size];    
    }
    
    public void pop() { 
        if(head == null) return; 
        
        if(head.size == 1) { 
            head = head.next; 
            numberOfStacks--;
        } else { 
            head.contents[head.contents.length - head.size] = 0;
            head.size--; 
        }
    }
    
    public void popAt(int index) {  //note that nothing will pop if index is over bound
    		if(head == null || index < 0) return; 
    		
    		if(index == 0) { 
    			pop(); 
    		} else { 
    			Stack current = head; 
    			
    			while(current != null && current.next != null) { 
    				if(index-1 == 0) { 
    					if(current.next.size == 1) { 
    						current.next = current.next.next; 
    						numberOfStacks--;
    					} else { 
    						current.next.contents[current.next.contents.length - current.next.size] = 0;
    			            current.next.size--; 
    					}
    				}
    				index--; 
    				current = current.next;
    			}	
    		}
    }
}

class Stack { 
    int size; 
    int[] contents;
    Stack next; 
    
    public Stack() { 
        this.contents = new int[10];
        this.size = 0; 
        this.next = null;
    }
}
