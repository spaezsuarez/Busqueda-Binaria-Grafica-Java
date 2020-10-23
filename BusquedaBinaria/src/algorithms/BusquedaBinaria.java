package algorithms;

public class BusquedaBinaria {

    private double formula;
    private double contador = 0;
    
    public Double searchRecursive(double[] arr, int i, int j, double element) {
        
        contador = 0;
        int index  = (int)((i+j)/2);
        double pivote = arr[index];
        contador += 1;

        if (j >= i) {
            contador += 1;
            if (pivote == element) {
                contador += 2;
                return pivote;
            }
            contador += 1;
            if (pivote > element) {
                contador += 2;
                return searchRecursive(arr, i, index - 1, element);
            }
            contador += 2;
            return searchRecursive(arr, index + 1, j, element);

        }
        
        contador += 1;
        return null;

    }
    
     public Double searchIterative(double[] arr, int i, int j, double element) {
        
        contador = 1;

        while(i <= j){
            int index  = (int)((i+j)/2);
            double pivote = arr[index];
            
            contador += 6;
            
            if(pivote == element){
                contador += 2;
                return pivote;
            }
            contador += 1;
            
            if(pivote < element){
                contador += 3;
                i = index + 1;
            }else{
                contador += 2;
                j = index - 1;
            }
            
            contador += 1;
        }
        
        return null;

    }
    
    public void setFormula(int size){
        //formula = 7 + (10*(Math.log(size)/Math.log(2)));
        formula = 7 + (10*(Math.log(size)));
        //formula = 8*((Math.log(size)/Math.log(2))+1);
        //formula = Math.log(size)/Math.log(2);
    }
    
    public double getFormula(){
        return formula;
    }
    
    public double getContador(){
        System.out.println("Contador: " + contador);
        return contador;
    }

}
