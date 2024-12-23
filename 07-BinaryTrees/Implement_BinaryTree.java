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

  public void heightOfTree() {
    System.out.println("Height of the tree >> " + height(root));
  }

  public void countNodes() {
    System.out.println("Number of Nodes in the tree >> " + count(root));
  }

  public void sumOfTree() {
    System.out.println("Sum of the tree >> " + sum(root));
  }

  public void diameterOfTree() {
    System.out.println("Diameter of the tree >> " + diameter(root).diameter);
  }

  /*---- ----*/

  /*---- Working Function ----*/

  /*---- build a tree form array ----*/
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
  /*---- ----*/

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

  /*---- height of the tree ----*/
  private int height(Node root) { // TC => O(n)
    // base case => it's a leaf Node
    if (root == null) {
      return 0;
    }

    // step1 => travel left side of the current tree
    int leftHeight = height(root.left);
    // step2 => travel right side of the current tree
    int rightHeight = height(root.right);
    // step3 => calculate the height of the current tree
    return Math.max(leftHeight, rightHeight) + 1;
  }
  /*---- ----*/

  /*---- count of the Node of tree ----*/
  private int count(Node root) { // TC => O(n)
    // base case => it's a leaf Node
    if (root == null) {
      return 0;
    }

    // step1 => travel left side of the current tree
    int leftCount = count(root.left);
    // step2 => travel right side of the current tree
    int rightCount = count(root.right);
    // step3 => count the Node of the current tree
    return leftCount + rightCount + 1;
  }
  /*---- ----*/

  /*---- sum of the tree ----*/
  private int sum(Node root) { // TC => O(n)
    // base case => it's a leaf Node
    if (root == null) {
      return 0;
    }

    // step1 => travel left side of the current tree
    int leftSum = sum(root.left);
    // step2 => travel right side of the current tree
    int rightSum = sum(root.right);
    // step3 => calculate the sum of the current tree
    return leftSum + rightSum + root.data;
  }
  /*---- ----*/

  /*---- calculate diameter ----*/
  private static class Info {
    int diameter;
    int height;

    Info(int diameter, int height) {
      this.diameter = diameter;
      this.height = height;
    }
  }

  private Info diameter(Node root) {
    // base case => it's a leaf Node
    if (root == null) {
      return new Info(0, 0);
    }

    // step1 => travel left side of the current tree
    Info leftInfo = diameter(root.left);
    // step2 => travel right side of the current tree
    Info rightInfo = diameter(root.right);
    // step3 => calculate the diameter & height
    int diam = Math.max(Math.max(leftInfo.diameter, rightInfo.diameter), leftInfo.height + rightInfo.height + 1);
    int ht = Math.max(leftInfo.height, rightInfo.height) + 1;
    // step4 => retrun from current tree
    return new Info(diam, ht);
  }

  /*---- ----*/

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
    bt.heightOfTree();
    bt.countNodes();
    bt.sumOfTree();
    bt.diameterOfTree();
  }
}
