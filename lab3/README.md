_Name: Martin Smith_  
_CSCI 241 - Winter 2018_  
_Date : February 7th 2018_  
_File : README.md_

# MANUAL FOR LAB3
### __**_HeapMax.java_**__
#### **METHODS**
  
  * public HeapMax(int size)
  
  * public void insert (int element)
  
  * public int getMax()
  
  * public int removeMax()
  
  * public void removeMaxHelper()
  
  * public void heapify(int num)
  
  * public int maxChild(int num)
  
  * public void display()
  
  
### __**_HeapMaxTest.java_**__
#### **METHODS**

  * public static void insert(int num, HeapMax currHeap)
      
      Method takes type int and type HeapMax. **HeapMax currHeap** will then have **int num** inserted into the heap. A statement is printed out to the user to describe that **int num** has been inserted into the heap, and then the heap is displayed to the user.
        
        Insert 1.
        Current heap is: 1.
        Insert 29.
        Current heap is: 29, 1.
  
  * public static void displayHeap(HeapMax heap)
      
      Method takes type HeapMax. **HeapMax heap** is invoked in order to print out its content. The **display** function from class **HeapMax** is invoked here.
        
        Current heap is: 29, 1.
  
  * public static void remove(HeapMax currHeap)
    
      Method takes type HeapMax. The program will print a statement letting the user know it will remove the max from the heap, and invokes the **removeMax** function from the **HeapMax** class to remove it. The heap is then displayed to the user.
      
        Remove max.
        Current heap is: 11, 4 5.
        Remove max.
        Current heap is: 5, 4.
  
  * public static void exampleOne(HeapMax heap)
     
      Method takes type HeapMax. This first example is the simplest of the three, making sure the functions of the insertion and removal are performed properly.
        
      1. Insert **1** into **heap**
      2. Insert **29** into **heap**
      3. Insert **7** into **heap**
      4. Insert **24** into **heap**
      5. Remove max value from **heap** (remove **29**)
      6. Insert **5** into **heap**
      7. Insert **10** into **heap**
      8. Remove max value from **heap** (remove **24**)
      9. Insert **2** into **heap**
    
      All instructions of inserts and removals are printed for the user, and the heap is displayed after each step has been performed.
      
  * public static void exampleTwo(HeapMax heap)
      
      Method takes type HeapMax. A bit more intricate than the first example. It's mainly used to determine that the display of the heap and its levels are displayed accurately.
      
      1. **Insert** 5 random numbers
      2. **Remove** the max value from heap
      3. Repeat steps 1-2 twice.
      4. **Insert** 6 random numbers
      5. **Remove** the max value from heap

      All instructions of inserts and removals are printed for the user, and the heap is displayed after each step has been performed.      
  
  * public static void exampleThree(HeapMax heap) 
      
      Method takes type HeapMax. The more complex of the three examples, this example checks to make sure that it can attempt to remove values from a heap when there are no more values to remove.
      
      1. **Insert** 40 random numbers into the heap.
      2. **Remove** the max values from heap **42** times.
      3. **Insert** int 42 into the heap.
    
      All instructions of inserts and removals are printed for the user, and the heap is displayed after each step has been performed.
  
  * public static void main(String[] args)
  
      Main method of the code, and where it starts running. Main requires no arguements.
      Three new HeapMax types will be created for each of the three examples being ran. Statements will then be ran to let the user know that the the program has started. It will respectively run through each of the example cases, which are invoked by calling their respective methods (**exampleOne**, **exampleTwo**, and **exampleThree**), printing statements to let the user know which example case is running currently. Once finished, the program will let the user know that the program has ran its course.
      
        Testing of HeapMax starts.

        Testing for Example 1 starting...
        ////////////////////////////////////
             //Example 1 displays here//
        ////////////////////////////////////
        Testing for Example 1 finished.
        
        Testing for Example 2 starting...
        ////////////////////////////////////
             //Example 2 displays here//
        ////////////////////////////////////
        Testing for Example 2 finished.
        
        Testing for Example 3 starting...
        ////////////////////////////////////
             //Example 3 displays here//
        ////////////////////////////////////
        Testing for Example 3 finished.

        Testing of HeapMax ends.

