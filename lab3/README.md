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
  
  * public static void displayHeap(HeapMax heap)
  
  * public static void remove(HeapMax currHeap)
  
  * public static void exampleOne(HeapMax heap)
  
  * public static void exampleTwo(HeapMax heap)
  
  * public static void exampleThree(HeapMax heap) 
  
  * public static void main(String[] args)

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
        
      Then there is a check to make sure the size inputted by the user is more than 0. Then it goes through the for loops, printing out each variable in the matrix, seperating the changes in matricies by **" "** and the changes of elements by **", "**.
      
        87, 99, 73, 0
        80, 58, 34, 89
        9, 48, 98, 95
        27, 3, 47, 24
  
  * public static void displayEndStatement(int set, int max)
      
      Method takes types int. **int max** is initially used to check whether there is a valid max value or not. If it's not a valid value, the method prints an error statement, and ends the method there.
        
        ERROR - NO ELEMENTS IN HEAP.
      
      Once checked that **int max** is actually a valid number, it will print out what the biggest element is for the given set. For example let's say that the matrix pointed by **int set** of **1** has returned a max value of **91**. **int set** will increment for the sake of the user's print statement, and will print both **int max** and **int set**.
        
        The biggest element of Experiment **2** is **91**.
  
  * public static void main(String[] args)
  
      Main method of the code, and where it starts when running. Main requires an arguement of type int, and if that is not satisifed it will print an error message accordingly and end the code.
      
      The int passed through the arguement will then determine the size of our double matrix. If the number is negative, the test will be immeaditely passed over and print out an error statement.
      
        ERROR - SIZE SET NON-EXISTENT. Cannot start kthBiggest.
      
      If the int is positive or 0, it will pass through the tests. It starts by printing out a statement letting the user know the test has begun, then assigns random integers for each value in the matrix known as **coolMatrix**. A random number is also assigned under **int randomSet**, which ranges the span of the int that the user inputted.
      
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