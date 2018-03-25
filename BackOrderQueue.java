/*
* BackOrderQueue.java
* needs completion and revision
*
*/
public class BackOrderQueue {
   private BackOrderNode front;
   private BackOrderNode rear;
   
   //constructor. To complete
   public BackOrderQueue() {
      front = null;
      rear = null;
   }  
   
   //isEmpty method. To complete
   public boolean isEmpty() {
      if (front == null){
         return true;
      } else { 
         return false;
      }
   }
   
   //enqueue method. To complete
   public void enqueue(int customer, int stock) {
      
      BackOrderNode current = new BackOrderNode(customer, stock, null);
      
      if (front == null){
         front = current;
         rear = current;
      } else {
         rear.next = current;
         rear = rear.next;
      }
      
   }

   //dequeue method. To complete
   public void dequeue() {
      if (isEmpty()){
         throw new RuntimeException("queue underflow");
      } else {
         BackOrderNode removeFromLine = front;
         front = front.next;
         
         if (front == null){
            rear = null;
         }
         
         return removeFromLine;
      }
   }
   
   //front method to get the front order. To complete
   public BackOrderNode front() {
      return front;
   }    
   
}