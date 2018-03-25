// Author : Martin Smith
// Description : CSCI 145, Lab 3
// Date : April 20th, 2017
// Assignment: TicTac

import java.util.*;

public class TicTac{
   public static final int SIZE = 3;
   
   
   //START OF MAIN METHOD
   public static void main (String[] args){
      
      // declare a board
      char[][] aBoard = new char[SIZE][SIZE];
      
      //initialize the the board to an empty board (initializeBoard method)
      initializeBoard(aBoard);
      
      //display the empty board to the players (displayBoard method)
      displayBoard(aBoard);
      
      //prompt the players which player wants to go first("X or O")
      
      System.out.println("Who wants to go first (X or O)?");
      Scanner input = new Scanner(System.in);
      
      // evaluate if the user inputted "X" or "O", else give the player
      // a warning statement
      while (!input.hasNext("X") & !input.hasNext("O")) {
         input.next();
         System.out.println("INVALID PLAYER OPTION");
         System.out.println("Who wants to go first (X or O)?");
      }
      
      
      // once the player has correctly inputted "X" or "O", save that value
      String firstPlayer = input.next();
      char atPlayer = firstPlayer.charAt(0);
      
      // take turns to make moves, before each move prompt for target position
      // after each move, check if there is a winner and display the board
      
      // You have to come up with a logic to call the other defined methods here 
      
      //have an increment value, that will evaluate the player's turns
      int count = 1;
      
      //have a while loop that will keep the game running until someone wins
      //(if there's a tie, the while loop will break - how it breaks is explained further
      // down the while statement).
      while (!findWinner(aBoard)){
                  
         //with the starting if statement, since the count
         //starts at 1, make sure the player's character is
         //the same as the first player.
         if (count % 2 != 0){
            char thePlayer = atPlayer;
            //invoke the game function, and count the turn when they finish
            getMove(aBoard, thePlayer);
            count ++;
         }else{
            // when the first player's turn is over, depending on the 
            // first player's token, switch their token.
            if (atPlayer == 'X'){
               char thePlayer = 'O';
               //invoke the game function, and count the turn when they finish
               getMove(aBoard, thePlayer);
               count ++;
            }else if (atPlayer == 'O'){         
               char thePlayer = 'X';
               //invoke the game function, and count the turn when they finish
               getMove(aBoard, thePlayer);
               count ++;
            }
         }
         // have an if statement, evaluating
         // if there are any spaces left. If there
         // aren't any, tell players there's a tie,
         // then break the while loop.
         if (hasEmptyCell(aBoard)){
            System.out.println("It's a tie!");
            break; 
         }
      }
   }
   //END OF MAIN METHOD
   
   
   
   
   //START OF initializeBoard METHOD
   
   // Method: initializeBoard
   // Purpose: initialize each cell in the array with a blank space
   public static void initializeBoard(char[][] board){
      // in order to achieve to fill arrays with blank spaces,
      // fill with two for loops (one is nested)
      for (int i = 0; i < board.length; i++){
         for (int j = 0; j < board[i].length; j++){
            board[i][j] = (' ') ;
         }
      }
   }
   
   //END OF intializeBoard METHOD 
   
   
   //START OF displayBoard AND drawLine METHODS
   
   //Method: displayBoard
   //Purpose: display the current board on screen
   //This method has been provided to you.
   public static void drawLine() {
      for (int i = 0; i <= 4 * SIZE; i++) {  
         System.out.print("-");
      }
      System.out.println();
   }

   public static void displayBoard(char[][] board) {
      drawLine();
      for (int i = 0; i < board.length; i++) {
         for (int j = 0; j < board[i].length; j++) {
            System.out.print("| " + board[i][j] + " ");
         }
            System.out.println("|");
            drawLine();
         }
         System.out.println();
   }
   //END OF displayBoard AND drawLine METHODS
   
   
   //START OF getMove METHOD
   
   // Method : getMove
   // Purpose : to prompt the current player for a target position, and place the mark
   //          in the position if the position is available
   public static void getMove(char[][] board, char player){
      
      Scanner asking = new Scanner(System.in);
      
      //when asking a player for their space, make
      //sure that if they declare to put their token on a space
      //with a token already declared on it, make sure that the function
      //doesn't end that player's turn.
      
      //accomplish this with a boolean value and have it evaluate to make sure
      //that the player's choice of space does not have a token through a while loop.
      boolean occupiedSpace = true;
      
      while (occupiedSpace){
         // ask the user for the int for the row number
         System.out.println("Enter a row (0, 1, 2) for player " + player);
      
         // Make sure the player inputted 0, 1, or 2.
         // If the player did not enter any of those values, give the player a warning statement
         // based on their incorrect input.
         while(!asking.hasNext("0") & !asking.hasNext("1") & !asking.hasNext("2")){
            if (asking.hasNextInt()){
               asking.next();
               System.out.println("Numbers must be between 0 and 2");
            }else{
               asking.next();
               System.out.println("Please enter an integer (0-2)!");
            }
            System.out.println("Enter a row (0, 1, 2) for player " + player);
         }
         int rowChoice = asking.nextInt();
         
         // ask the user for the int for the col number
         System.out.println("Enter a col (0, 1, 2) for player " + player);
         
         // Make sure the player inputted 0, 1, or 2.
         // If the player did not enter any of those values, give the player a warning statement
         // based on their incorrect input.
         while(!asking.hasNext("0") & !asking.hasNext("1") & !asking.hasNext("2")){
            if (asking.hasNextInt()){
               asking.next();
               System.out.println("Numbers must be between 0 and 2");
            }else{
               asking.next();
               System.out.println("Please enter an integer (0-2)!");
            }
            System.out.println("Enter a col (0, 1, 2) for player " + player);
         }
         int colChoice = asking.nextInt();
         
         // Once the user has inputted a valid row and col value,
         // put the player's character on that tile.
         // (Before placing the tile, make sure the space is empty.)
         if (board[rowChoice][colChoice] == (' ')){
            board[rowChoice][colChoice] = player;
            occupiedSpace = false;
            displayBoard(board);
         }else{
            System.out.println("That square is already taken");
         }
      }
   }  
   
