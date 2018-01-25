//Name : Martin Smith
//CSCI 241 - Winter 2018
//Date : January 25th 2018
//File : SortingPack.java

public class SortingPack {
//insertionSort method
  public static int[] insertionSort(int[] unsortedArr){
    for (int i = 1; i <= unsortedArr.length; i++){
    //insert key one ahead from the starting point
        int lockPick = unsortedArr[i];
    //make sure that there is a saved value so head of array can be accessed
        int j = i - 1;
    /*while loop
    WHAT IT DOES:
    If the int being currently pointed at of unsortedArr is more than the key,
    then it'll go through the while loop. The head int will then place itself
    in the slot of the key, and the array will then shift left (changes value
    of j). The while loop will end once the pointer is no longer able to point
    at the array.
    */
        while (j > 0 && unsortedArr[j] > lockPick){
            unsortedArr[j+1] = unsortedArr[j];
            j = j-1;
        }
    //change the value of the key
        A[j+1] = lockPick;  
    }
  }

//quickSort method
  public static int[] quickSort(int[] unsortedArr){

  }

//mergeSort method
  public static int[] mergeSort(int[] unsortedArr){

  }

//main method
  public static void main (String[]args){


  }

}
