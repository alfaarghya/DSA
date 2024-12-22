import java.util.LinkedList;
import java.util.Queue;

class BinaryTree {

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
  int index = -1;

  /*---- Calling Function ----*/
  BinaryTree(int[] data) {
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

  /*---- ----*/

  /*---- Working Function ----*/
  private Node buildTree(int[] data) { // TC => O(n)
    index++; // increase the index

    // base case => the Node is empty
    if (data[index] == -1) {
      return null;
    }
    // step1 => Create a Node with data
    Node newNode = new Node(data[index]);
    // step2 => build left side of the tree
    newNode.left = buildTree(data);
    // step3 => build right side of the tree
    newNode.right = buildTree(data);

    return newNode;
  }

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

}

public class Implement_BinaryTree {
  public static void main(String[] args) {
    int[] data = { 1, 2, 4, 7, -1, -1, -1, 5, -1, 8, 11, -1, -1, -1, 3, -1, 6, 9, -1, 12, -1, -1, 10, -1, -1 };
/*
             1
           /   \
          2     3
         / \     \
        4   5     6
       /     \   / \ 
      7       8 9   10
             /   \
            11    12
 */
    BinaryTree bt = new BinaryTree(data);
    System.out.println("root ---> " + bt.root.data);
    bt.preOrderTraversal();
    bt.inOrderTraversal();
    bt.postOrderTraversal();
    bt.levelOrderTraversal();
  }
}
