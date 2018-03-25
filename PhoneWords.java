// Author : Martin Smith
// Description : CSCI 145, Lab 2
// Date : April 27th 2017
// Assignment : PhoneWords

//import the scanner function
import java.util.*;

//START OF CODE
public class PhoneWords {
   
   //Start of Main Method
   public static void main(String[]args){
         
      //print statement asking user to input their numbers
      System.out.println("Please enter a phone number: ");
      
      //have a scanner system that will evaluate their numbers
      Scanner asking = new Scanner(System.in);
      
      //have a sanity check to ensure the only input is numbers
      while (!asking.hasNextInt()){
         asking.next();
         System.out.println("Your response is invalid, your input must only have numbers.");
         System.out.println("Please enter a phone number: ");
      }
      
      //save the user's input as a string
      String phoneNumber = asking.next();
      
      //invoke method printAllPhoneWords with the user's input
      printAllPhoneWords(phoneNumber);
     
   }
   //End of Main Method

   
   
   //Start of printAllPhoneWords Method
   public static void printAllPhoneWords(String phonenumber){
      //have a count variable
      int count = phonenumber.length();
      String empty = ("");
           
      
      
      
      //declare method turnIntoLetters with the parameter of phonenumber
      char [][] newPhoneNumber = {
      {' '},
      {'1'},
      {'a','b','c'},
      {'d','e','f'},
      {'g','h','i'},
      {'j','k','l'},
      {'m','n','o','p'},
      {'q','r','s'},
      {'t','u','v'},
      {'w','x','y','z'}
      };
      
      //declare method allLettersPrinted with parameters of newPhoneNumber and int count
      allLettersPrinted(newPhoneNumber, count, empty, phonenumber);      
   
   }
   //End of printAllPhoneWords Method
   
   
   //Start of allLettersPrinted Method
   //Function of the Method: to print out all the available characters
   public static void allLettersPrinted(char[][]letterList, int size, String prefix, String userInput){

      
      //base case   
      if (size == 0){
         System.out.println(prefix);
      //not base case, will determine what it will print out
      }else{
         char num = userInput.charAt(0);
         
         int newNum = Character.getNumericValue(num);
         

         
         for(int i = 0; i < letterList[newNum].length; i++){
            String newPrefix = prefix + letterList[newNum][i];//concatenation to add on the word
            allLettersPrinted(letterList, size-1, newPrefix, userInput.substring(1));//recursion to evaluate each number
            
         }
      }     
   
   }
   //End of allLettersPrinted Method
   
   
   


}
//END OF CODE