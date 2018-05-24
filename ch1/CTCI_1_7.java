import java.util.*; 

public class MyClass {
    public static void main(String args[]) {
        
        //rotate a matrix in place, in this case 90 degrees clockwise 
        //note: with linear algebra, we recognize the solution to be a tranpose, and then a vertical flip 
       
        int[][] arr = { {1,2,3}, {4,5,6}, {7,8,9} };
        rotateMatrix(arr);
        
        System.out.println(Arrays.deepToString(arr));
    }
    
    public static void rotateMatrix(int[][] arr) { 
        if(arr == null) return; 
        
        //transpose
        HashSet<String> set = new HashSet<String>(); 
        for(int i=0; i<arr.length; i++) { 
            for(int j=0; j<arr[0].length; j++) { 
                if(!set.contains(i + " " + j) || !set.contains(j + " " + i)) { 
                    int temp = arr[i][j]; 
                    arr[i][j] = arr[j][i]; 
                    arr[j][i] = temp; 
                    
                    set.add(i + " " + j); 
                    set.add(j + " " + i); 
                } else { 
                    //don't swap    
                }
            }
        }
        
        //vertical flip 
        for(int i=0; i<arr.length; i++) { 
            for(int j=0; j<arr[0].length/2; j++) { 
                int temp = arr[i][j]; 
                arr[i][j] = arr[i][arr[0].length-1-j]; 
                arr[i][arr[0].length-1-j] = temp; 
            }
        }
        
        return; 
    }
}
