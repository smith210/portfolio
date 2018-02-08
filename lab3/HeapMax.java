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
   
   //insert(int element):
   //adds element to the heap, and sorts it accordingly
   public void insert(int element){
      data.add(element);
      int i = data.size()-1;  


      while ((i-1)%2 >= 0){
 
         if (data.get(i) > data.get((i-1)/2)){

            data.set(i, data.get((i-1)/2));
            
            data.set((i-1)/2, element);
         }
         
         i = ((i-1)/2);
      }
   }
   
   //getMax():
   //returns the biggest value in the heap
   public int getMax(){
      return data.get(0);
   
   }
   
   //removeMax():
   //removes the max value, and returns a new max value
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
   
   //heapify(int num):
   //The parent looks at the children. If the eldest child
   //is bigger than the parent, switch values in the tree.
   //Do this until parent is bigger than eldest child.
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
   
   //maxChild(int num):
   //compare the two children, return the biggest.
   public int maxChild(int num){
      //set values of children accordingly
      int cl = 2*num + 1;
      int cr = 2*num + 2;
      
      //makes sure there is a child right
      //if not, return child left.
      if(data.size() <= cr){
         return cl;
      }
      
      //compare both children, and return the
      //bigger one.
      if (data.get(cl) > data.get(cr)){
         return cl;
      }else{
         return cr;
      }
   }
   
   //display():
   //Displays the heap, and seperates the levels with commas and numbers with spaces.
   //Ends the heap with a period.
   public void display(){
      //accumulator value to determine where levels end
      int acc = 1;
      
      for(int i = 0; i < data.size(); i++){
         if(i+1 == data.size()){
            System.out.print(data.get(i));
         }else{
         
            if (data.size() > 1){
               System.out.print(data.get(i));
            

               if (i+2 == (int)Math.pow(2,acc)){
                  System.out.print(", ");
                  acc = acc+1;
               }else{
                  System.out.print(" ");
               }     
            }
         }
         //System.out.println(acc);
         //System.out.println(i);
      }
      System.out.println(".");
   }
}