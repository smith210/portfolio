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
      if(root == null){
        root = new Node(target);
      }else{
        while(root.left != null && root.right != null){
          int nodeCheck = root.key;

          if(nodeCheck == target){
            root.key = target;
          }else{
            if(nodeCheck > target){
                root = root.right;
            }else{
                root = root.left;
            }
          }
        }
        root.key = target;
      }

  }

  public void delete(int target){
    Node currParent = root.parent;
    boolean foundTarget = search(target);

    if(foundTarget){
      while(root.left != null && root.right != null){
        int nodeCheck = curr.key;

        if(nodeCheck == target){
          break;
        }else{
          currParent = root;
          if(nodeCheck > target){
              root = root.right;
          }else{
              root = root.left;
          }
        }
      }

      if (r)

    }

  }

  public void traverse(){


  }


}
