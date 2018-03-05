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

  //insert
  public static void insert(BST tree, int num){
    System.out.println("Inserting " + num + " into the BST.");
    tree.insert(num);

  }

  //remove
  public static void remove(BST tree, int num){
    System.out.println("Deleting " + num + " from the BST.");
    tree.delete(num);
  }

  //Example1
  public static void exampleOne(){
    System.out.println("-----TEST 1-----");
    //create new BST
    BST shrub = new BST();
    //insert 19
    insert(shrub, 19);
    display(shrub);
    //insert 1
    insert(shrub, 1);
    display(shrub);
    //insert 5
    insert(shrub, 5);
    display(shrub);
    //insert 9
    insert(shrub, 9);
    display(shrub);
    //insert 25
    insert(shrub, 25);
    display(shrub);
    //insert 45
    insert(shrub, 45);
    display(shrub);
    //insert 26
    insert(shrub, 26);
    display(shrub);
    //insert 36
    insert(shrub, 36);
    display(shrub);
    //insert 7
    insert(shrub, 7);
    display(shrub);

    insert(shrub, 3);
    display(shrub);
    //insert 7
    insert(shrub, 30);
    display(shrub);

    insert(shrub, 21);
    display(shrub);

    remove(shrub, 30);
    display(shrub);

    remove(shrub, 45);
    display(shrub);

    remove(shrub, 26);
    display(shrub);

    insert(shrub, 42);
    display(shrub);

    insert(shrub, 27);
    display(shrub);

    insert(shrub, 29);
    display(shrub);

    insert(shrub, 23);
    display(shrub);

    remove(shrub, 25);
    display(shrub);
  }

  //Example2
  public static void exampleTwo(){
    System.out.println("-----TEST 2-----");

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
