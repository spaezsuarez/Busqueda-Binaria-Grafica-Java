package algorithms;


public class SelectionSort {
    
    
    public static void init(double[] a){
    
        int N = a.length;
        
        for(int i = 0; i < N/2; i++){ // 3 OE
           
            int minimo = i;// 1 OE
            for(int j = i+1; j < N-i; j++){ // 2 OE
                
                if(a[j] < a[minimo]){ // 3 OE
                    minimo = j; // 1 OE
                    
                }
            }
            
            if(i != minimo){ // 1 OE
                double temp = a[i]; // 2 OE
                a[i] = a[minimo]; // 3 OE
                a[minimo] = temp; // 2 OE
                
            }
        }
       
    }
}
