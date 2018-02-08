/*
Name: Martin Smith
CSCI 241 - Winter 2018
Date: February 1st 2018
File: HeapMaxApp.java
*/
import java.util.*;

public class HeapMaxApp{
   //declare the size of matrix
   public static final int SIZE = 15;
   
   public static final HeapMax newHeap = new HeapMax(SIZE);
   
   //required method: kthBiggest
   public static int kthBiggest(int[][]matr, int k){
      for (int i = 0; i < SIZE; i++){
         newHeap.insert(matr[k][i]);
      }
      return newHeap.getMax();
   }
   
   public static void displayStartStatement(int[][]matr){
      System.out.println("Testing of kthBiggest starts.");
      System.out.println("The given matrix is: ");
      System.out.println("");
      
      for (int i = 0; i < SIZE; i++){
         for (int j = 0; j < SIZE; j++){
            if(j+1 == SIZE){
               System.out.print(matr[i][j]);
            }else{
               System.out.print(matr[i][j] + ", ");
            }
         }
         System.out.println("");
         
      }
      System.out.println("");
   }
   
   public static void displayEndStatement(int set, int max){
      set = set+1;
      System.out.println("The biggest element of Experiment " + set + " is " + max + ".");
      System.out.println("Testing of kthBiggest ends.");
   }
   
   //main method
   public static void main(String[]args){
      //create blank template of an array
      int [][] coolMatrix = new int[SIZE][SIZE];
      //for loop to fill in matricies with random numbers
      for (int i = 0; i < SIZE; i++){
         for (int j = 0; j < SIZE; j++){
            coolMatrix[i][j] = (int)(Math.random()*100);
         }
      }
      
      int randomSet = (int)(Math.random()*SIZE);
      
      displayStartStatement(coolMatrix);
      
      int breadwinner = kthBiggest(coolMatrix, randomSet);
      
      displayEndStatement(randomSet, breadwinner);
      
      
   }

}