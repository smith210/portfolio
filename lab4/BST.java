//Name: Martin Smith
//CSCI 241 - Winter 2018
//File: BST.java

public class BST{

  Node root;

  public BST(){
      root = null;
  }

  public boolean search(int target){
      //create a pointer value
      Node curr = root;
      //if there is no node, return false (target will not be there)
      if(curr == null){
        return false;
      }else{
        //loop through the tree until can't no more
        while(curr != null){
            int nodeCheck = curr.key;
            //check to see if the key is equal to the target
            //if it is, return true
            if (nodeCheck == target){
              System.out.println("VALUE IN BST EXISTS");
              return true;
            }
            //if its not, go through the tree in repsective direction

            //Go right if the target is bigger than current key
            if (nodeCheck < target){
                curr = curr.right;
            //Go left if the target is smaller than the current key
            }else{
                curr = curr.left;
            }
        }
        //if out of the loop, return false
        System.out.println("NO SUCH VALUE EXISTS");
        return false;
      }
  }

    public void insert(int target){
      //update values of root (w/ help from insertHelp)
      root = insertHelp(root, null, target);

    }

    public Node insertHelp(Node node, Node guardian, int target){

        //if the node starts at as null, create new node and return.
        if(node == null){
          node = new Node(target);
          return node;
        }

        int nodeCheck = node.key;
        //if target value is equal to the key value, return node
        if(nodeCheck == target){
            return node;
        //if target value is bigger, go through right subtree
        }else if (nodeCheck < target){

          System.out.println("GOING RIGHT");
          //parse through the right subtree of node
          node.right = insertHelp(node.right, node, target);
          //set parent value of node to the guardian
          node.parent = guardian;
        //if target value is smaller, go through left subtree
        }else{
          System.out.println("GOING LEFT");
          //parse through the left subtree of node
          node.left = insertHelp(node.left, node, target);
          //set parent value of node to the guardian
          node.parent = guardian;
        }


        return node;
    }



  public void delete(int target){

    boolean foundTarget = search(target);
    //make sure the target being deleted is in the tree
    if(foundTarget){
      //get the node up to date
      root = deleteHelper(root, target);
      //case 1: if the node being deleted has no children
      /*if (curr.left == null && curr.right == null){
        curr = null;
      //case 2.1: if the node has only one child/one subtree -left
      } else if (curr.right == null){
        //connect child to parent
        curr.parent.left = curr.left;

      //case 2.2: if the node has only one child/one subtree -right
    } else if (curr.left == null){
        //connect child to parent
        curr.parent.right = curr.right;

      //case 3: if the node has two subtrees(both left and right)
      }else{
        //go to the right subtree to find the smallest value
        Node smallest = curr.right;
        while(smallest.left != null){
          smallest = smallest.left;
        }
        int smallestKey = smallest.key;
        //delete the node at the smallest value
        delete(smallestKey);
        //set the smallest value equal to where curr is
        curr.key = smallestKey;

      }*/

    }

  }

  public Node deleteHelper(Node node, int target){
      int nodeCheck = node.key;
      if (nodeCheck < target){
          System.out.println("GRIM REAPER GOING RIGHT");
          node.right = deleteHelper(node.right, target);
          return node;
      }else if (nodeCheck > target){
          System.out.println("GRIM REAPER GOING LEFT");
          node.left = deleteHelper(node.left, target);
          return node;
      }else{
        //case 1: if the node being deleted has no children
        if (node.left == null && node.right == null){
          System.out.println("NODE HAS NO CHILDREN TO PASS ITS LEGACY TO");
          node = null;
          return node;
        //case 2.1: if the node has only one child/one subtree -left
        }else if (node.right == null){
          System.out.println("NODE HAS A LEFT CHILD TO PASS ITS LEGACY TO");
          node = childCustody(node, node.left);
          return node;
        //case 2.2: if the node has only one child/one subtree - right
        }else if (node.left == null){
          System.out.println("NODE HAS A RIGHT CHILD TO PASS ITS LEGACY TO");
          node = childCustody(node, node.right);
          return node;
        //case 3: if the node has both children/both subtrees
        }else{
          System.out.println("NODE HAS BOTH CHILDREN TO PASS ITS LEGACY TO");
          //find the smallest node on the right side of the family
          int smallest = findSmallest(node);
          //delete the spot where the smallest node originally was
          node = deleteHelper(node, smallest);
          //complete transaction by replacing the node value with smallest
          node.key = smallest;
          //make sure the new guardian is known by the children
          System.out.println(node.right.parent.key);
          System.out.println(node.left.parent.key);
          return node;
        }
      }
  }

  public Node childCustody(Node deceased, Node child){
      System.out.println(deceased.parent.key);

      //if the deceased has no parents, replace deceased with its child
      if (deceased.parent == null){
          deceased = child;
          return deceased;
      //if the deceased is parents right child
      } else if(deceased.parent.right == deceased){
          //give custody of child to the parent of the deceased
          System.out.println("RIGHT PARENT HAS CONFERRED WITH CHILD");
          deceased.parent.right = child;
          child.parent = deceased.parent;
          //replace deceased with the living child
          deceased = child;
          System.out.println("THE CHILD HAS REPLACED THE DECEASED");
          return deceased;
      //if the deceased is parents left child
      } else {
          //give custody of child to the parent of the deceased
          System.out.println("LEFT PARENT HAS CONFERRED WITH CHILD");
          deceased.parent.left = child;
          child.parent = deceased.parent;
          //replace deceased with the living child
          deceased = child;
          System.out.println("THE CHILD HAS REPLACED THE DECEASED");
          return deceased;
      }

  }

  public int findSmallest(Node node){
      Node journeyForSmall = node.right;
      while(journeyForSmall.left != null){
        journeyForSmall = journeyForSmall.left;
      }
      return journeyForSmall.key;

  }

  public void traverse(){
      actuallyTraverse(root);
  }

  public void actuallyTraverse(Node node){
      if(node != null){
        actuallyTraverse(node.left);
        System.out.print(node.key + " ");
        actuallyTraverse(node.right);
      }
  }


}
