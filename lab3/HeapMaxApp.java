/*
Name: Martin Smith
CSCI 241 - Winter 2018
Date: February 1st 2018
File: HeapMaxApp.java
*/
import java.util.*;

public class HeapMaxApp{
   //declare the size of matrix
   public static int SIZE = 0;
   
   //required method: kthBiggest
   public static int kthBiggest(int[][]matr, int k){
      //create a new heap
      HeapMax newHeap = new HeapMax(SIZE);
      
      //insert values of the set into the heap
      for (int i = 0; i < SIZE; i++){
         newHeap.insert(matr[k][i]);
      }
      //retrieve the max, and return that value.
      return newHeap.getMax();
   }
   
   public static void displayStartStatement(int[][]matr){
      System.out.println("Testing of kthBiggest starts.");
      System.out.println("The given matrix is: ");
      //print out matrix based on SIZE
      if(SIZE > 0){   
         System.out.println("");
         
         //first for loop iterates through rows
         for (int i = 0; i < SIZE; i++){
            //second for loop iterates through the column in the rows
            for (int j = 0; j < SIZE; j++){
               //if last in set, don't print a comma after it.
               //Otherwise, print a comma and a space.
               if(j+1 == SIZE){
                  System.out.print(matr[i][j]);
               }else{
                  System.out.print(matr[i][j] + ", ");
               }
            }
            //start a new line after each set
            System.out.println("");
            
         }
         System.out.println("");
      }
   }
   
   public static void displayEndStatement(int set, int max){
      //ERROR CASE: if nothing is in heap, return error statement
      if(max == -1){
         System.out.println("ERROR - NO ELEMENTS IN HEAP.");
      }else{
         set = set+1;
         System.out.println("The biggest element of Experiment " + set + " is " + max + ".");
      }
      System.out.println("Testing of kthBiggest ends.");
   }
   
   //main method
   public static void main(String[]args){
      //make sure there's an arguement on the command line and it's an int.
      try{
         SIZE = Integer.parseInt(args[0]);
      } catch (NumberFormatException e) {
         System.err.println("Arguement " + args[0] + " must be an integer.");
         System.exit(1);
      }
      //make sure that the matrix is in bounds of an array.
      if(SIZE >=0){
         //create blank template of an array
         int [][] coolMatrix = new int[SIZE][SIZE];
         //for loop to fill in matricies with random numbers
         for (int i = 0; i < SIZE; i++){
            for (int j = 0; j < SIZE; j++){
               coolMatrix[i][j] = (int)(Math.random()*100);
            }
         }
         
         //set a random number to pick which set is to be sorted through
         int randomSet = (int)(Math.random()*SIZE);
         
         //print start statement
         displayStartStatement(coolMatrix);
         
         //find the biggest value of the set in the matrix
         int breadwinner = kthBiggest(coolMatrix, randomSet);
         
         //print end statement
         displayEndStatement(randomSet, breadwinner);
      }else{
         //print error statement if SIZE is negative
         System.out.println("ERROR - SIZE SET NON-EXISTENT. Cannot start kthBiggest.");   
      }
      
   }

}