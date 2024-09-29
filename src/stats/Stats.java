/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package stats;

import java.util.ArrayList;

/**
 *
 * @author hasnain
 */
public class Stats {

    public static void sortData(int[] num)
    {
        for (int i = 0; i < num.length; i++) 
        {
            for (int j = i+1; j <num.length ; j++)
            {
                //swap the values 
                if(num[i]>num[j]){
                int temp = num[j];
                num[j]= num[i];
                num[i]=temp;
                
                }
                
            }
            
        }
    }
    
    public static void displayDataSet(int[] num)
    {
         for (int i = 0; i < num.length; i++) 
         {
            System.out.print(" ,"+num[i]);
            
        }
        System.out.println("");
    }
    
    public static double roundoff(double num)
    {
        if(num%10>=5)
        {
            double roundoff = 10-(num%10);
            return num = num+roundoff;
        }
        num = num - (num%10);
        return num;
        
    }
    public static void main(String[] args) {
        ArrayList<Classe> classes = new ArrayList<Classe>(); 
        int[] num = {23,60,79,32,57,74,52,70,82,36,80,77,81,95,41,65,92,85,55
        ,76,52,10,64,75,78,25,80,98,81,67,41,71,83,54,64,72,88,62,74,43,60,78,89
        ,76,84,48,90,15,79,34,67,17,82,69,74,63,80,85,61};
        
        System.out.println("the data in original form is :");
        System.out.println("");
        
        displayDataSet(num);
        System.out.println("");
        
        int total_data = num.length;
        int total_frequency = 0;
        
       //the data is sorted via bubble sort 
        sortData(num);
        
        System.out.println("the data in sorted order is :");
        System.out.println("");
       
        displayDataSet(num);
        System.out.println("");
        
        int max = num[num.length-1];
        int min = num[0];
        
        System.out.println("the max of the data set is :"+max);
        System.out.println("the min of the data set is :"+min);
        System.out.println("");
        
        int range = max-min;
        System.out.println("tha range of the data set is :"+range);
        System.out.println("");
       
     
       
        double numOfClasses = 1 + 3.31 *(Math.log10(total_data));
        double roundoff_classes = Math.round(numOfClasses);
        
        System.out.println("teh number of classes in the data set will be :"+roundoff_classes);
        System.out.println("");
        
        
        double  widthOfIntervals = range/roundoff_classes;
        double roundoff_woi = Math.round(widthOfIntervals);
        
        System.out.println("the width of class intervals will be :"+roundoff_woi);
        System.out.println("");
        //creating classes
        
        
       double upperLimit = min +roundoff_woi;
        double lowerLimit= min;
        
        Classe class1 = new Classe(lowerLimit,upperLimit);
        classes.add(class1);
        for (int i = 0; i < roundoff_classes-1; i++) 
        {
            
            lowerLimit = upperLimit;
            upperLimit = lowerLimit + roundoff_woi;
            classes.add(new Classe(lowerLimit,upperLimit));
                        
            
        }
        
        //assigning data elements to classes created
        for(Classe clas:classes)
        {
            System.out.print(clas.lowerLimit +"---"+clas.highLimit+" : ");
            for (int i = 0; i < total_data; i++) 
            {
                if(num[i]>=clas.lowerLimit&&num[i]<clas.highLimit)
                {
                    clas.addClassItems(num[i]);
                    System.out.print(num[i]+" ,");
                }
                
            }
            total_frequency+= clas.frequency;
            System.out.print("    "+clas.frequency);
            System.out.println("");
        }
        
        System.out.println("total_frequency "+total_frequency);
        System.out.println("total data "+total_data);
    }
    
}



