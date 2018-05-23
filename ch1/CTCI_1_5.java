public class MyClass {
    public static void main(String args[]) {
        //given two strings, write an algorithm to determine if they are one edit away from another 
        
        String str1 = "pale"; 
        String str2 = "ple"; 

        System.out.println(oneAway(str1, str2));
    }
    
    public static boolean oneAway(String str1, String str2) { 
        if(str1 == null || str2 == null || str1.length()-str2.length() > 1) return false; 
        
        if(str1.length() < str2.length()) { 
            return oneAway(str2, str1);    
        }
        
        int j = 0; 
        
        if(str1.length() == str2.length()) { 
            for(int i=0; i<str1.length(); i++) { 
                if(str1.charAt(i) != str2.charAt(i)) { 
                    j++;  
                } 
            }
            return (j < 2) ? true : false; 
        }
        
        for(int i=0; i<str1.length() && j<str2.length(); i++) { 
            if(str1.charAt(i) == str2.charAt(j)) { 
                j++;    
            } else { 
                //let i move    
            }
        }
        
        return (j >= str2.length()) ? true : false; 
    }
}
