_Name: Martin Smith_  
_CSCI 241 - Winter 2018_  
_Date : January 30th 2018_  
_File : README.md_

# MANUAL FOR LAB2
 
### __**_SortingPack.java_**__
#### **METHODS**
  * int [ ] insertionSort(int[ ] unsortedArr)  
   
      Method takes arguement of type int [ ], and returns type int [ ]. It will save the value of one of the integers (not the head) from **unsortedArr** into variable **lockPick**, and compare the value of that specified integer with the values before it. 
      *  If the integer before **lockPick** is bigger, then it inserts itself one index higher into **unsortedArr**. This repeats until an integer is smaller than **lockPick** or if no more integers can be parsed in **unsortedArr**.
      *  If the integer before **lockPick** is smaller or there is no more array to be parsed, **lockPick** is then reinserted into **unsortedArr** one index higher. 
      
      This process repeats until all integers in **unsortedArr** have been parsed into **lockPick** (with exception of the head), which then it will return the sorted array.
   
  * int [ ] quickSort(int[ ] unsortedArr)  
  
      Method takes arguement of type int[ ], and returns type int [ ]. **unsortedArr** is passed through void method **quickSortHelp** along with pointers pointing at the head and tail of the array. Once it's passed **quickSortHelp**, **unsortedArr** will be sorted, and that array will then be returned.
  
  * quickSortHelp(int [ ] unsortedArr, int head, int tail)  
  
      Method takes arguements of type int[ ] and type int. All three arguements(**unsortedArr**, **head**, **tail**) are then passed through method **partition**, which will be used to sort and identify integer **pivotPtr**, which is the index of a pivot point within array **unsortedArr**. 
      
      Making sure that **head** and **tail** don't lie out of the boundaries of **pivotPtr**, **quickSortHelp** is called again recursively.
      *  For the left half of the array, the **head** pointer remains the same, but the **tail** pointer will now point at **pivotPtr**.
      *  For the right half of the array, the **tail** pointer remains the same, but the **head** pointer will now point at one value above **pivotPtr**.
      
      The method doesn't return any value, but its purpose is to change the values in **unsortedArr** so that when the **quickSortHelp** call in **quickSort** has finished, all the integers in **unsortedArr** will now be sorted. 
  
  * int partition(int [ ] unsortedArr, int head, int tail)  
      
      Method take arguements of type int [ ] and int, returning type int. The method starts by setting up the int values of **pivotPtr** and **pivotValue**, which will be based off your **head** arguement. This will be your pivot index and pivot value in respective order, which will shape with what the rest of the method does. The int values of **lPtr** and **rPtr** are then set up, **lPtr** being one index above **pivotPtr**, and **rPtr** residing at the **tail** index of **unsortedArr**. 
      
      Both **lPtr** and **rPtr** move torwards each other (**lPtr** increases, **rPtr** decreases), until one of the following happens:
        *  If **unsortedArr[lPtr]** ends up being bigger or equal to **pivotValue** or if **lPtr** ends up at the value of **tail**, **lPtr** stops moving.
        *  If **unsortedArr[rPtr]** ends up being smaller or equal to **pivotValue** or if **rPtr** is the same value as **pivotPtr**, **rPtr** stops moving.
        
       Once both pointers have stopped moving, the values in **unsortedArr** that each pointer is pointing at is compared. If **rPtr** is still on the right side of **lPtr** or if neither pointer has landed on the assigned boundaries of **unsortedArr**, both values at the pointers will swap with each other, and **lPtr** and **rPtr** will continue to move torwards each other as described above. 
       If **rPtr** ends up being on the left side of **rPtr** or if a boundary in **unsortedArr** has been reached, the value that **rPtr** is pointing at swaps with **pivotValue**. 
       
       The value of **rPtr** is then returned.
   
  * int [ ] mergeSort(int[ ] unsortedArr)  
  
      Method takes arguement of type int [ ] and returns type int [ ]. It first makes sure that the length of the array is greater than one. Once done, **unsortedArr** is split into two halves, left half **leftArray** and right half **rightArray**. 
      
      Each half is then called recursively into mergeSort, which will continue to split the arrays until it can't be split no more. This will ensure that the sort happens within all divided arrays.  
      
      The two arrays and **unsortedArr** will then have pointers starting at the head of each, comparing the integer values the pointers are on.
      * If the value in **leftArray** at pointer **i** is less than **rightArray** at pointer **j**, have the value of **unsortedArr** at given pointer **k** eqaul that value in **leftArray**. Then pointers **k** and **i** increment.
      * If the value in **rightArray** at pointer **j** is less than **leftArray** at pointer **i**, have the value of **unsortedArr** at given pointer **k** equal that value in **rightArray**. Then pointers **j** and **k** increment.
      * Any leftover values in **leftArray** and **rightArray** are then concatenated into **unsortedArr** if there is room left, starting with **leftArray**.
      
      The sorted array is then returned.
   
   
 ### __**_SortingTest.java_**__
 #### **METHODS**
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
