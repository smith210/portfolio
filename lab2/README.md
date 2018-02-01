_Name: Martin Smith_  
_CSCI 241 - Winter 2018_  
_Date : January 30th 2018_  
_File : README.md_

# MANUAL FOR LAB2
 
### **_SortingPack.java_**
 **METHODS**
  * int [ ] insertionSort(int[ ] unsortedArr)  
   
      Method takes arguement of type int [ ], and returns type int [ ]. It will save the value of one of the integers (not the head) from **unsortedArr** into variable **lockPick**, and compare the value of that specified integer with the values before it. 
      *  If the integer before **lockPick** is bigger, then it inserts itself one index higher into **unsortedArr**. This repeats until an integer is smaller than **lockPick** or if no more integers can be parsed in **unsortedArr**.
      *  If the integer before **lockPick** is smaller or there is no more array to be parsed, **lockPick** is then reinserted into **unsortedArr** one index higher. 
      
      This process repeats until all integers in **unsortedArr** have been parsed into **lockPick** (with exception of the head), which then it will return the sorted array.
   
  * int [ ] quickSort(int[ ] unsortedArr)  
  
  * quickSortHelp(int [ ] unsortedArr, int head, int tail)
  
  * partition(int [ ] unsortedArr, int head, int tail)
   
  * int quickSortHelp(int[ ] unsorttedArr, int head, int tail)  
   
  * int [ ] mergeSort(int[ ] unsortedArr)  
  
      Method takes arguement of type int [ ] and returns type int [ ]. It first makes sure that the length of the array is greater than one. Once done, **unsortedArr** is split into two halves, left half **leftArray** and right half **rightArray**. 
      
      Each half is then called recursively into mergeSort, which will continue to split the arrays until it can't be split no more. This will ensure that the sort happens within all divided arrays.  
      
      The two arrays 
   
   
 ### **_SortingTest.java_**
 **METHODS**
  * int [ ] randomArray(int num)  
     
     Method takes arguement of type int and returns type int [ ]. Based on **int num**, it will then generate an array of that size, filling it with random numbers used by the **Math.random()** function. 
   
  * printArr(int[ ] array, int cur)  
  
     Method takes arguements of type int [] and type int. It then prints what is in **int [ ] array**, seperating each integer (with exception of the last) with a comma:
     >**398, 714, 103, 220, 993, 370, 409, 791, 860,** 616  
     
     **int cur** is used so that **int [ ] array** does not print a comma on the last integer in **int [ ] array**.  
     
     >398, 714, 103, 220, 993, 370, 409, 791, 860, **616**
        
  * String display(int sortMethod)  
  
     Method takes an arguement of type integer, and returns type String. Based on what integer is passed through this method, **display** will return one of the following Strings:
     * If the integer is **0**, it returns string **insertionSort**.  
     * If the integer is **1**, it returns string **quickSort**.
     * All other integers will return **mergeSort**.
   
  * main  
   
    This is where the function starts (and runs primarily). From here, it goes through a for loop 3 times, one for each sort type.  
   It prints out a statement that lets the user know which sort it's testing and what the array being tested is. For example:
    >Testing for insertionSort...  
    >The generated array for this test is: [376, 853, 660]  
   
    Based on which iteration the for loop is on, the time the function starts is recorded, and the function will then call on one of the methods from the SortingPack class, starting with **insertSort**, followed by **quickSort** and **mergeSort**. Once the sort is completed, the time of completion will be recorded. Total time is then calculated, and that is then shown to the user, along with the sorted array:  
    >Time it took to sort array: 1 milliseconds.  
    >The sorted array for ths test is: [376, 660, 853]  
   
    It'll then print a statement letting the user know that the sort is officially over, and the cycle will continue for the following sorts.  
    >Testing for insertionSort finished.
