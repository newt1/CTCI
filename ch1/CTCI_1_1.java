public class MyClass {
    //implement an algorithm to determine if a string has all unique characters, no data structures 
    
    public static void main(String args[]) {
    
        String str1 = "aaabbbc";  //not unique
        String str2 = "abcdef";     //unique
        

        System.out.println(isUnique(str2));
    }
    
    public static boolean isUnique(String str) { 
        if(str == null || str.length() < 2) return true; 
        
        char[] charArray = str.toCharArray(); //n time 
        Arrays.sort(charArray); //n log n time
        
        System.out.println( Arrays.toString(charArray) );
        
        for(int i=0; i<charArray.length-1; i++) {  //n time 
            if(charArray[i] == charArray[i+1]) return false;    
        }
        
        return true;                //total O(n + nlogn)
    }
}
