public class MyClass {
    public static void main(String args[]) {
        
        //replace spaces with %20, convert to char array, do the algorithm in-place, then type case to string and return 
        //we can assume the string input has enough spaces at the end 
        //here i assume there is one space between the words 
        
        //String str = "test swag  "; 
        String str = "Mr John Smith          "; 

        System.out.println(URLify(str, 13));
    }
    
    public static String URLify(String str, int trueLen) { 
        if(str == null) return str; 
        
        char[] arr = str.toCharArray(); 
        int shift = str.length()-1; 
        int i=str.length()-1; 
        
        while(trueLen > 0 && i>=0) { 
            
            if(str.charAt(i) == ' ') { 
                i--; 
            } else { 
                while(i >= 0 && str.charAt(i) != ' ') { 
                    arr[shift] = arr[i];
                    shift--; 
                    trueLen--; 
                    i--; 
                }
                
                
                if(trueLen == 0) { 
                		String ans = new String (arr);
                		return ans.substring(shift+1); 
                }
                
                arr[shift] = '0';
                arr[shift-1] = '2';
                arr[shift-2] = '%'; 
                
                //i = shift-3; //space right after %
                shift = shift-3; //reset 
                trueLen--;  //forgot to add last space
            }
        }
        
        String ans = new String (arr);
		return ans.substring(shift+1); 
    }
}