   //END OF getMove METHOD
   
   
   //START OF findWinner METHOD
   // Method : findWinner
   // Purpose : after each move, check the board and see if any player hass achieved
   //           a win.
   public static boolean findWinner(char[][] board){
      
      //GOAL: to determine whether after a move on the board,
      //      a player has won. The method will print out the
      //      winning statement based on whether they are 'X'
      //      or 'O'.
      
      //evaluate if the top row is complete
      if (board[0][0] == 'X' && board[0][1] == 'X' && board[0][2] == 'X'){
         System.out.println("X player won!");
         return true;
      }else if (board[0][0] == 'O' && board[0][1] == 'O' && board[0][2] == 'O'){
         System.out.println("O player won!");
         return true;
      
      //evaluate if the second row is complete
      }else if (board[1][0] == 'X' && board[1][1] == 'X' && board[1][2] == 'X'){
         System.out.println("X player won!");
         return true;
      }else if (board[1][0] == 'O' && board[1][1] == 'O' && board[1][2] == 'O'){
         System.out.println("O player won!");
         return true;
         
      //evaluate if the third row is complete
      }else if (board[2][0] == 'X' && board[2][1] == 'X' && board[2][2] == 'X'){
         System.out.println("X player won!");
         return true;
      }else if (board[2][0] == 'O' && board[2][1] == 'O' && board[2][2] == 'O'){
         System.out.println("O player won!");
         return true;
     
      //evaluate if the left column is complete
      }else if (board[0][0] == 'X' && board[1][0] == 'X' && board[2][0] == 'X'){
         System.out.println("X player won!");
         return true;
      }else if (board[0][0] == 'O' && board[1][0] == 'O' && board[2][0] == 'O'){
         System.out.println("O player won!");
         return true;
         
      //evaluate if the middle column is complete
      }else if (board[0][1] == 'X' && board[1][1] == 'X' && board[2][1] == 'X'){
         System.out.println("X player won!");
         return true;
      }else if (board[0][1] == 'O' && board[1][1] == 'O' && board[2][1] == 'O'){
         System.out.println("O player won!");
         return true;
         
      //evaluate if the right column is complete
      }else if (board[0][2] == 'X' && board[1][2] == 'X' && board[2][2] == 'X'){
         System.out.println("X player won!");
         return true;
      }else if (board[0][2] == 'O' && board[1][2] == 'O' && board[2][2] == 'O'){
         System.out.println("O player won!");
         return true;
      
      //evaluate if the diagonal (left-top to right-bottom) is complete
      }else if (board[0][0] == 'X' && board[1][1] == 'X' && board[2][2] == 'X'){
         System.out.println("X player won!");
         return true;
      }else if (board[0][0] == 'O' && board[1][1] == 'O' && board[2][2] == 'O'){
         System.out.println("O player won!");
         return true;
      
      //evaluate if the diagonal (right-top to left-bottom) is complete
      }else if (board[0][2] == 'X' && board[1][1] == 'X' && board[2][0] == 'X'){
         System.out.println("X player won!");
         return true;
      }else if (board[0][2] == 'O' && board[1][1] == 'O' && board[2][0] == 'O'){
         System.out.println("O player won!");
         return true;
      
      //if none of the winning sets are complete, return falsee
      }else{
         return false;
      }
   }
   
   //END OF findWinner METHOD
   
   
   //START OF hasEmptyCell METHOD
   
   // Method : hasEmptyCell
   // Purpose : check if there still are any empty spots on the board
   public static boolean hasEmptyCell(char[][] board){
      //have an increment value that will count the number of spaces
      //that are not occupied by a space
      int count = 0;
      
      for (int i = 0; i < board.length; i++){
         for (int j = 0; j < board[i].length; j++){
            if (board[i][j] != (' ')) {
               count ++;
            }
         }
      }
      
      //if all the spaces are filled (which will be shown when count=9)
      //, then return the function as true, else return false
      if (count == 9){
         return true;
      }else{
         return false;
      }
   }     
   //END OF hasEmptyCell METHOD

}