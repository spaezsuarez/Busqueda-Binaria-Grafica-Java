package controllers;

import java.util.ArrayList;
import algorithms.BusquedaBinaria;
import algorithms.QuickSort;

public class NumbersController {

    private ArrayList<Double> rangeX = new ArrayList<>(), rangeY = new ArrayList<>();
    private double[] numbers;
    private BusquedaBinaria busquedaBinaria;

    public NumbersController() {
        busquedaBinaria = new BusquedaBinaria();
    }

    public ArrayList<Double> getRangeX() {
        return rangeX;
    }

    public ArrayList<Double> getRangeY() {
        return rangeY;
    }

    public void setNumRangeX(double x) {
        rangeX.add(x);
    }

    public void setNumRangeY(double y) {
        rangeY.add(y);
    }

    public void initNumbers(int n) {

        numbers = new double[n+1];

        for (int i = 0; i < n+1; i++) {
            numbers[i] = Math.floor(Math.random() * (n - 0 + 1) + 0);;
        }

        QuickSort.init(0,n,numbers);
        
        for(double s:numbers){
            System.out.print(s + " ");
        }
        System.out.println("\n");

    }

    public void start(int n) {

        initNumbers(n);
        int element = (int) (Math.random() * n);
        
        busquedaBinaria.setContador(0);
        busquedaBinaria.searchRecursive(numbers, 0, n, numbers[element]);
        busquedaBinaria.setFormula(n);

        rangeX.add(Double.parseDouble(String.valueOf(n)));
        rangeY.add(BusquedaBinaria.getContador());

    }

    public void resetRanges() {
        rangeX.clear();
        rangeY.clear();
    }

}
