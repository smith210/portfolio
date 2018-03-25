// Author : Martin Smith
// Description : CSCI 145, Lab 2
// Date : April 13th 2017
// Assignment : PasswordChecker


//import the scanner utility before starting the program
import java.util.*;

public class PasswordChecker {
   
   
   // have the main function
   
   public static void main (String[]args){
      
      // have a while loop and a boolean value so user continues to input passwords until they type a valid one
      
      boolean validPassword = false;
      
      while (validPassword == false){
         
         //ask user for their password
         
         Scanner console = new Scanner(System.in);
         System.out.print("Please enter a password: ");
         String password = console.next();
         
         // have an if-else statement to determine if the user's password is a valid one
         // invoke the isValid function in order to do so

         //if the function returns false, print "Invalid Password!", else print "Valid Password!" and break while loop
         
         if (isValid(password) == false) {
            System.out.println("Invalid Password!");
         }else{
            System.out.println("Valid Password!");
            validPassword = true;
         }
      }
   }
   
   // have the boolean isValid function to evaluate the password based on its parameters,
   // and return the value as either true or false
   
   public static boolean isValid(String s){
      
      //declare the parameters needed to evaluate the password as false, so it can be later
      //referenced in the function
      boolean eightCharacters = false;
      boolean fourLetters = false;
      boolean twoDigits = false;
      boolean twoUppercase = false;
      boolean onlyLetterDigits = false;
   
      //to determine the number of letters, numbers, and uppercase letters in the password, have int countLetter,
      //int countDigit and int countUppercase equal 0
      int countLetter = 0;
      int countDigit = 0;
      int countUppercase = 0;
      
      //have a for loop that will evaluate each character in the password, and determine how many letters,      
      //digits, and uppercase letters there are in the password
      for (int start=0;start <= (s.length()-1);start++){
         //go through each character
         char value = s.charAt(start);
         
         //have an if statement to deterine if the said character is a letter
         if (Character.isLetter(value)){
            countLetter++;
         }
         if (Character.isDigit(value)){
            countDigit++;
         }
         if (Character.isUpperCase(value)){
            countUppercase++;
         }
      }
      
      //use if-else statements to evaluate if the password has satisified the parameters using the length() string method,
      //and the values outputted from the for loop
      if (s.length() >= 8) {
         eightCharacters = true;
      }
      
      if (countLetter >= 4) {
         fourLetters = true;
      }
      
      if (countDigit >= 2) {
         twoDigits = true;
      }
      
      if (countUppercase >= 2) {
         twoUppercase = true;
      }
      
      if (countLetter + countDigit == s.length()){
         onlyLetterDigits = true;
      }
      
      //if all boolean values are true, return true, else return false\
      if (eightCharacters == true && fourLetters == true && twoDigits == true && twoUppercase == true && onlyLetterDigits == true){
         return true;
      } else {
         return false;
      }   
   }
}