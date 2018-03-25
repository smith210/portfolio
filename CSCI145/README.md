# CSCI145

### About:

Abstract data types, generics, access or pointer types, dynamic memory allocation, recursion, concurrent programming and linear data 
structures, including stacks, lists and queues. Programming is required in implementation of concepts. Lab.

### Files:

**lab1**

    Includes file primeNumber.java. Goal of the lab was to get used to the syntax of Java and being able to code in it. The program
lets the user know what the first 50 prime numbers are.

**lab2**

    Includes files PasswordChecker.java & AsciiEncryptor. Goal of the lab was to understand the Scanner class and the char class.
 The first program (PasswordChecker) asks the user to type a password, and the following have to be satisifed within the program
 to be able to be considered a "password":
      * Has 8 characters.
      * Contains only characters and integers.
      * Of the 8 characters, has 2 integers and four letters (2 being uppercase).
      
    If the program doesn't satisfy the cases, the program will let the user know their password is invalid, and have the user
keep typing in passwords until a correct one is inputted.

    The second program (AsciiEncryptor) asks the user for an input, and based on their input, the program will create an encrypted code,
which is based off of the ASCII values.
    
**lab3**

    Includes file TicTac.java. Goal of the lab was to understand how to implement and use multi-dimensional arrays. The program implements
a blank 3x3 board using nested for loops and multi-dimensional arrays. The program then asks which player wants to go first (X or O), as 
this program is a 2 person game. The program will ask which location the user wants to put their marker onto the board (asks for a column
number and a row number.) Once the user inputs a valid response, the program will place the piece onto the board (aka the double array). 
The program continues until a player has gotten a winning solution or there are no more moves to be made. 

**assignment1**

    Includes file phoneWords.java. Goal of the assignment was to understand recursion and be able to implement it. The program asks the 
 user to input a set of numbers. After the user inputs the numbers, the program calls method **printAllPhoneWords**, which has a list
 of the possible letters, then calling method **allLettersPrinted**, the program prints out the possiblilities, calling the method recursively.

**assignment3**

    Includes multiple files, which were the text files and programs provided by the professor (Books.txt, Transactions.txt, InventoryManager.java,
    & BackOrderNode.java) along with the programs I was required to create (BackOrderQueue.java, Book.java, & BookCollection.java). The goal
    of the assignment was to understand how to use stacks & queues. The program **InventoryManager** is the main method called to test the other
    methods. Parsing text files **Books.txt** and **Transactions.txt**, the **Book.java** file being the class that is used within **BackOrderQueue**
    and **BookCollection**, the files stock and sell books to customers, and if their books are out of stock, the customer is then put on a queue
    until the books are put onto stock and the customer is able to buy books.
