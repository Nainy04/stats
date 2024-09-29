/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stats;

import java.util.ArrayList;


public class Classe{
    double lowerLimit;
    double highLimit;
    ArrayList<Integer> classItems;
    int frequency = 0;
    public Classe(double lowerlimit ,double upperlimit) 
    {
        this.lowerLimit = lowerlimit;
        this.highLimit = upperlimit;
        classItems = new ArrayList<Integer>();
    }
    
    public void addClassItems(int num){
        this.classItems.add(num);
        frequency++;
        
    }
    
    
    
}