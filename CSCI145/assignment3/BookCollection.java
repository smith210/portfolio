/*
* BookCollection.java
* needs completion and revision
*
*/
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

//a linked-lists based implementation
//a book collection is a linked-list of books
public class BookCollection{

   //data fields: a head reference and a tail reference
   private Book first; 
   private Book last;
   private int totalCatalog;
	
   //constructor
   public BookCollection (String bookFile) {
      getBooks(bookFile);
   }  
   
   //get books from the input file. To complete.  
   private void getBooks(String bookFile) {
      first = null;
      last = null;
      
      File book = null;
      Scanner bookInput = null;
      
      try {
         book = new File (bookFile);
         bookInput = new Scanner (book);
      }catch (Exception e){}    
         
      while (bookInput.hasNextLine()){
         
         String isbn = "";
         int stock = 0;
         
         isbn = bookInput.next();
         
         stock = Integer.parseInt(bookInput.next());
         
         Book created = new Book(isbn, stock);
         
         if (last == null){
            first = created;
            last = created;
         }else{
            last.next = created;
            last = last.next;
         }
                       
      }
   
   }
   
   //search the collection for a book with the passed isbn. To complete
   private Book findBook(String isbn){
      
      Book current = first;
      
      boolean foundBook = false;
      
      while (!foundBook || current.next != null){
      
         String lookingISBN = current.getIsbn();
      
         if (lookingISBN.equals(isbn)){
            foundBook = true;
            return current;
         }else{
            current = current.next;
         }
      }
      
      return current;
   }
   
   
   //add a new book to the collection. To complete
   public void addBook(Book book){
      if (first == null){
         last = book;
         first = last;
      } else {
         last.next = book;
         last = last.next;
      }
   }
   
   //process Transactions from the given transactions file. To complete
   public void processTransactions(String transactionsFile){
       
      File transactions = null;
      Scanner transactionInput = null;
           
      try {
         transactions = new File (transactionsFile);
         transactionInput = new Scanner (transactions);
      } catch (Exception e){}
      
      while (transactionInput.hasNextLine()){ //read each line of the transactions
         
         String type = "";
         String isbn = "";
         int numBooks = 0;
         
         type = transactionInput.next();
         isbn = transactionInput.next();
         numBooks = Integer.parseInt(transactionInput.next());
         
         Book current = first;
         
         if (type.equals("STOCK")){ //if the system is adding books
            
            int stockIncrease = numBooks;

//             if (findBook(isbn) == null){//make sure the added book is in system, else add the new book to the system
//                Book newRelease = new Book (isbn, 0);
//             }
            
            current = findBook(isbn);//find book in book collection
            
            int priorToOrder = current.getStock();
            
            current.changeStock(stockIncrease);//increase stock
            
            System.out.println("Stock for " + isbn + " increased from " + priorToOrder + " to " + current.getStock());
         
         }else{//if there is a customer ordering a book
            int stockDecrease = (numBooks)* (-1);
            int customerID = Integer.parseInt(transactionInput.next()); 
            
            
//             if (findBook(isbn) == null){// if book is not in system, add book to book collection
//                Book newRelease = new Book (isbn, 0);
//                addBook(newRelease);
//             }
            
            
            current = findBook(isbn);//find book in book collection
            
            int priorToOrder = current.getStock();
            
            current.changeStock(stockDecrease);//decrease stock

         
            if (current.getStock() > 0){//if there are still copies left of that book after purchase
               
               if (numBooks == 1){
                  System.out.println("Order filled for customer " + customerID + " for " + numBooks + " copy of book " + isbn);
               } else {
                  System.out.println("Order filled for customer " + customerID + " for " + numBooks + " copies of book " + isbn);
               }
               
            } else {//if the stock of book ran out and the customer hasn't gotten all of their ordered books
                  
               if (priorToOrder == 1){
                  System.out.println("Order filled for customer " + customerID + " for " + priorToOrder + " copy of book " + isbn);
               } else {
                  System.out.println("Order filled for customer " + customerID + " for " + priorToOrder + " copies of book " + isbn);
               }
                  
             
              
               BackOrderQueue orderLine = current.getBackOrderQueue();
               
               orderLine.enqueue(customerID, (current.getStock()) * -1);
            }
         }
      }
      
   }
   
}