### __**_HeapMaxApp.java_**__
#### **METHODS**

  * public static int kthBiggest(int[ ][ ]matr, int k)
  
      Method takes type int[ ][ ] and type int, and returns type int. For example, say we have the following:
      
        The given matrix for Test 1 is:   //prints out content of **matr[ ][ ]**
        
        87, 99, 73, 0     //**k=0**
        80, 58, 34, 89    //**k=1**
        9, 48, 98, 95     //**k=2**
        27, 3, 47, 24     //**k=3**
      
      Based on whatever value **int k** is equal to, all the values in the matrix pointing at **k** in **matr** will then be placed and sorted into the **HeapMax newHeap**. It then will call the **getMax()** function in the **HeapMax** class, and return the max value of the heap. Going back to the above example, say k were equal to 1:
        
        80, 58, 34, 89 --> **89**, 80 34, 58.    //what is displayed in **HeapMax newHeap**
      
      Since 89 is the max of **HeapMax newHeap**, that is the number that is returned.
  
  * public static void displayStartStatement(int[ ][ ]matr, int testNum)
  
      Method takes type int[ ][ ] and type int. **int testNum** is used in the first print statement to let the user know which test is being implemented at the moment(and since it starts at 0, it's appropriately incremented by 1).
        
        The given matrix for Test **1** is: 
        
      Then there is a check to make sure the size inputted by the user is more than 0. If it is, it goes through the for loops, printing out each variable in the matrix, seperating the changes in matricies by **line change** and the changes of elements by **commas followed by spaces** until it has reached the last element.
      
        87, 99, 73, 0
        80, 58, 34, 89
        9, 48, 98, 95
        27, 3, 47, 24
        
      If the size inputted by the user is 0, nothing will print.
  
  * public static void displayEndStatement(int set, int max)
      
      Method takes types int. **int max** is initially used to check whether there is a valid max value or not. If it's not a valid value, the method prints an error statement, and ends the method there.
        
        ERROR - NO ELEMENTS IN HEAP.
      
      Once checked that **int max** is actually a valid number, it will print out what the biggest element is for the given set. For example let's say that the matrix pointed by **int set** of **1** has returned a max value of **91**. **int set** will increment for the sake of the user's print statement, and will print both **int max** and **int set**.
        
        The biggest element of Experiment **2** is **91**.
  
  * public static void main(String[] args)
  
      Main method of the code, and where it starts when running. Main requires an arguement of type int, and if that is not satisifed it will print an error message accordingly and end the code.
      
      The int passed through the arguement will then determine the size of our double matrix. If the number is negative, the test will be immeaditely passed over and print out an error statement.
      
        ERROR - SIZE SET NON-EXISTENT. Cannot start kthBiggest.
      
      If the int is positive or 0, it will pass through the tests. It starts by printing out a statement letting the user know the test has begun, then assigns random integers for each value in the matrix known as **coolMatrix**. A number is also assigned under **int randomSet**, which ranges the span of the int that the user inputted.
      
        **Testing of kthBiggest starts.**
        The given matrix for Test 1 is: 

        25, 35, 7, 50, 2
        36, 63, 8, 79, 94
        23, 15, 70, 6, 22
        3, 22, 13, 81, 90
        87, 40, 86, 9, 18

        The biggest element of Experiment 1 is 50.
        
      The matrix and the test currently on is then printed for the user, which is invoked through the **displayStartStatement** method.
      
        Testing of kthBiggest starts.
        **The given matrix for Test 1 is: 

        25, 35, 7, 50, 2
        36, 63, 8, 79, 94
        23, 15, 70, 6, 22
        3, 22, 13, 81, 90
        87, 40, 86, 9, 18
        **
        The biggest element of Experiment 1 is 50.
        
      Once completed, **int breadwinner** is assigned the max value of the selected matrix in **coolMatrix** determined by **int randomNum**. Then the end statement is printed for the user, which is invoked through the **displayEndStatement** method.
        
        Testing of kthBiggest starts.
        The given matrix for Test 1 is: 

        25, 35, 7, 50, 2
        36, 63, 8, 79, 94
        23, 15, 70, 6, 22
        3, 22, 13, 81, 90
        87, 40, 86, 9, 18
        
        **The biggest element of Experiment 1 is 50.**
        
      This repeats again for the second test. Once all tests are finished, the code will print out a statement letting the user know that this program has ran its course.
      
        **Testing of kthBiggest ends.**
        
      The difference between the two tests is that the first test **int randomSet** is pre-set to the first experiment, while the second test **int randomSet** is assigned randomly to any of the experiments. 