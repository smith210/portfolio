/*
Name: Martin Smith
CSCI 241 - Winter 2018
Date: February 1st 2018
File: HeapMaxTest.java
*/
import java.util.*;

public class HeapMaxTest{

   public static final int SIZE = 10;
   //declare heap
   public static final HeapMax newHeap = new HeapMax(SIZE);

   //insert num into heap
   public static void insert(int num){
      newHeap.insert(num);
      System.out.println("Insert " + num);
   }
   
   //print out the heap
   public static void displayHeap(){
      System.out.print("Current heap is: ");
      newHeap.display();
      System.out.println("");
   }
   
   //remove max num from heap
   public static void remove(){
      System.out.println("Remove max.");
      newHeap.removeMaxHelper();
   }
   
   
   /*Test case 1
   what it will do:
      Insert the following numbers in respective order:
      1, 29, 7, 24, 5, 10, 2.
      Max will be removed during the after the fourth and sixth
      insertion.
   */
   public static void exampleOne(){
      //insert first number, and display heap.
      insert(1);
      displayHeap();
      
      //insert second number
      insert(29);
      displayHeap();
      
      //insert third number
      insert(7);
      displayHeap();
      
      //insert fourth number
      insert(24);
      displayHeap();
      
      //delete max, return new heap
      remove();
      displayHeap();
     
      //insert fifth number
      insert(5);
      displayHeap();
      
      //insert sixth number
      insert(10);
      displayHeap();
      
      //delete max, return new heap
      remove();
      displayHeap();
      
      //insert seventh number
      insert(2);
      displayHeap();
   }
   //Test case 2
   public static void exampleTwo(){
   
   }
   /*//Test case 3
   public static void exampleThree(){
   
   }
   */
   //main method
   public static void main(String[]args){

      //print out statement to let user know that the test is starting
      System.out.println("Testing of HeapMax starts.");
      //perform example 1
      exampleOne();

      //perform example 2
      //exampleTwo();
      //perform example 3
      //exampleThree();
      //print out statement to let user know that the test has finished
      System.out.println("Testing of HeapMax ends.");
   }

}
