_Name: Martin Smith_  
_CSCI 241 - Winter 2018_  
_Date : January 30th 2018_  
_File : README.md_

### MANUAL FOR LAB2
 
 **_SortingPack.java_**
 * METHODS
   * insertionSort(int[ ] unsortedArr)  
   
   * quickSort(int[ ] unsortedArr, int head, int tail)  
   
   * quickSortHelp(int[ ] unsorttedArr, int head, int tail)  
   
   * mergeSort(int[ ] unsortedArr)  
   
   
 **_SortingTest.java_**
 * METHODS
   * randomArray(int num)  
   
   * printArr(int[ ] array, int cur)  
   
   * display(int sortMethod)  
   
   * main  
   This is where the function runs primarily in this file. From here, it goes through a for loop 3 times, one for each sort type.  
   It prints out a statement that lets the user know which sort it's testing and what the array tested is. For example:
    >Testing for insertionSort...  
    >The generated array for this test is: [376, 853, 660]
   Based on which iteration the for loop is on, the time the function starts is recorded, and the function will then call on one of the methods from the SortingPack class, starting with **insertSort**, followed by **quickSort** and **mergeSort**. Once the sort is completed, the time of completion will be recorded. Total time is then calculated, and that is then shown to the user, along with the sorted array:  
   >Time it took to sort array: 1 milliseconds.
   >The sorted array for ths test is: [376, 660, 853]
   It'll then print a statement letting the user know that the sort is officially over, and the cycle will continue for the following sort.
   >Testing for insertionSort finished.
