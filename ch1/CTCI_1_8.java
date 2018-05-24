import java.util.*; 

public class MyClass {
    public static void main(String args[]) {
        
        //this version uses O(1) space, we use the top row, and the first column as reference
        
        int[][] arr = { {1,1,1,0}, {1,0,1,1}, {1,1,1,1}, {1,1,0,1} }; 
        zeroMatrix(arr); 

        System.out.println(Arrays.deepToString(arr));
    }
    
    public static void zeroMatrix(int[][] arr) { 
        if(arr == null) return; 
        
        //find zeros 
        for(int i=0; i<arr.length; i++) { 
            for(int j=0; j<arr[0].length; j++) { 
                if(arr[i][j] == 0) { 
                    arr[i][0] = 0; 
                    arr[0][j] = 0; 
                }
            }
        }
        
        
        //make zero matrix 
        for(int i=1; i<arr.length; i++) {       //fill rows 
            if(arr[i][0] == 0) {
                for(int j=1; j<arr[0].length; j++) { 
                    arr[i][j] = 0;    
                }
            }   
        }
        
        for(int j=1; j<arr.length; j++) {   //fill columns 
            if(arr[0][j] == 0) {    
                for(int i=1; i<arr.length; i++) { 
                    arr[i][j] = 0;    
                }
            }   
        }
        
        if(arr[0][0] == 0) { 
            for(int j=1; j<arr[0].length; j++) { 
                arr[0][j] = 0;   
            }
        }
        
        return; 
    }
}
