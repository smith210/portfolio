//Name: Martin Smith
//CSCI 241 - Winter 2018
//File: BSTTest.java
import java.util.*;

public class BSTApp{

  public static ArrayList<Integer> getTable(ArrayList<Integer> template, Node root){
    if(root != null){
      getTable(template, root.left);
      template.add(root.key);
      getTable(template, root.right);
    }
    return template;
  }

  public static int minDiff(Node root){
    ArrayList<Integer> data = new ArrayList<Integer>(5);
    data = getTable(data, root);
    int diff = -1;
    for(int i = 0; i < data.size() - 1; i++){
      int newDiff = data.get(i+1) - data.get(i);
      if (diff == -1 || diff > newDiff){
        diff = newDiff;
      }
    }
    return diff;
  }

  //display
  public static void display(BST tree){
    System.out.print("The traverse gives the BST as: ");
    tree.traverse();
    System.out.println(".");

    int smallestDiff = minDiff(tree.root);
    System.out.println("The minimum absolute difference is " + smallestDiff + ".");
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
    //insert 1
    insert(shrub, 1);


    //insert 25
    insert(shrub, 25);
    //insert 45
    insert(shrub, 45);
    //insert 26
    insert(shrub, 26);
    //insert 36
    insert(shrub, 36);




    insert(shrub, 30);



    remove(shrub, 30);

    remove(shrub, 45);

    remove(shrub, 26);

    remove(shrub, 25);

    display(shrub);


  }

  //Example2
  public static void exampleTwo(){
    System.out.println("-----TEST 2-----");

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
