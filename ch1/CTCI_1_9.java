import java.util.*; 

public class MyClass {
    public static void main(String args[]) {
       
       //an algorithm to determine if s2 is a rotation of s1
    
        String s1 = "waterbottle"; 
        String s2 = "erbottlewat"; 

        System.out.println(isRotatedString(s1, s2));
    }
    
    public static boolean isRotatedString(String s1, String s2) { 
        if(s1 == null || s2 == null) return false; 
        
        String s3 = s2+s2; 
        
        return s3.contains(s1) ? true : false; 
    }
}
