import java.util.*; 

public class MyClass {
    public static void main(String args[]) {
        
        //basic string compression, return original if it did not help 
        
        String str = "aaaaabbbbcccccc"; 

        System.out.println(compressString(str));
    }
    
    public static String compressString(String str) { 
        if(str == null || str.length() < 3) return str; 
        
        int count = 1; 
        char letter = str.charAt(0); 
        StringBuilder ans = new StringBuilder(); 
        
        for(int i=1; i<str.length(); i++) { 
            if(str.charAt(i) == letter) { 
                count++;   
            } else { 
                ans.append(letter);
                ans.append(count); 
                count = 1; 
                letter = str.charAt(i); 
            }
        }
        
        //add last letter 
        ans.append(letter); 
        ans.append(count); 
        
        return ans.length() >= str.length() ? str : ans.toString(); 
    }
}
