/*
Name: Martin Smith
CSCI 241 - Winter 2018
Date: February 1st 2018
File: HeapMax.java
*/
import java.util.*;


public class HeapMax{
   
   //define array that will be used in the class
   ArrayList<Integer> data;
   
   //constructor method
   //defines cap size of allowed elements for 
   //newly initialized object of the class
   public HeapMax(int size){
      if (size <= 0){
         size = 1;
      }
      data = new ArrayList<Integer>(size);
   }
   
   public void insert(int element){
      data.add(element);
      int i = data.size()-1;  
      
      if((i-1)/2 == 0){
         if (data.get(i) > data.get((i-1)/2)){

            data.set(i, data.get((i-1)/2));
            
            data.set((i-1)/2, element);
         }
      }
      
      while ((i-1)/2 > 0){
         
         
         if (data.get(i) > data.get((i-1)/2)){

            data.set(i, data.get((i-1)/2));
            
            data.set((i-1)/2, element);
         }
         i = ((i-1)/2);
      }
   }
   
   public int getMax(){
      return data.get(0);
   
   }
   
   public int removeMax(){
      removeMaxHelper();
      return data.get(0);
   }
   
   public void removeMaxHelper(){
      int value = data.get(data.size()-1);
      data.remove(data.size()-1);
      data.set(0, value);
      heapify(0);
   }
   
   public void heapify(int num){
      while ((2*num)+1 < data.size()){
         int maxChildIndex = maxChild(num);
         if (data.get(num) < data.get(maxChildIndex)){
            int temp = data.get(maxChildIndex);
            data.set(maxChildIndex, data.get(num));
            data.set(num, temp);
         }
         num = maxChildIndex;
      }
   }
   
   public int maxChild(int num){
      int cl = 2*num + 1;
      int cr = 2*num + 2;
      
      if(data.size() <= cr){
         return cl;
      }
      
      if (data.get(cl) > data.get(cr)){
         return cl;
      }else{
         return cr;
      }
   }
   
   public void display(){
      for(int i = 0; i < data.size(); i++){
         if(i+1 == data.size()){
            System.out.print(data.get(i));
         }else{
         
            if (data.size() > 1){
               System.out.print(data.get(i)+ " ");
            
               if (Math.sqrt(i+2)% 2 == 0 || i == 0){
                  System.out.print(", ");
               }      
            }
         }
      }
      System.out.print(".");
   }
}
