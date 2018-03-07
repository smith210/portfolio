//Name: Martin Smith
//CSCI 241 - Winter 2018
//File: BSTTest.java
import java.util.*;

public class BSTApp{

  public static ArrayList<Integer> getTable(ArrayList<Integer> template, Node root){
    //add all the elements from the tree into the ArrayList (in order of small to large)
    //this is similar to the traverse method in BST.java
    if(root != null){
      getTable(template, root.left);
      template.add(root.key);
      getTable(template, root.right);
    }
    return template;
  }

  public static int minDiff(Node root){
    //create empty ArrayList
    ArrayList<Integer> data = new ArrayList<Integer>(5);
    //put all the values from the tree into the ArrayList
    data = getTable(data, root);
    int diff = 0;
    for(int i = 0; i < data.size() - 1; i++){
      //check if there is more than one element in the tree
      if(data.get(i+1) != null){
        //save temporary value of difference between the two numbers
        int newDiff = data.get(i+1) - data.get(i);
        //compare the old and new value of diff, set the smaller one equal to diff
        if (diff == 0 || diff > newDiff){
          diff = newDiff;
        }
      //set diff to 0 if is only one element in the tree
      }else{
        diff = 0;
      }
    }
    return diff;
  }

  //display - Same as BSTTest, tweaked to have minDiff invoked
  public static void display(BST tree){
    System.out.print("The traverse gives the BST as: ");
    tree.traverse();
    System.out.println(".");
    //find smallest difference in the tree (invoke minDiff method)
    int smallestDiff = minDiff(tree.root);
    //print out smallest difference for user
    System.out.println("The minimum absolute difference is " + smallestDiff + ".");
  }

  //insert - Same as BSTTest
  public static void insert(BST tree, int num){
    System.out.println("Inserting " + num + " into the BST.");
    tree.insert(num);

  }

  //remove - Same as BSTTest
  public static void remove(BST tree, int num){
    System.out.println("Deleting " + num + " from the BST.");
    tree.delete(num);
  }

  //Example1
  public static void exampleOne(){
    //test to determine the outcome
    System.out.println("-----TEST 1-----");
    //create new BST
    BST shrub = new BST();

    //test - diff should be 1
    insert(shrub, 19);
    insert(shrub, 1);
    insert(shrub, 25);
    insert(shrub, 45);
    insert(shrub, 26);
    insert(shrub, 36);
    insert(shrub, 30);
    display(shrub);

    //test - diff should be 17
    remove(shrub, 30);
    remove(shrub, 45);
    remove(shrub, 26);
    remove(shrub, 25);
    display(shrub);

    //test - diff should be 3
    insert(shrub, 39);
    insert(shrub, 46);
    display(shrub);

    //test - diff should be 10
    remove(shrub, 39);
    remove(shrub, 1);
    display(shrub);


  }

  //Example2
  public static void exampleTwo(){
    System.out.println("-----TEST 2-----");
    BST shrub = new BST();
    //test - try to get an empty tree to display a difference
    display(shrub);
    //test - try to get a tree with only one value to display a difference
    insert(shrub, 19);
    display(shrub);
    int del = 0;
    //add random numbers
    for (int i = 0; i < 10; i++){
        int value = (int) (Math.random()*100+1);
        insert(shrub, value);
        if (i == 5){
          del = value;
        }
    }
    remove(shrub, del);
    display(shrub);


  }
  //main method
  public static void main(String[] args){
      System.out.println("Testing of BSTApp Starting...");
      //call exampleOne
      exampleOne();
      //call exampleTwo
      exampleTwo();

      System.out.println("Testing of BSTApp Finished.");
  }
}
