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
      //insert element at the end of the heap
      data.add(element);
      //set i equal to the value where element is
      //pointing at in heap
      int i = data.size()-1;  

      //check if i is on a lower level. If so, loop until
      //i is on first level.
      while ((i-1)%2 >= 0){
         //compare the values of parent and child. If
         //child is bigger than parent, swap values.
         if (data.get(i) > data.get((i-1)/2)){

            data.set(i, data.get((i-1)/2));
            
            data.set((i-1)/2, element);
         }
         //set a new value of i
         i = ((i-1)/2);
      }
   }
   
   //getMax():
   //returns the biggest value in the heap
   public int getMax(){
      //if there's nothing in heap, return -1.
      if(data.size() == 0){
         return -1;
      }else{
         return data.get(0);
      }
   }
   
   //removeMax():
   //removes the max value, and returns a new max value
   public int removeMax(){
      //if no elements in heap, return -1
      if(data.size() == 0){
         return -1;
      //if trying to remove last element in data, only remove.
      //return -1.
      }else if(data.size() == 1){
         data.remove(data.size()-1);
         return -1;
      }else{
         removeMaxHelper();
         return data.get(0);
      }
   }
   
   //removeMaxHelper():
   //replaces max value with the lowest number in heap,
   //and removes the lowest number in the heap.
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
      
      //loop through the heap until there are no more children
      while ((2*num)+1 < data.size()){
         //find the biggest child
         int maxChildIndex = maxChild(num);
         
         //compare values of parent and child. If child is bigger
         //than parent, swap the two values.
         if (data.get(num) < data.get(maxChildIndex)){
            int temp = data.get(maxChildIndex);
            data.set(maxChildIndex, data.get(num));
            data.set(num, temp);
         }
         //start the next while loop at the child
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

      //if the data.size() is 0 or null, print error statement
      if (data.size() == 0){
         System.out.print("ERROR - NO ELEMENTS IN HEAP");
      }

      //accumulator value to determine where levels end
      int acc = 1;
      
      //loop through the heap
      for(int i = 0; i < data.size(); i++){
         
         //base case: if the number is the last in heap, print
         //out only the number
         if(i+1 == data.size()){
            System.out.print(data.get(i));
         }else{

            if (data.size() > 1){
               //print out the number being pointed at in heap
               System.out.print(data.get(i));
            
               //if at the end of a level, print a comma then a space.
               //else, print only a space.
               if (i+2 == (int)Math.pow(2,acc)){
                  System.out.print(", ");
                  acc = acc+1;
               }else{
                  System.out.print(" ");
               }     
            }
         }

      }
      System.out.println(".");
   }
}