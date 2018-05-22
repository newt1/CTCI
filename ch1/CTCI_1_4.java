import java.util.*; 

public class MyClass {
    public static void main(String args[]) {
        //an algorithm to determine if the string is a permutation of a palindrome 
        //there are two ways we can do this: 
            //1) place string in a char array and sort the letters, count partition of unique letters, 
                //make sure all even, only one may be odd -> n log n time, constant space 
            //2) use a hashset to count pairs, only one letter can be odd --> linear time, linear space 

        //I will implement 2) 

        String str = "Tact Coa"; //note we will have to make it undercase first, we also ignore spaces for thsi question 

        System.out.println(isPalin(str));
    }
    
    public static boolean isPalin(String str) { 
        if(str == null) return false; 
        
        str = str.toLowerCase(); 
        
        HashSet<Character> set = new HashSet<Character>(); 
        for(int i=0; i<str.length(); i++) { 
            if(!set.contains(str.charAt(i)) && str.charAt(i) != ' ') { 
                set.add(str.charAt(i));    
            } else { 
                set.remove(str.charAt(i));    
            }
        }
        
        return set.size() < 2 ? true : false; 
    }
}
