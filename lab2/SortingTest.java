//Name : Martin Smith
//CSCI 241 - Winter 2018
//Date : January 25th 2018
//File : SortingTest.java

import java.util.*;

public class SortingTest {

   public static final int SIZE_ARRAY = 3;

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
  
//print method
//What it does: prints out the array being used
   public static void printArr(int[] array, int cur){

     if(cur != SIZE_ARRAY-1){
      System.out.print(array[cur] + ", ");
     }else{
      System.out.print(array[cur]);
     }

   } 
  
//display method
//What it does: based on which sorting method is being done,
//it will return the type of sort to be printed
   public static String display(int sortMethod){
      String typeSort = "";
      //if 0: insertSort
      if (sortMethod == 0){
         typeSort = "insertionSort";
      //if 1: quickSort
      }else if (sortMethod == 1){
         typeSort = "quickSort";
      //if 2: mergeSort
      }else{
         typeSort = "mergeSort";
      }
      return typeSort;
   }
  
  
//main method
  public static void main (String[] args){
      
      
      for(int sortMethod = 0; sortMethod < 3; sortMethod++){
         int[] arr = randomArray(SIZE_ARRAY);
         
         String sortType = display(sortMethod);
         //Testing for sort, will print out test statement
         System.out.println("Testing for " + sortType + "...");
         //print out array
         System.out.print("The generated array for this test is: [");
         for (int i = 0; i < SIZE_ARRAY; i++){
           printArr(arr, i);
         }
         System.out.println("]");
         
         //generate an empty array in order to save the value of the array when it's sorted
         int[] arr_sort = new int[SIZE_ARRAY];
         //generate values for the time
         long startTime, endTime, totalTime;
         
         //start the clock, and record the time
         startTime = System.currentTimeMillis();
         if(sortMethod == 0){
            arr = SortingPack.insertionSort(arr);
            
         } else if (sortMethod == 1){
            SortingPack.quickSort(arr, 0, arr.length-1);
            
         } else {
            arr = SortingPack.mergeSort(arr);
            
         }
         //calculate end time, record the stop time, then calculate time it took
         endTime = System.currentTimeMillis();
         totalTime = endTime - startTime;
         
         //Print out information for user to read about time it took to sort, and print out
         //sorted array.
         System.out.println("Time it took to sort array: " + totalTime + " milliseconds.");
         System.out.print("The sorted array for ths test is: [");
         for (int j = 0; j < SIZE_ARRAY; j++){
            printArr(arr, j);
         }
         System.out.println("]");
         System.out.println("Testing for " + sortType + " finished.");
         System.out.println("");
      }

  }

}
