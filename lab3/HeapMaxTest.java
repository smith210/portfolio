/*
Name: Martin Smith
CSCI 241 - Winter 2018
Date: February 1st 2018
File: HeapMaxTest.java
*/
import java.util.*;

public class HeapMaxTest{

   //insert num into heap
   public static void insert(int num, HeapMax currHeap){
      currHeap.insert(num);
      System.out.println("Insert " + num + ".");
      displayHeap(currHeap);
   }
   
   //print out the heap
   public static void displayHeap(HeapMax heap){
      System.out.print("Current heap is: ");
      heap.display();
   }
   
   //remove max num from heap
   public static void remove(HeapMax currHeap){
      System.out.println("Remove max.");
      currHeap.removeMax();
      displayHeap(currHeap);
   }
   
   /*Test case 1
   what it will do:
      Insert the following numbers in respective order:
      1, 29, 7, 24, 5, 10, 2.
      Max will be removed during the after the fourth and sixth
      insertion.
   */
   public static void exampleOne(HeapMax heap){
      //insert first number
      insert(1, heap);
      
      //insert second number
      insert(29, heap);
      
      //insert third number
      insert(7, heap);
      
      //insert fourth number
      insert(24, heap);
      
      //delete max, return new heap
      remove(heap);
     
      //insert fifth number
      insert(5, heap);
      
      //insert sixth number
      insert(10, heap);
      
      //delete max, return new heap
      remove(heap);;
      
      //insert seventh number
      insert(2, heap);
   }
   
   //Test case 2
   /*
   what it will do: have at least 4 full levels (15 numbers).
   Will alternate starting with big and small values, 
   removes max at intervals of 5 numbers, leaving
   total numbers in tree of 17. Have 1 extra insert
   at last interval of a num already inserted prior.
   */
   public static void exampleTwo(HeapMax heap){
      //first set of inserts
      //small --> large
      insert(2, heap);
      insert(8, heap);
      insert(14, heap);
      insert(20, heap);
      insert(26, heap);
      remove(heap);
      
      //second set of inserts
      //large --> small
      insert(27, heap);
      insert(21, heap);
      insert(15, heap);
      insert(9, heap);
      insert(3, heap);
      remove(heap);
      
      //third set of inserts
      //small --> large
      insert(5, heap);
      insert(11, heap);
      insert(17, heap);
      insert(23, heap);
      insert(29, heap);
      remove(heap);
      
      //fourth set of inserts (has extra insert)
      //large --> small
      insert(30, heap);
      insert(24, heap);
      insert(18, heap);
      insert(12, heap);
      insert(6, heap);
      insert(2, heap);
      remove(heap);
      
      
   }
   
   //Test case 3
   /*
   What it will do: build 5 levels (31 numbers)
   Build over, and remove consistently until
   no numbers remain, then insert one number back
   into heap.
   */
   public static void exampleThree(HeapMax heap){
      //insert 40 random numbers
      for (int curr=0; curr < 40; curr++){
         int randomNum = (int)(Math.random()*250);
         insert(randomNum, heap);
      }
           
      //remove all elements in heap (plus an extra)
      for(int count = 0; count < 41; count++){
         remove(heap);
      }
      
      //add a new element to the heap
      insert(42, heap);
          
   }
   
   //main method
   public static void main(String[]args){
     
      int SIZE = 3;
   
      //declare empty heaps for each example
      HeapMax newHeap1 = new HeapMax(SIZE);
      HeapMax newHeap2 = new HeapMax(SIZE);
      HeapMax newHeap3 = new HeapMax(SIZE);
      //print out statement to let user know that the test is starting
      System.out.println("Testing of HeapMax starts.");
      System.out.println("");
      //perform example 1
      System.out.println("Testing for Example 1 starting...");
      exampleOne(newHeap1);
      System.out.println("Testing for Example 1 finished.");
      System.out.println("");
      //perform example 2
      System.out.println("Testing for Example 2 starting...");
      exampleTwo(newHeap2);
      System.out.println("Testing for Example 2 finished.");
      System.out.println("");
      //perform example 3
      System.out.println("Testing for Example 3 starting...");
      exampleThree(newHeap3);
      System.out.println("Testing for Example 3 finished.");
      System.out.println("");
      //print out statement to let user know that the test has finished
      System.out.println("Testing of HeapMax ends.");
   }

}
