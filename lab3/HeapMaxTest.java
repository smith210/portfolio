/*
Name: Martin Smith
CSCI 241 - Winter 2018
Date: February 1st 2018
File: HeapMaxTest.java
*/
import java.util.*;

public class HeapMaxTest{

   public static final int SIZE = 3;

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
      currHeap.removeMaxHelper();
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
      //insert first number, and display heap.
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
   public static void exampleTwo(HeapMax heap){
   
   }
   /*//Test case 3
   public static void exampleThree(HeapMax heap){
   
   }
   */
   //main method
   public static void main(String[]args){
      //declare heap
      HeapMax newHeap = new HeapMax(SIZE);
      //print out statement to let user know that the test is starting
      System.out.println("Testing of HeapMax starts.");
      System.out.println("");
      //perform example 1
      System.out.println("Testing for Example 1 starting...");
      exampleOne(newHeap);
      System.out.println("Testing for Example 1 finished.");
      System.out.println("");
      //perform example 2
      //System.out.println("Testing for Example 2 starting...");
      //exampleTwo(newHeap);
      //System.out.println("Testing for Example 2 finished.");
      //System.out.println("");
      //perform example 3
      //System.out.println("Testing for Example 3 starting...");
      //exampleThree(newHeap);
      //System.out.println("Testing for Example 3 finished.");
      //System.out.println("");
      //print out statement to let user know that the test has finished
      System.out.println("Testing of HeapMax ends.");
   }

}
