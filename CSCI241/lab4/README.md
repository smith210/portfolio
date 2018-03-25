_Name: Martin Smith_  
_CSCI 241 - Winter 2018_  
_Date : March 7th 2018_  
_File : README.md_

# MANUAL FOR LAB4
  Lab4 includes 3 files called BST.java, BSTTest.java, & BSTApp.java.

### __**_BST.java_**__
    
  includes public class BST that has 5 main methods(BST, search, insert, delete, traverse) and 5 helper methods(insertHelp, deleteHelper, childCustody, findSmallest, actuallyTraverse), resulting in the total of 10 methods.
  . 
#### **METHODS**
  
  * public BST()
  
      Constructor method for the **BST** class (also known as a binary search tree). This initializes the value of **Node root**.
  
  * public boolean search(int target)
  
      The method takes one arguement, and returns type boolean. What is done is that **root** is continuously searched through, its goal to find **target** as one of the key values of a Node in root. If target is found within root, arguement **true** is returned. If root is null or root has been completely searched through in vain, arguement **false** is returned.
  
  * public void insert(int target)
  
      The method takes one arguement. Using helper method **insertHelp**, the goal is to insert **int target** into **Node root** in its respective position. 
  
  * public void delete(int target)
  
      The method takes one arguement. Using helper method **deleteHelper**, the goal is to delete **int target** from **Node root**. Before the helper method is declared, **search** is invoked to see if **int target** is within **Node root**. If the search returns true, deleteHelper is invoked. If the search returns false, nothing happens.
  
  * public void traverse()
  
      This method, with the help of helper method **actuallyTraverse**, prints out all of the keys of **Node root** in ascending order (smallest to largest).
  
  * public Node insertHelp(Node node, Node guardian, int target)
  
      Helper method of method **insert**. The helper method takes three arguements and returns type Node. There are two goals of this function:
        
      1. To insert the key into a Node.
      2. To set the value of the parent of the Node. 
      
      This is done through recursion. If **Node node** is null when it's passed through, a new Node will be created with the value of target, the parent will be set equal to **Node guardian**, and **node** is returned. If **node** doesn't turn out to be null, the key of the node is compared with the target. Depending on the size of the target, the Node on either side will be set using recursion. If **target** is bigger than the key of the node, the Node goes to the right, and calls recursion: resetting the node to be **node.right** and guardian to **node**. If **target** is smaller, the Node goes to the left, calling recursion: resetting the node to be **node.left** and guardian to **node**.
  
  * public Node deleteHelper(Node node, int target)
  
      Helper method of method **delete**. Takes two arguements and returns type Node. Since **delete** has already determined that **int target** is in the **node**, recursion is used to find the Node that has the same key value as target. Once done, a check is done to determine whether any other Nodes are attached to the specified Node that is to be deleted.
      
      1.  If there happens to be no Nodes attached to the Node being deleted (node.left == null && node.right == null), the node is set to null, and is returned.
      2.  If there happens to be a single Node attached to the Node being deleted (node.right == null || node.left == null), helper method **childCustody** is called to make sure the respective child of the deleted Node is not lost within the deletion process.
      3.  If neither 1 or 2 is the case, that means that the Node being deleted has both Nodes attached. **findSmallest** helper method is invoked to find the next biggest Node after the Node being deleted (in other words it finds the smallest value on the right side of the deleted Node), which once done the key of that node is saved, **deleteHelper** is called in order to delete the node at that value. The key we have retrieved is then inserted into the Node that was called for deletion.
      
      Node is returned in all cases.
  
  * public Node childCustody(Node deceased, Node child)
  
      Helper method of method **deleteHelper**. Takes two arguements and returns type Node. The parent of the deceased (deceased.parent) is checked. If no value exists for the parent, then the child is set equal to the deceased, and the deceased is returned. If the parent is set, a check is made to determine the parent's relation to the deceased Node. Once its determined whether the deceased is right or left of its parent, that pathway is then set to be equal to the child, and the child changes its parent to be the deceased's parent. The child then is set equal to the deceased, and the deceased is returned.
  
  * public int findSmallest(Node node)
  
      Helper method of method **deleteHelper**. Takes one arguement and returns type int. The node starts out by traveling to the right. Then if its possible to go left, the node will keep traveling left until no longer possible. The key at that node will then be returned.
        
  * public void actuallyTraverse(Node node)
  
      Helper method of method **traverse**. Takes one arguement. The method uses recursion in order to print the keys of the Node in ascending order, which is seen through the recursive call of putting **node.left** through the recursion first then **node.right**. If the Node is null, nothing happens.
  
  
### __**_BSTTest.java_**__
    
  includes public class BSTTest that has 7 methods: display, search, insert, remove, exampleOne, exampleTwo, & main.
   
