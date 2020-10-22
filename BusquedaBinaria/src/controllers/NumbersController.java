package controllers;

import java.util.ArrayList;

public class NumbersController {
    
    private ArrayList<Double> rangeX = new ArrayList<>(),rangeY = new ArrayList<>();
    
    
    public void initComponents(){
        for (int i = 0; i < 10; i++) {
            rangeX.add(Double.parseDouble(String.valueOf(i)));
            rangeY.add(Double.parseDouble(String.valueOf(i)));
        }
    
    }

    public ArrayList<Double> getRangeX() {
        return rangeX;
    }

    public ArrayList<Double> getRangeY() {
        return rangeY;
    }
   
    
    
    
    
}
