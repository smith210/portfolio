//Name: Martin Smith
//CSCI 241 - Winter 2018
//File: BST.java

public class BST{

  Node root;

  public BST(){
      root = null;
  }

  public boolean search(int target){
      Node curr = root;

      if(curr == null){
        return false;
      }else{
        while(curr.left != null && curr.right != null){
          int nodeCheck = curr.key;

          if(nodeCheck == target){
            return true;
          }else{
            if(nodeCheck > target){
                nodeCheck = curr.right;
            }else{
                nodeCheck = curr.left;
            }
          }
        }
        return false;
      }
  }

  public void insert(int target){
      Node curr = root;

      if(curr == null){
        curr = new Node(target);
      }else{
        while(curr.left != null && curr.right != null){
          int nodeCheck = curr.key;

          if(nodeCheck == target){
            curr.key = target;
          }else{
            if(nodeCheck > target){
                curr = curr.right;
            }else{
                curr = curr.left;
            }
          }
        }
        curr.key = target;
      }

  }

  public void delete(int target){
    Node curr = root;
    Node currParent = curr.parent;
    boolean foundTarget = search(target);
    //make sure the target being deleted is in the tree
    if(foundTarget){
      //get the node up to date
      while(curr.left != null && curr.right != null){
        int nodeCheck = curr.key;

        if(nodeCheck == target){
          break;
        }else{
          currParent = curr;
          if(nodeCheck > target){
              curr = curr.right;
          }else{
              curr = curr.left;
          }
        }
      }
      //case 1: if the node being deleted has no children
      if (curr.left == null && curr.right == null){
        root.key = null;
      //case 2.1: if the node has only one child/one subtree -left
      } else if (curr.left != null){

      //case 2.2: if the node has only one child/one subtree -right
      } else if (curr.right != null){

      //case 3: if the node has two subtrees(both left and right)
      }else{


      }

    }

  }

  public void traverse(){


  }


}
