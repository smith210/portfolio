public class PrimeNumber {
   public static final int NUMBER_OF_PRIMES = 50; //number of primes to display
   public static final int NUMBER_OF_PRIMES_PER_LINE = 10; //display 10 per line
   
   
   public static void main(String[] args) {
   
      System.out.println("The first 50 prime numbers are \n");
   
   //repeatly find prime numbers and print them
   //your code goes here
      int count = 0;
      int number = 2;
      while (count < NUMBER_OF_PRIMES){
         if (isPrime(number)){
            System.out.print(number+" ");
            count++;
            
         if (count % NUMBER_OF_PRIMES_PER_LINE == 0){
            System.out.println( );
         }
         }
         number++;
      }
      
      
   
   
   } //end of the main() method
   
   //Method isPrime(): to test if num is a prime
   public static boolean isPrime(int num) {
      int primeCount = 0;
      for (int i = 1; i < num; i++){
         if (num % i == 0){
            primeCount ++;
         }
      }   
      if (primeCount == 1){
         return true;
      }
         return false;
     
    //your code goes here

   } //end of isPrime() method

}