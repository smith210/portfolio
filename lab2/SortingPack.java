//Name : Martin Smith
//CSCI 241 - Winter 2018
//Date : January 25th 2018
//File : SortingPack.java

import java.util.*;

public class SortingPack {

//insertionSort method
  public static int[] insertionSort(int[] unsortedArr){
    for (int i = 1; i < unsortedArr.length; i++){
    //insert key one ahead from the starting point
        int lockPick = unsortedArr[i];

    //make sure that there is a saved value so head of array can be accessed
        int j = i - 1;

    //while loop for sorting
        while (j >= 0 && unsortedArr[j] > lockPick){
            unsortedArr[j+1] = unsortedArr[j];
            j--;
        }
    //change the value of the key
        unsortedArr[j+1] = lockPick;
    }
  //return sorted array
    return unsortedArr;
  }
  
 //quickSort method  
  public static void quickSort(int[] unsortedArr, int head, int tail){
      
      //use helper method to access pivot point
      int pivotPtr = quickSortHelp(unsortedArr, head, tail);
      
      //recursive call to concatenate sorted numbers in future iterations
      if(head < pivotPtr -1){
         quickSort(unsortedArr, head, pivotPtr);
      }
      if(tail > pivotPtr){
         quickSort(unsortedArr, pivotPtr+1, tail);      
      }
  }

//quickSortHelp method
  public static int quickSortHelp(int[] unsortedArr, int head, int tail){

      //set value of pivotPoint
      int pivotPtr = head;
      int pivotValue = unsortedArr[head];
      //set values of leftPoint and rightPoint
      int lPtr = head+1;
      int rPtr = tail;
      
      //if there is more than one value in unsortedArr 
      if(lPtr < rPtr){
         
         //have a while loop to run the increments until lPtr is on right of rPtr
         while(lPtr <= rPtr){
            //increment lPtr until it's found a value in arr bigger than the value of pivot
            while(unsortedArr[lPtr] <= pivotValue && lPtr != tail){
               lPtr++;
            }
            //decrement rPtr until it's found a value in arr smaller than the value of pivot
            while(unsortedArr[rPtr] >= pivotValue && rPtr != pivotPtr){
               rPtr--;
            }
            //break while loop if lPtr > rPtr or if lPtr goes out of limits or if rPtr hits pivot
            if(lPtr > rPtr || unsortedArr[lPtr] == unsortedArr[rPtr] || rPtr == pivotPtr){
               break;
            }else{
               //swap indexes at lPtr and rPtr
               int placeholder = unsortedArr[lPtr];
               unsortedArr[lPtr]= unsortedArr[rPtr];
               unsortedArr[rPtr]= placeholder;
               lPtr++;
               rPtr--;
               
            }
         }

      }
   if(unsortedArr[pivotPtr] >= unsortedArr[rPtr]){ 
      //swap the pivot point and rPtr
      pivotPtr = rPtr;
      unsortedArr[head] = unsortedArr[rPtr];
      unsortedArr[rPtr] = pivotValue;
   }
   
   //return array
      return rPtr;
  }

//mergeSort method
  public static int[] mergeSort(int[] unsortedArr){
    
    if (unsortedArr.length > 1){
      //assign value of mid to half the unsortedArr length
      //and create two half arrays (left and right)
      int mid = (unsortedArr.length)/2;
      int[] leftArray = Arrays.copyOfRange(unsortedArr, 0, mid);
      int[] rightArray = Arrays.copyOfRange(unsortedArr, mid, unsortedArr.length);
      
      //recursive calling for each half of the array
      mergeSort(leftArray);
      mergeSort(rightArray);
      
      //processing leftArray and rightArray
      int i=0;
      int j=0;
      int k=0;
      
      //process each array to determine size, and assign the smaller value
      //in the original array
      while (i < leftArray.length && j < rightArray.length){
         if (leftArray[i] < rightArray[j]){
            unsortedArr[k] = leftArray[i];
            i++;
         }else{
            unsortedArr[k] = rightArray[j];
            j++;
         }
         k++;
      }
      
      //make sure that all values are processed within leftArray
      while (i < leftArray.length){
         unsortedArr[k] = leftArray[i];
         i++;
         k++;
      }
      
      //make sure that all values are processed within rightArray
      while (j < rightArray.length){
         unsortedArr[k] = rightArray[j];
         j++;
         k++;
      }
    }
  //return sorted array
    return unsortedArr;
  }


}
