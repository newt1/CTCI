import java.util.*; 

public class MyClass {
    public static void main(String args[]) {
        
        int[][] arr = { {1,1,1,0}, {1,0,1,1}, {1,1,1,1}, {1,1,0,1} }; 
        zeroMatrix(arr); 

        System.out.println(Arrays.deepToString(arr));
    }
    
    public static void zeroMatrix(int[][] arr) { 
        if(arr == null) return; 
        
        
        HashSet<Integer> setRows = new HashSet<Integer>(); 
        HashSet<Integer> setCols = new HashSet<Integer>(); 
        
        //find zeros 
        for(int i=0; i<arr.length; i++) { 
            for(int j=0; j<arr[0].length; j++) { 
                if(arr[i][j] == 0) { 
                    setRows.add(i);
                    setCols.add(j);
                }
            }
        }
        
        //make zero matrix 
        for(Integer key : setRows) { 
            for(int j=0; j<arr[0].length; j++) { 
                arr[key][j] = 0;    
            }
        }
        
        for(Integer key : setCols) { 
            for(int i=0; i<arr.length; i++) { 
                arr[i][key] = 0;    
            }
        }
        
        return; 
    }
}
