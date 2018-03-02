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
                curr = curr.right;
            }else{
                curr = curr.left;
            }
          }
        }
        return false;
      }
  }

  public void insert(int target){
      Node curr = root;

      if(curr == null){
        root = new Node(target);
        return;
      }else{
        Node temp = curr;
        while(curr.left != null && curr.right != null){
          int nodeCheck = curr.key;

          if(nodeCheck == target){
            curr.key = target;
          }else{
            if(nodeCheck > target){
                temp = curr;
                curr = curr.right;
            }else{
                temp = curr;
                curr = curr.left;
            }
          }
        }

        curr.key = target;
        curr.parent = temp;
        System.out.print(curr.parent.key);
      }

  }

  public void delete(int target){
    Node curr = root;

    boolean foundTarget = search(target);
    //make sure the target being deleted is in the tree
    if(foundTarget){
      //get the node up to date
      while(curr.left != null && curr.right != null){
        int nodeCheck = curr.key;

        if(nodeCheck == target){
          break;
        }else{
          if(nodeCheck > target){
              curr = curr.right;
          }else{
              curr = curr.left;
          }
        }
      }
      //case 1: if the node being deleted has no children
      if (curr.left == null && curr.right == null){
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

      }

    }

  }

  public void traverse(){
      Node curr = root;

      actuallyTraverse(curr);
  }

  public void actuallyTraverse(Node node){
      if(node == null){
        System.out.print("");
      }else{
        actuallyTraverse(node.left);
        System.out.print(node.key + " ");
        actuallyTraverse(node.right);
      }
  }


}
