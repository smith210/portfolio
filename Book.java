/*
* Book.java
* needs completion and revision
*
*/

public class Book{
	
    /* fields for the Book class */
   private String isbn;  
   private int stock; 
   private BackOrderQueue orderQ;//queue for any back orders of a particular book
   public Book next;
	
	/* constructor function. To complete */
   Book(String isbn, int startingStock){
      this.isbn = isbn;
      this.stock = startingStock;
   
   }

	/* return book International Standard Book Number (ISBN). To complete */
   public String getIsbn(){
      return this.isbn;
   }
	
	/* return book stock on hand. To complete */
   public int getStock(){
      return this.stock;
   }	
   
   /* return the backorderqueue on hand. To complete */
   public BackOrderQueue getBackOrderQueue(){
      return this.orderQ;
   }	
	
	/* change the stock level of the book. To complete */
   public void changeStock(int change){
      this.stock = stock + change;
      
   }
   
   /*feel free to add more methods that you think are useful*/
}