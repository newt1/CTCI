import java.util.*; 

public class MyClass {
    public static void main(String args[]) {
       //given two strings, write an algorithm to determine if one is a permutation of the other 
       
       //Note: we could move the two strings into character arrays and sort them like we did for 1.1, but we will solve 
       //it using a data structure this time 
       
       String str1 = "racecar";
       String str2 = "carrace"; 
       String str3 = "guccibelt"; 
       String str4 = "guccibe"; 
       
       System.out.println(isPermutation(str1, str2)); 
    }
    
    public static boolean isPermutation(String str1, String str2) { 
        if(str1 == null || str2 == null || str1.length() != str2.length()) return false; 
        
        HashMap<Character, Integer> map = new HashMap<Character, Integer>(); 
        for(int i=0; i<str1.length(); i++) { 
            if(!map.containsKey(str1.charAt(i))) {  //n time 
                map.put(str1.charAt(i), 1); 
            } else { 
                int count = map.get(str1.charAt(i)); 
                map.put(str1.charAt(i), count+1);
            }
        }
        
        
        for(int i=0; i<str2.length(); i++) { 
            if(!map.containsKey(str2.charAt(i))) {      //n time 
                return false; 
            } else if (map.get(str2.charAt(i)) > 1) { 
                int count = map.get(str2.charAt(i)); 
                map.put(str2.charAt(i), count-1);
            } else { 
                map.remove(str2.charAt(i));    
            }
        }
        
        return map.isEmpty() ? true : false; 
    }
}