#### **METHODS**

  * public static void display(BST tree)
      
      Method takes type BST. **display** is invoked once **insert**, **search** or **remove** has finished its call. It prints out what's currently in the tree using the **traverse** method from the **BST** class.
        
        The traverse gives the BST as: 1 5 9 19 25 45 .
  
  * public static void search(BST tree, int num)
      
      Method takes type BST and int. Through the **search** method from the **BST** class, the **tree** is searched for **num**. If **num** is present (returns true), the program will print out the following letting the user know:
        
        Searching for 9 in the BST.
        The BST does contain 9.
      
      If **num** is not present (returns false), the program will print out a statement letting the user know:
      
        Searching for 25 in the BST.
        The BST does not contain 25.
  
  * public static void insert(BST tree, int num)
    
      Method takes type BST and int. Through the **insert** method from the **BST** class, the **tree** will place **num** into the tree accordingly. The following statement is printed out before starting the insert :
      
        Inserting 45 into the BST.
        
      After the insert is completed, **display** is invoked to display the changed tree.
  
  * public static void remove(BST tree, int num)
    
      Method takes type BST and int. Through the **delete** method from the **BST** class, the **tree** will delete **num** from tree accordingly. The following statement is printed out before starting the removal :
      
        Deleting 125 from the BST.
        
      After the remove is completed, **display** is invoked to display the changed tree.  
  
  * public static void exampleOne()
     
      Method takes no arguements. This first example is the simplest of the two, making sure the **insert**, **search**, **delete**, and **traverse** methods in the **BST** class work properly. The method starts out by letting the user know that this is the first test, and creates new BST called **shrub**. The following is then done to **shrub**:
        
      1. Insert **19** into **shrub**         _(makes sure that root in BST can be set)_
      2. Insert **1** into **shrub**          _(makes sure that .left can be set)_
      3. Insert **5** into **shrub**          _(makes sure that a value can be tacked onto afterwards)_
      4. Insert **9** into **shrub**
      5. Insert **25** into **shrub**         _(makes sure that .right can be set)_
      6. Insert **45** into **shrub**
      7. Insert **26** into **shrub**
      8. Insert **36** into **shrub**
      9. Insert **7** into **shrub**
      10. Insert **3** into **shrub**
      11. Insert **30** into **shrub**
      12. Search **7** in **shrub**           _(makes sure that search works properly (returning true))_
      13. Remove **30** from **shrub**        _(makes sure that delete works properly in the case of no attached Nodes)_
      14. Remove **45** from **shrub**        _(makes sure that delete works properly in the case of an attached Node going to the left)_
      15. Remove **26** from **shrub**        _(makes sure that delete works properly in the case of an attached Node going to the right)_
      16. Insert **42** into **shrub**
      17. Insert **27** into **shrub**
      18. Insert **29** into **shrub**
      19. Insert **23** into **shrub**
      20. Remove **25** from **shrub**        _(makes sure that delete works properly in the case if there are two attached Nodes)_
      
      Afterwards the code gets tedious by removing all the values currently in the tree, and inserting two random numbers to ensure that while in the process of deleting that the shrub can still be appended to.
    
      All instructions are printed for the user, and the BST is displayed after each step has been performed, invoking the helper methods of **insert**, **remove**, and **search**.
      
  * public static void exampleTwo(HeapMax heap)
      
      Method takes no arguements. A bit more intricate than the first example. It's used to try to trick up the methods in the **BST** class, to ensure that there are no loopholes in the code. The method starts out by letting the user know that this is the second test, and creates new BST called **shrub**. The following is then done to **shrub**:
      
      1. Remove **125** from **shrub**          _(makes sure that delete works properly in the case that BST is null)_
      2. Search **12** in **shrub**              _(makes sure that search works properly (returning false))_
      3. Insert **19** into **shrub**
      4. Insert **19** into **shrub**           _(makes sure that a value already in the BST cannot be added again)_
      5. Insert **1** into **shrub**
      6. Insert **5** into **shrub**
      7. Insert **9** into **shrub**
      8. Insert **25** into **shrub**
      9. Insert **5** into **shrub**            _(makes sure that a value already in the BST cannot be added again, and that it works when the num was inserted some time ago)_
      10. Search **9** in **shrub**             _(makes sure that search works properly (returning true))_
      11. Remove **25** from **shrub** 
      12. Search **25** in **shrub**            _(confirm the search turns up false)_
      13. Remove **21** from **shrub**          _(make sure that the program acts accordingly when a value not in the tree is trying to be deleted.)_

      All instructions are printed for the user, and the heap is displayed after each step has been performed, invoking the helper methods of **insert**, **remove**, and **search**.      
  
  
  * public static void main(String[] args)
  
      Main method of the code, and where it starts running. Main requires no arguements.
      Three new HeapMax types will be created for each of the two examples being ran. Statements will then be ran to let the user know that the the program has started. It will respectively run through each of the example cases, which are invoked by calling their respective methods (**exampleOne**, and **exampleTwo**), printing statements to let the user know which example case is running currently. Once finished, the program will let the user know that the program has ran its course.
      
        Testing of BSTest Starting...
        -----TEST 1-----
        ////////////////////////////////////
             //Example 1 displays here//
        ////////////////////////////////////
        -----TEST 2-----
        ////////////////////////////////////
             //Example 2 displays here//
        ////////////////////////////////////
        Testing of BSTTest Finished.

