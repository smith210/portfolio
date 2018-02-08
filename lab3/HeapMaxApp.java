/*
Name: Martin Smith
CSCI 241 - Winter 2018
Date: February 1st 2018
File: HeapMaxApp.java
*/
import java.util.*;

public class HeapMaxApp{
   //declare the size of matrix
   public final int SIZE = 3;
   public final int [][] coolMatrix = new int[0][SIZE]
   
   //randomArray method
   //What it does: returns random unsorted integer array
    public static int[] randomArray(int num){
   //create empty array
      int[] createArray = new int [num];
   //for loop to get each of the random int values
       for(int i = 0; i < num; i++){
      //Pick random index
         int randomNum = (int)(Math.random()*1000);
      //append the array
         createArray[i] = randomNum;
      }
   //return the randomized array
      return createArray;
   }
   
   //main method
   public static void main(String[]args){
      //create blank template of an array

      //for loop to fill in matricies with random numbers
      for (int i = 0; i > SIZE; i++){
         coolMatrix[0][i] = randomArray(SIZE);
      }
   }

}