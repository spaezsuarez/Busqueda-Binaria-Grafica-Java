package algorithms;

public class BusquedaBinaria {

    private double formula;
    private static double contador = 0;

    /*public Double searchRecursive(double[] arr, int i, int j, double element) {

        contador += 1;

        if (i >= j) {
            return null;
            
        }else{
            int index = (int) ((i + j) / 2);
            contador += 4;

            if (element == arr[index]) {
                return arr[index];
            }
            contador += 2;
            if (arr[index] > element) {
                return searchRecursive(arr, i, index - 1, element);
            }else{
                return searchRecursive(arr, index + 1, j, element);
            }
        }

    }*/
    public Double searchRecursive(double[] arr,int izq,int der,double element){
        int m;
        contador++;
        if (izq > der) {
            return null;
        } else {
            contador += 5;
            m = (int) ((izq + der) / 2);
            if (element == arr[m]) {
                return arr[m];
            } else {
                contador += 2;
                if (element < arr[m]) {
                    return searchRecursive(arr, izq, m - 1, element);
                } else {
                    return searchRecursive(arr, m + 1, der, element);
                }
            }
        }
    
    }

    public Double searchIterative(double[] arr, int i, int j, double element) {

        contador = 0;

        while (i <= j) {
            int index = (int) ((i + j) / 2);
            double pivote = arr[index];

            contador += 6;

            if (pivote == element) {
                contador += 2;
                return pivote;
            }
            contador += 1;

            if (pivote < element) {
                contador += 3;
                i = index + 1;
            } else {
                contador += 2;
                j = index - 1;
            }

            contador += 1;
        }

        return null;

    }

    public void setFormula(int size) {
        formula = 7 + (10 * (Math.log(size)));
        //formula = 7 + (10*(Math.log(size)));
        //formula = 8*((Math.log(size)/Math.log(2))+1);
        //formula = Math.log(size)/Math.log(2);
    }

    public double getFormula() {
        return formula;
    }

    public void setContador(int contador) {
        this.contador = 0;
    }

    public static double getContador() {
        return contador;
    }

}