### __**_BSTApp.java_**__
    
  includes public class BSTApp that has includes the same methods as BSTTest.java (with the exception of search) plus the following: getTable, minDiff
   
#### **METHODS**
    
  Methods called to help insert and delete values in the BST (**insert**, **remove**) are performed the same way as BSTTest. 
  
  * public static int minDiff(Node root)
      
      Method takes type BST, and returns type int. To be able to find the smallest difference, all the keys in root are traversed from smallest to biggest into an **ArrayList**, invoked by the helper method **getTable**. Once done, the ArrayList is looped through, comparing the differences between the keys. The smallest one will be the one saved and returned.
      
  * public static ArrayList<Integer> getTable(ArrayList<Integer> template, Node root)
      
      Method takes type BST, and returns type ArrayList<Integer>. Performed similarily to the traverse method in BST.java, it adds the values of the root, starting from the left and then the right (using recursive calls).
   
  * public static void display(BST tree)
      
      Method takes type BST. **display** is invoked once **insert**, **search** or **remove** has finished its call. It prints out what's currently in the tree using the **traverse** method from the **BST** class. Afterwards, method **minDiff** is invoked to find the smallest difference between the keys in the BST, and that value is displayed for the user.
        
        The traverse gives the BST as: 19 23 24 46 47 48 64 67 80 100 .
        The minimum absolute difference is 1.
        
   * public static void exampleOne()
     
      Method takes no arguements. This first example is the simplest of the two, already knowing the smallest difference between all the keys. The method starts out by letting the user know that this is the first test, and creates new BST called **shrub**. The following is then done to **shrub**:
      _FIRST SET: smallest difference is 1_
      1. Insert **19** into **shrub**
      2. Insert **1** into **shrub**          
      3. Insert **25** into **shrub**         
      4. Insert **45** into **shrub**
      5. Insert **26** into **shrub**
      6. Insert **36** into **shrub**
      7. Insert **30** into **shrub**
      12. Display **shrub**           _(makes sure 1 is the smallest difference displayed)_
      _SECOND SET: smallest difference is 17_
      13. Remove **30** from **shrub**        
      14. Remove **45** from **shrub**        
      15. Remove **26** from **shrub**        
      16. Remove **25** from **shrub**
      17. Display **shrub**           _(makes sure 17 is the smallest difference displayed)_
      _THIRD SET: smallest difference is 10_
      18. Remove **39** from **shrub**
      19. Remove **1** from **shrub** 
      20. Display **shrub**           _(makes sure 10 is the smallest difference displayed)_
      
      Afterwards the code gets tedious by removing all the values currently in the tree, and inserting two random numbers to ensure that while in the process of deleting that the shrub can still be appended to.
    
      All instructions are printed for the user, and the BST is displayed after each step has been performed, invoking the helper methods of **insert**, **remove**, and **display**.
      
  * public static void exampleTwo(HeapMax heap)
      
      Method takes no arguements. A bit more intricate than the first example. It's used to make the factors more random and less fixed, to ensure that there are no loopholes in the code. The method starts out by letting the user know that this is the second test, and creates new BST called **shrub**. The following is then done to **shrub**:
      
      1. Insert **19** into **shrub**
      2. Insert 10 random numbers into **shrub** _(increases randomness)_
      3. Remove the 5th randomly inserted number from **shrub** 
      4. Display **shrub**

      All instructions are printed for the user, and the heap is displayed after each step has been performed, invoking the helper methods of **insert**, **remove**, and **display**.      
      
  * public static void main(String[] args)
  
      Main method of the code, and where it starts running. Main requires no arguements.
      Three new HeapMax types will be created for each of the two examples being ran. Statements will then be ran to let the user know that the the program has started. It will respectively run through each of the example cases, which are invoked by calling their respective methods (**exampleOne**, and **exampleTwo**), printing statements to let the user know which example case is running currently. Once finished, the program will let the user know that the program has ran its course.
      
        Testing of BSTest Starting...
        -----TEST 1-----
        ////////////////////////////////////
             //Example 1 displays here//
        ////////////////////////////////////
        -----TEST 2-----
        ////////////////////////////////////
             //Example 2 displays here//
        ////////////////////////////////////
        Testing of BSTTest Finished.
