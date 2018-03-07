//Name: Martin Smith
//CSCI 241 - Winter 2018
//File: BSTTest.java

public class BSTTest{

  //display
  public static void display(BST tree){
    System.out.print("The traverse gives the BST as: ");
    tree.traverse();
    System.out.println(".");
  }

  //search
  public static void search(BST tree, int num){
    //let user know the search is going to commence
    System.out.println("Searching for " + num + " in the BST.");
    boolean inTree = tree.search(num);
    //if num is in tree, print out true statement, else print false statement
    if(inTree){
        System.out.println("The BST does contain " + num + ".");
    }else{
        System.out.println("The BST does not contain " + num + ".");
    }

  }

  //insert
  public static void insert(BST tree, int num){
    //let user know the insert is going to commence
    System.out.println("Inserting " + num + " into the BST.");
    tree.insert(num);
    //display the tree
    display(tree);

  }

  //remove
  public static void remove(BST tree, int num){
    //let user know the delete is going to commence
    System.out.println("Deleting " + num + " from the BST.");
    tree.delete(num);
    //display the tree
    display(tree);
  }

  //Example1
  public static void exampleOne(){
    System.out.println("-----TEST 1-----");
    //create new BST
    BST shrub = new BST();
    //insert 19 - make sure that a value can be inserted into the tree
    insert(shrub, 19);
    //insert 1 - make sure that a value can be tacked on after a node
    insert(shrub, 1);
    //insert 5 - make sure that a value can be tacked on after two nodes
    insert(shrub, 5);
    //insert 9
    insert(shrub, 9);
    //insert 25 - make sure that a value can be tacked on as .right of start
    insert(shrub, 25);
    //insert 45
    insert(shrub, 45);
    //insert 26
    insert(shrub, 26);
    //insert 36
    insert(shrub, 36);
    //insert 7
    insert(shrub, 7);
    //insert 3
    insert(shrub, 3);
    //insert 30
    insert(shrub, 30);
    //insert 21
    insert(shrub, 21);
    //search for 7 - test to see if search works properly
    search(shrub, 7);
    //remove 30 - test to see if deleting node w/ no children works
    remove(shrub, 30);
    //remove 45 - test to see if deleting node w/ one child (left) works
    remove(shrub, 45);
    //remove 26 - test to see if deleting node w/ one child(right) works
    remove(shrub, 26);
    //insert 42
    insert(shrub, 42);
    //insert 27
    insert(shrub, 27);
    //insert 29
    insert(shrub, 29);
    //insert 23
    insert(shrub, 23);
    //remove 25 - test to see if deleting node w/ two children works
    remove(shrub, 25);
    //remove the rest of the numbers - add a few numbers sure
    remove(shrub, 19);
    remove(shrub, 1);
    remove(shrub, 5);
    search(shrub, 9);
    remove(shrub, 9);
    search(shrub, 9);
    remove(shrub, 21);
    remove(shrub, 27);
    remove(shrub, 42);
    remove(shrub, 29);
    remove(shrub, 3);
    remove(shrub, 36);
    remove(shrub, 23);
    remove(shrub, 23);
    insert(shrub, 2);
    remove(shrub, 7);
    insert(shrub, 1);

  }

  //Example2
  public static void exampleTwo(){
    System.out.println("-----TEST 2-----");
    //create new BST
    BST shrub = new BST();
    //remove 125 - test to see if it's possible to remove a value from empty tree
    remove(shrub, 125);
    //search for 12 - test to see if it's possible to search an empty tree
    search(shrub, 12);
    //insert 19
    insert(shrub, 19);
    //insert 19 - test to see if it can add a number already in the tree
    insert(shrub, 19);
    //insert 1
    insert(shrub, 1);
    //insert 5
    insert(shrub, 5);
    //insert 9
    insert(shrub, 9);
    //insert 25
    insert(shrub, 25);
    //insert 5 - test to see if it can add a number already in the tree
    insert(shrub, 5);
    //insert 45
    insert(shrub, 45);
    //search for 9 (it should return true)
    search(shrub, 9);
    //delete 25
    remove(shrub, 25);
    //search for 25 (it should return false)
    search(shrub, 25);
    //delete 21 - test to see if it's possible to delete a value not in tree
    remove(shrub, 21);
  }

  //main method
  public static void main(String[] args){
      System.out.println("Testing of BSTTest Starting...");
      //call exampleOne
      exampleOne();
      //call exampleTwo
      exampleTwo();

      System.out.println("Testing of BSTTest Finished.");
  }


}
