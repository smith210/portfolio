// Author : Martin Smith
// Description : CSCI 145, Lab 2
// Date : April 13th 2017
// Assignment : AsciiEncryptor

// import the scanner function
import java.util.*;

public class AsciiEncryptor {

   //declare the main function
   public static void main (String[]args){
      
      //  ask the user to input anything
      Scanner console = new Scanner(System.in);
      System.out.print("Please enter an input: ");
      String userInput = console.nextLine();
      
      //print out the encrypted message
      System.out.print("Your secret code is: " + encrypt(userInput));
   }
   
   // declare the function that will encrpt the string
   public static String encrypt(String s) {
      
      //declare an empty string so that when the for loop is declared, the empty string will fill with values
      String newStatement = (" ");
      
      //have a for loop to determine each character in the input
      for (int variable = 0; variable < s.length(); variable++){
         char value = s.charAt(variable);
         int ascii = value;
         newStatement = (ascii + newStatement);
      
      }
   //return the new string
   return newStatement;
   
   }
   
}