import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

class BinarySearchTree {
/*---- Node ----*/
  class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
      this.data = data;
      this.left = null;
      this.right = null;
    }
  }
  /*---- ----*/

  Node root;

/*---- Calling Function ----*/

  BinarySearchTree(int[] data) {
    this.root = buildTree(data);
  }

  public void preOrderTraversal() {
    System.out.print("Pre-order Traversal >> ");
    preOrderTraversal(root);
    System.out.println();
  }

  public void inOrderTraversal() {
    System.out.print("In-order Traversal >> ");
    inOrderTraversal(root);
    System.out.println();
  }

  public void postOrderTraversal() {
    System.out.print("Post-order Traversal >> ");
    postOrderTraversal(root);
    System.out.println();
  }

  public void levelOrderTraversal() {
    System.out.print("Level-order Traversal >> \n");
    levelOrderTraversal(root);
    System.out.println();
  }
  
  public void insert(int value) {
    insert(root, value);
  }

  public void search(int key) {
    System.out.println("is "+key+" avaible?(true/false)");
    System.out.println(">> "+search(root, key));
  }
  /*---- ----*/

  /*---- Working Function ----*/

/*---- build a tree form array ----*/
  private Node buildTree(int[] data) { // TC => O(n)
    System.out.println("1. 1st Element will be Root Node \n2. nth Element will be root Node");
    System.out.print("Press(1 or 2) >> ");
    
    Scanner scn = new Scanner(System.in);
        
    int n = scn.nextInt();
    switch (n) {
      case 1:
        return buildBST_PreOrderRoot(data);
        
      case 2:
        return buildBST_PostOrderRoot(data);

      default:
        System.out.println("wrong choice");
        return null;
    }
  }
    /*---- Build BST from pre-order dataset ----*/
  private Node buildBST_PreOrderRoot(int[] data) {
    Node root = null;
      //run a loop and insert the data
    for(int i = 0; i < data.length; i++) {
      root = insert(root, data[i]);
    }

    return root;
  }
    /*---- Build BST from post-order dataset ----*/
  private Node buildBST_PostOrderRoot(int[] data) {
    Node root = null;
      //run a loop and insert the data
    for(int i = data.length - 1; i >= 0; i--) {
      root = insert(root, data[i]);
    }

    return root;
  }
  /*---- ----*/

  private Node insert(Node root, int value) { 
    //base case => we reach leaf Node so add here
    if(root == null) {
      return new Node(value);
    }

    //step1 => data is small than current root -> store it in the left side of current root
    if(value < root.data) {
      root.left = insert(root.left, value);
    }
    //step2 => data is greater than current root -> store it in the right side of current root
    else {
      root.right = insert(root.right, value);
    }

    return root;
  }

  /*---- pre-order Traversal on tree ----*/
  private void preOrderTraversal(Node root) { // TC => O(n)
    // base case => we reach leaf Node
    if (root == null) {
      return;
    }
    // step1 => print the data
    System.out.print(root.data + " ");
    // step2 => travel the left side of current tree
    preOrderTraversal(root.left);
    // step3 => travel the right side of current tree
    preOrderTraversal(root.right);
  }
  /*---- ----*/

  /*---- in-order Traversal on tree ----*/
  private void inOrderTraversal(Node root) { // TC => O(n)
    // base case => we reach leaf Node
    if (root == null) {
      return;
    }
    // step1 => travel the left side of current tree
    inOrderTraversal(root.left);
    // step2 => print the data
    System.out.print(root.data + " ");
    // step3 => travel the right side of current tree
    inOrderTraversal(root.right);
  }
  /*---- ----*/

  /*---- post-order Traversal on tree ----*/
  private void postOrderTraversal(Node root) { // TC => O(n)
    // base case => we reach leaf Node
    if (root == null) {
      return;
    }
    // step1 => travel the left side of current tree
    postOrderTraversal(root.left);
    // step2 => travel the right side of current tree
    postOrderTraversal(root.right);
    // step3 => print the data
    System.out.print(root.data + " ");
  }
  /*---- ----*/

  /*---- level-order Traversal on tree ----*/
  private void levelOrderTraversal(Node root) { // TC => O(n)
    // corner case => tree is empty
    if (root == null) {
      return;
    }

    // create A queue
    Queue<Node> q = new LinkedList<>();

    q.add(root); // add root & a null
    q.add(null); // here null refers to next line

    while (!q.isEmpty()) {
      Node current = q.remove();

      if (current == null) { // new level
        System.out.println();

        if (q.isEmpty()) {
          break;
        } else {
          q.add(null);
        }
      } else { // print value
        System.out.print(current.data + " ");

        if (current.left != null) { // if node's left side is not empty add left side value to queue
          q.add(current.left);
        }

        if (current.right != null) { // if node's right side is not empty add right side value to queue
          q.add(current.right);
        }
      }
    }

  }
  /*---- ----*/
  
  /*---- Search in BST ----*/
  private boolean search(Node root, int key) {
    //base case 1 =>  we reach leaf Node
    if(root == null) {
      return false;
    }
    //base case 2 => key and data match
    if(root.data == key) {
      return true;
    }

      //step1 => search left side of current root
    if(key < root.data) {
      return search(root.left, key);
    } 
      //step2 => search right side of current root
    else {
      return search(root.right, key);
    }
  }
  /*---- ----*/

  /*---- ----*/

}

public class Implement_BinarySearchTree {
  public static void main(String[] args) {
    int[] dataSet1= {8, 5, 3, 1, 4, 14, 10, 11, 6};
    
    BinarySearchTree bst = new BinarySearchTree(dataSet1);
        
    System.out.println("root >> " +bst.root.data);
    bst.inOrderTraversal();
    bst.preOrderTraversal();
    bst.postOrderTraversal();
    bst.levelOrderTraversal();
        
    bst.insert(9);
    bst.inOrderTraversal();
    bst.levelOrderTraversal();

    bst.search(7);
  }
}
